package view;

import java.util.Scanner;

import controler.CostomerControl;
import repository.FlightTicketDatabase;

public class CostomerDetails {
	private CostomerControl costomerControl;

	public CostomerDetails() {
		costomerControl = new CostomerControl(this);
	}

	public void thicketDetails() {
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enetr Your PNR ID ");

		int pnrId = scanner.nextInt();
		if (costomerControl.ContomerVerification(pnrId)) {
			String costomerName = costomerControl.getCostomer(pnrId).getCostomerName();
			String gender = costomerControl.getCostomer(pnrId).getGender();
			short age = costomerControl.getCostomer(pnrId).getAge();
			int id = costomerControl.getCostomer(pnrId).getId();
			int flightNumber = costomerControl.getCostomer(pnrId).getFlightId();
			String from = costomerControl.getCostomer(pnrId).getFrom();
			String to = costomerControl.getCostomer(pnrId).getTo();
			int amount = costomerControl.getCostomer(pnrId).getAmount();
			String status = costomerControl.getCostomer(pnrId).getStatus();
			System.out.println("Name : " + costomerName + "\n Age " + age + "\n Gender:" + gender + "\n PNR Id :" + id
					+ "\n Flight Number :" + flightNumber + "\n From : " + from + "To : " + to + "\n Amount" + amount
					+ "\n Status: " + status);
			
		} else {
			System.out.println("User Not Found ! ");
			System.out.println(
					"---------------------------------------------------------------------------------------------");
		}
	}
}
