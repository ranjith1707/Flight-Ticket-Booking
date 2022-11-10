package view;

import java.util.HashMap;
import java.util.Map;

import controler.FlightControl;

import java.util.*;
import model.Flight;

public class FlightDetails {

	private FlightControl flightcontrol;

	public FlightDetails() {
		flightcontrol = new FlightControl(this);
	}

	public int printDetails() {
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select The Flight");
		HashMap<Integer, Flight> flights = flightcontrol.getFlightList();

		for (Map.Entry<Integer, Flight> flight : flights.entrySet()) {
			System.out.println("Flight id :" + flight.getKey() + "\n from : " + flight.getValue().getFrom()
					+ "\n  to : " + flight.getValue().getTo() + " \n amout : " + flight.getValue().getAmount()
					+ "\n Available Seats : " + flight.getValue().getAvailableSeats());
		}

		System.out.println("Enter the Flight number ");

		return scanner.nextInt();
	}

	public void printFlightDetails() {

		Scanner scanner = new Scanner(System.in);
		System.out.println();
		HashMap<Integer, Flight> flights = flightcontrol.getFlightList();

		for (Map.Entry<Integer, Flight> flight : flights.entrySet()) {
			System.out.println("Flight id :" + flight.getKey() + "\n from : " + flight.getValue().getFrom()
					+ "\n  to : " + "Flight Name : " + flight.getValue().getFlightName() + flight.getValue().getTo()
					+ " \n amout : " + flight.getValue().getAmount() + "\n Available Seats : "
					+ flight.getValue().getAvailableSeats());
		}
		System.out.println("--------------------------------------------------------------------------- \n ");

	}
}


