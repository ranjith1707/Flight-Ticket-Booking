package model;

public class Costomer {
	private String costomerName;
	private String gender;
	private short age;
	private int id;
	private int flightNumber;
	private String from;
	private String to;
	private int amount;
	private String status;
	private int passagerId = 100;

	public Costomer(String costomerName, String gender, short age, int id, int flightNumber, String from, String to,
			int amount, String status) {
		this.costomerName = costomerName;
		this.gender = gender;
		this.age = age;
		this.id = id;
		this.flightNumber = flightNumber;
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.status = status;
	}

	public String getCostomerName() {
		return costomerName;
	}

	public void setCostomerName(String costomerName) {
		this.costomerName = costomerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlightId() {
		return flightNumber;
	}

	public void setFlightId(int flightId) {
		this.flightNumber = flightId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPassagerId() {
		return passagerId;
	}

	public void setPassagerId(int passagerId) {
		this.passagerId = passagerId;
	}

	public void changeId() {
		int id = getPassagerId();
		setPassagerId(id + 1);
	}

}
