package view;
import java.util.Map;

import model.Costomer;
import repository.FlightTicketDatabase;

import java.util.HashMap;

import java.util.Scanner;

import controler.CostomerControl;
import controler.FlightControl;
import controler.TicketProcessing;

public class TicketReservation {
	private Scanner scanner = new Scanner(System.in);

	private CostomerControl costomerControl;
	private TicketProcessing ticketProcess;

	public TicketReservation() {

		costomerControl = new CostomerControl(this);

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

			costomerControl.addCostomer(flightNumber,
					new Costomer(name, gender, age, pnrId, flightNumber, from, to, amount, "Booked"), pnrId);

			flightControl.setSeatAvailability(flightNumber);
			costomerControl.changePasangerId(pnrId);

			System.out.println("Your PNR Id Is" + "    : " + pnrId);
			int passangerId=FlightTicketDatabase.getInstanse().getCostomer(pnrId).getPassagerId();
			System.out.println("Your Id IS "+passangerId);
		} else {
			System.out.println("Seats Are Not Available !");

		}
	}

	public void ticketCancelation() {
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.print("Enetr PNR Number  : ");
		int pnrId = scanner.nextInt();

		if (costomerControl.ContomerVerification(pnrId)) {
			FlightControl flightControl = new FlightControl();
           System.out.println("\n You Want to Cancel The Ticket \n press 1 to Confirm\n press Any Key To Exit " );
            if (scanner.next().equals("1")) {
            	System.out.println("Pleace Get The Amount refunded ! \n Rs." + FlightTicketDatabase.getInstanse()
				.getFlights().get(flightControl.getFlightNumber(pnrId)).getAmount());
			System.out.println(ticketProcess.ticketCancel(pnrId, flightControl.getFlightNumber(pnrId)));
			
            }
            else {
            	System.out.println("Thank you For Visiting ");
            }
		} else {
			System.out.println("Incorrect PNR Id !");
		}

	}
	
	public void showBookedTickets() {
		for(Map.Entry<Integer,HashMap<Integer,Costomer>> ticket:ticketProcess.getTicketDetails().entrySet()){
			if(!ticket.getValue().isEmpty()) {
			  for(Map.Entry<Integer,Costomer> costomers:ticket.getValue().entrySet()) {
				  System.out.println("Costomer Name : "+costomers.getValue().getCostomerName()+"  PNR Id : "+costomers.getKey()+"  Flight ID : "+costomers.getValue().getFlightId()+"  Ticket Amount "+costomers.getValue().getAmount()+"  From :"+costomers.getValue().getFrom()+"  TO : "+costomers.getValue().getTo());
			  }
			}
			else {
				System.out.println(" No Data Fount !");
			}
		}
	}

}
