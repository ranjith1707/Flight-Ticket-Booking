package model;

public class Flight {
	private int flightNubmer;
	private int numberOfSeats;
	private String from;
	private String to;
	private int amount;
	private int generateId = 1000;
	private int availableSeats;
	private String flightName;

	public Flight(int flightNumber, int numberOfSeates, String from, String to, int amount, String flightName) {
		this.flightNubmer = flightNumber;
		this.numberOfSeats = numberOfSeates;
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.availableSeats = numberOfSeates;
		this.flightName = flightName;

	}

	public int getFlightNubmer() {
		return flightNubmer;
	}

	public void setFlightNubmer(int flightNubmer) {
		this.flightNubmer = flightNubmer;
	}

	public int getNumberOfSeates() {
		return numberOfSeats;
	}

	public void setNumberOfSeates(int numberOfSeates) {
		this.numberOfSeats = numberOfSeates;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getGenerateId() {
		return generateId;
	}

	public void setGenerateId(int generateId) {
		this.generateId = generateId;
	}

	public void changeId() {
		int id = getGenerateId();
		setGenerateId(id + 1);
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
}