package repository;

import java.util.*;

import model.Costomer;
import model.Flight;

public class FlightTicketDatabase {

	private static FlightTicketDatabase flightDB;

	private Map<Integer, HashMap<Integer, Costomer>> ticketDetails;

	private HashMap<Integer, Flight> flightDetails;

	private FlightTicketDatabase() {
		ticketDetails = new LinkedHashMap<Integer, HashMap<Integer, Costomer>>();
		flightDetails = new HashMap<Integer, Flight>();
	}

	public static FlightTicketDatabase getInstanse() {
		if (flightDB == null) {
			flightDB = new FlightTicketDatabase();
		}
		return flightDB;

	}

	public Costomer getCostomer(int costomerId) {
		for (Map.Entry<Integer, HashMap<Integer, Costomer>> details : ticketDetails.entrySet()) {
			if (details.getValue().containsKey(costomerId)) {
				return details.getValue().get(costomerId);
			}
		}
		return null;
	}

	public HashMap<Integer, Flight> getFlights() {
		return flightDetails;
	}

	public Map<Integer, Costomer> getFlight(int flight) {

		return ticketDetails.get(flight);
	}

	public Map<Integer, HashMap<Integer, Costomer>> getTicketDetails() {
		return ticketDetails;

	}

}
