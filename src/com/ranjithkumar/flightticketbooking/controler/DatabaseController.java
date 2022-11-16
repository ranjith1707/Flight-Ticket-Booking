package controler;

import repository.FlightTicketDatabase;

public class DatabaseController {
	public boolean setUp() {

		if (FlightTicketDatabase.getInstanse() != null) {
			return true;
		}
		return false;

	}
}
