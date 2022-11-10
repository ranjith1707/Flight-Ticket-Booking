package controler;


import repository.FlightTicketDatabase;
import view.TicketReservation;

public class TicketProcessing {

	private TicketReservation ticketReservation;

	public TicketProcessing(TicketReservation ticketReservation) {
		this.ticketReservation = ticketReservation;
	}

	public String ticketCancel(int pnr, int flightId) {

		FlightTicketDatabase.getInstanse().getFlight(flightId).remove(pnr);

		return "<......... Successfully Canceled !...........>";

	}

}
