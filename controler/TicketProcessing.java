package controler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import repository.FlightTicketDatabase;

import view.TicketReservation;
import model.Costomer;
public class TicketProcessing {

	private TicketReservation ticketReservation;

	public TicketProcessing(TicketReservation ticketReservation) {
		this.ticketReservation = ticketReservation;
	}

	public String ticketCancel(int pnr, int flightId) {

		FlightTicketDatabase.getInstanse().getFlight(flightId).remove(pnr);

		return "<......... Successfully Canceled !...........>";

	}
	
	
	
	public Map<Integer,HashMap<Integer,Costomer>> getTicketDetails(){
		
		return FlightTicketDatabase.getInstanse().getTicketDetails();
		
		
	}

}
