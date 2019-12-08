package movieticketsbooking;

public class Theatre
{
	
	private String name;
	private Address addrs;
	private Ticket ticket;
	
	public Theatre(String name, Address addrs, Ticket ticket)
	{
		this.name = name;
		this.addrs = addrs;
		this.ticket = ticket;
	}

	public String getName()
	{
		return this.name;
	}

	public Address getAddress()
	{
		return this.addrs;
	}

	public Ticket getTicket()
	{
		return this.ticket;
	}
}