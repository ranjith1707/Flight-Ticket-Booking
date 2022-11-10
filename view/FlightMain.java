package view;

import java.util.Scanner;

import controler.DatabaseController;
import controler.LoginController;

public class FlightMain {
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		FlightMain flightMain = new FlightMain();
		flightMain.init();
	}

	private void init() {
		System.out.println("<...... Welcome to Indian Flight Organisation .......>");

		DatabaseController dbControl = new DatabaseController();
		CreateNewFlightRoute flight = new CreateNewFlightRoute();
		
		if (dbControl.setUp()) {
			System.out.println("Get Ready >>>>!");
			flight.defaultFlight();

			System.out.println("1 > AdminLogin\n 2 > Users \n 3 > Exit");
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				adminLogin();
				break;
			case "2":
				userlogin();
				break;
			case "3":
				break;
			default:
				init();
			}
			

		} else {
			System.out.println("Not Setuped ! ");
		}

	}

	private void menu() {
		TicketReservation ticketreservation = new TicketReservation();
		FlightDetails flightDetail = new FlightDetails();
		CreateNewFlightRoute addFlight=new CreateNewFlightRoute();
		CostomerDetails costomerDetails = new CostomerDetails();
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println(
				"1> Add New Flight \n  2> Ticket Booking \n 3 > Ticket Cancelation \n 4 > Flight Details \n 5 > View Ticket Status \n 6 > Exit");

		String option = scanner.nextLine();
		switch (option) {
		case "2":
			ticketreservation.ticketBooking();
			break;
		case "3":
			ticketreservation.ticketCancelation();
			break;
		case "4":
			flightDetail.printFlightDetails();
			break;
		case "5":
			costomerDetails.thicketDetails();
			break;
		case "1":addFlight.addFlight();
		}

		if (!option.equals("6")) {
			menu();
		}
	}

	private void adminLogin() {
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.print("Enetr The Admin Id : ");
		String adminId = scanner.nextLine();
		System.out.print("Enter Password : ");
		String password = scanner.nextLine();

		LoginController login = new LoginController();

		if (login.loginCheck(adminId, password)) {
			menu();
		} else {
			System.out.println("Incorrect Id Or Password");
		}

	}
	
	private void userlogin(){
		TicketReservation ticketreservation = new TicketReservation();
		FlightDetails flightDetail = new FlightDetails();
		CostomerDetails costomerDetails = new CostomerDetails();
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println(
				" 1> Ticket Booking \n 2 > Ticket Cancelation \n 3 > Flight Details \n 4 > View Ticket Status \n 5 > Exit");

		String option = scanner.nextLine();
		switch (option) {
		case "1":
			ticketreservation.ticketBooking();
			break;
		case "2":
			ticketreservation.ticketCancelation();
			break;
		case "3":
			flightDetail.printFlightDetails();
			break;
		case "4":
			costomerDetails.thicketDetails();
			break;
		}

		if (!option.equals("5")) {
			menu();
		}
	}

}
