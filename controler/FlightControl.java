package controler;

import java.util.HashMap;
import java.util.Map;

import model.Costomer;
import model.Flight;
import repository.FlightTicketDatabase;
import view.FlightDetails;

public class FlightControl {

	private FlightDetails flightDetails;

	public FlightControl() {

	}

	public FlightControl(FlightDetails flightDetails) {

		this.flightDetails = flightDetails;
	}

	public HashMap<Integer, Flight> getFlightList() {
		return FlightTicketDatabase.getInstanse().getFlights();
	}

	public int getFlightNumber(int pnrId) {

		for (Map.Entry<Integer, HashMap<Integer, Costomer>> ticket : FlightTicketDatabase.getInstanse()
				.getTicketDetails().entrySet()) {

			if (ticket.getValue().containsKey(pnrId)) {
				return ticket.getKey();
			}

		}
		return 0;

	}

	public boolean seatAvailableOrNot(int flightId) {
		if (FlightTicketDatabase.getInstanse().getFlights().get(flightId).getAvailableSeats() > 0) {
			return true;
		}
		return false;

	}

	public void setSeatAvailability(int flightId) {
		if (FlightTicketDatabase.getInstanse().getFlights().get(flightId).getAvailableSeats() > 0) {

			FlightTicketDatabase.getInstanse().getFlights().get(flightId).setAvailableSeats(
					FlightTicketDatabase.getInstanse().getFlights().get(flightId).getAvailableSeats() - 1);

		}

	}
}
