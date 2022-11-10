package view;

import java.util.HashMap;
import java.util.Scanner;
import model.Costomer;
import model.Flight;
import repository.FlightTicketDatabase;

public class CreateNewFlightRoute {
    public void addFlight() {
    	System.out.println(
				"---------------------------------------------------------------------------------------------");
    	Scanner scanner=new Scanner(System.in);
    	System.out.print(" Enetr Flight Number");
    	int flightNumber=scanner.nextInt();
    	System.out.print("Enter the Total Number Of Seats");
    			int seat=scanner.nextInt();
    			System.out.println("Enter Flight Name");
    			String flightName=scanner.nextLine();
    			System.out.println("From ");
    			String from=scanner.nextLine();
    			System.out.println("To");
    			String to =scanner.nextLine();
    			System.out.println(" Eneter Travel Amount");
    			int amount=scanner.nextInt();
    			
    			FlightTicketDatabase.getInstanse().getFlights().put(flightNumber, new Flight(flightNumber,seat,from,to,amount,flightName));
    			 FlightTicketDatabase.getInstanse().getTicketDetails().put(flightNumber,new  HashMap<Integer,Costomer>());
    }
    
   public void defaultFlight() {
	   FlightTicketDatabase.getInstanse().getFlights().put(301, new Flight(301,2,"Tirunelveli","Chennai",10000,"Delhi Airways"));
	   FlightTicketDatabase.getInstanse().getTicketDetails().put(301,new  HashMap<Integer,Costomer>());
   }
    
}
