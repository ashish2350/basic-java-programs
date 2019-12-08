package movieticketsbooking;

public class Address {
	private String street, town, phno;

	public Address(String street, String town, String phno) {
		this.street = street;
		this.town = town;
		this.phno = phno;
	}

	public String getStreet() {
		return this.street;
	}

	public String getTown() {
		return this.town;
	}

	public String getPhno() {
		return this.phno;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String toString() {
		return " Street: " + this.street + ", Town: " + this.town + ", Phone: " + this.phno;
	}
}