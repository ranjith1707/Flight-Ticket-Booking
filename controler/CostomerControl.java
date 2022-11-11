package controler;

import java.util.HashMap;
import java.util.Map;

import model.Costomer;
import repository.FlightTicketDatabase;
import view.CostomerDetails;
import view.TicketReservation;

public class CostomerControl {
	private CostomerDetails costomerDetails;
	private TicketReservation ticketReservation;

	public CostomerControl(CostomerDetails costomerDetails) {
		this.costomerDetails = costomerDetails;
	}

	public CostomerControl(TicketReservation ticketReservation) {
		this.ticketReservation = ticketReservation;
	}

	public boolean ContomerVerification(int pnrId) {

		for (Map.Entry<Integer, HashMap<Integer, Costomer>> ticket : FlightTicketDatabase.getInstanse()
				.getTicketDetails().entrySet()) {

			if (ticket.getValue().containsKey(pnrId)) {
				return true;
			}

		}

		return false;
	}

	public Costomer getCostomer(int pnrId) {

		for (Map.Entry<Integer, HashMap<Integer, Costomer>> ticket : FlightTicketDatabase.getInstanse()
				.getTicketDetails().entrySet()) {

			if (ticket.getValue().containsKey(pnrId)) {
				return ticket.getValue().get(pnrId);
			}

		}
		return null;

	}

	public void addCostomer(int flightId, Costomer costomer, int pnrId) {

		FlightTicketDatabase.getInstanse().getFlight(flightId).put(pnrId, costomer);

	}
	
	public void changePasangerId(int pnrId) {
		
		FlightTicketDatabase.getInstanse().getCostomer(pnrId).changeId();     
		
		
	}
	
	
	public Costomer getPassanger(int id) {
		for(Map.Entry<Integer,HashMap<Integer,Costomer>> flights:FlightTicketDatabase.getInstanse().getTicketDetails().entrySet()){
			for(Map.Entry<Integer,Costomer> passangers:flights.getValue().entrySet()) {
				if(passangers.getValue().getPassagerId()==id) {
					return passangers.getValue();
				}
			}
		}
		return null;
		
		
	}

}