package view;

import java.util.HashMap;
import java.util.Map;

import controler.FlightControl;

import java.util.*;
import model.Flight;

public class FlightDetails {
	private Scanner scanner = new Scanner(System.in);
	private FlightControl flightcontrol;

	public FlightDetails() {
		flightcontrol = new FlightControl(this);
	}

	public int printDetails() {
		System.out.println(
				"---------------------------------------------------------------------------------------------");

		System.out.println("Select The Flight");
		HashMap<Integer, Flight> flights = flightcontrol.getFlightList();

		for (Map.Entry<Integer, Flight> flight : flights.entrySet()) {
			System.out.println("Flight id :" + flight.getKey() + "\n from : " + flight.getValue().getFrom()
					+ "\n  to : " + flight.getValue().getTo() + " \n amout : " + flight.getValue().getAmount()
					+ "\n Available Seats : " + flight.getValue().getAvailableSeats());
			System.out.println("\n ");
		}

		System.out.println("Enter the Flight number ");

		return scanner.nextInt();
	}

	public void printFlightDetails() {

		System.out.println();
		HashMap<Integer, Flight> flights = flightcontrol.getFlightList();

		for (Map.Entry<Integer, Flight> flight : flights.entrySet()) {
			System.out.println("Flight id :" + flight.getKey() + "\n from : " + flight.getValue().getFrom()
					+ "\n  to : " + "Flight details : " + flight.getValue().getFlightName() + flight.getValue().getTo()
					+ " \n amout : " + flight.getValue().getAmount() + "\n Available Seats : "
					+ flight.getValue().getAvailableSeats());
			System.out.println("\n ");
		}

		System.out.println("--------------------------------------------------------------------------- \n ");

	}

	public void searchRoutes() {
		System.out.println("Enter From details : ");
		String from = scanner.nextLine();
		System.out.println("Enter To details ");
		String to = scanner.nextLine();
		ArrayList<Flight> flightdetails = flightcontrol.searchFlight(from, to);

		if (!flightdetails.isEmpty()) {
			for (Flight details : flightdetails) {
				System.out.println("Flight details : " + details.getFlightName() + "\n Flight Number : "
						+ details.getFlightNubmer() + "\n From : " + details.getFrom() + "\n To : " + details.getTo()
						+ "\n Available Seats : " + details.getAvailableSeats() + "\n Ticket Price : "
						+ details.getAmount());
			}
		} else {
			System.out.println("Flight Not Available ! ");
		}
	}

}
