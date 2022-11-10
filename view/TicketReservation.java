package view;

import model.Costomer;
import repository.FlightTicketDatabase;

import java.util.Scanner;

import controler.CostomerControl;
import controler.FlightControl;
import controler.TicketProcessing;

public class TicketReservation {
	private Scanner scanner = new Scanner(System.in);

	private CostomerControl control;
	private TicketProcessing ticketProcess;

	public TicketReservation() {
		
		control = new CostomerControl(this);

		ticketProcess = new TicketProcessing(this);
	}

	public void ticketBooking() {
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		FlightControl flightControl = new FlightControl();
		System.out.println("Select Flight ");
		FlightDetails flightTicket = new FlightDetails();
		int flightNumber = flightTicket.printDetails();

		if (flightControl.seatAvailableOrNot(flightNumber)) {

			System.out.print("Enter Your Name  :");
			String name = scanner.nextLine();
			System.out.print("Enetr your Age  :");
			short age = scanner.nextShort();
			System.out.println("Select Gender \n 1> male \n 2 > female\n 3 > Others");
			String option = scanner.next();
			String gender;
			switch (option) {
			case "1":
				gender = "male";
				break;
			case "2":
				gender = "female";
				break;
			default:
				gender = "Others";
			}

			int amount = FlightTicketDatabase.getInstanse().getFlights().get(flightNumber).getAmount();
			System.out.println("Please Pay The Amount  : " + amount);
			int payed = scanner.nextInt();
			while (payed < amount) {
				System.out.println("Amount Not Sufficient");
				int balance = scanner.nextInt();
				payed += amount;
				if (payed > amount) {
					System.out.println("Please Collect The Balance : " + (payed - amount));
				}
			}
			int pnrId = FlightTicketDatabase.getInstanse().getFlights().get(flightNumber).getGenerateId();

			FlightTicketDatabase.getInstanse().getFlights().get(flightNumber).changeId();

			String from = FlightTicketDatabase.getInstanse().getFlights().get(flightNumber).getFrom();

			String to = FlightTicketDatabase.getInstanse().getFlights().get(flightNumber).getTo();

			control.addCostomer(flightNumber,
					new Costomer(name, gender, age, pnrId, flightNumber, from, to, amount, "Booked"), pnrId);

			flightControl.setSeatAvailability(flightNumber);

			System.out.println("Your PNR Id Is : " + pnrId);
		} else {
			System.out.println("Seats Are Not Available !");

		}
	}

	public void ticketCancelation() {
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.print("Enetr PNR Number  : ");
		int pnrId = scanner.nextInt();

		if (control.ContomerVerification(pnrId)) {
			FlightControl flightControl = new FlightControl();

			System.out.println(ticketProcess.ticketCancel(pnrId, flightControl.getFlightNumber(pnrId)));
			System.out.println("Pleace Get The Amount refunded ! \n Rs." + FlightTicketDatabase.getInstanse()
					.getFlights().get(flightControl.getFlightNumber(pnrId)).getAmount());
		} else {
			System.out.println("Incorrect PNR Id !");
		}

	}

}
