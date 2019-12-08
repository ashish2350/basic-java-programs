public class Ticket
{
	
	private static int totalSeats=250;
	private String showName;
	private int availableSeats;
	private double price;
	private Movie movie;

	public Ticket(String showName,double price,Movie movie)
	{
		this.showName=showName;
		this.availableSeats = Ticket.totalSeats;
		this.price = price;
		this.movie = movie;
	}

	public void subAvailableSeats(int no)
	{
		this.availableSeats=this.availableSeats - no;
	}

	public void addAvailableSeats(int no)
	{
		this.availableSeats=this.availableSeats + no;
	}

	public static int getTotalSeats()
	{
		return Ticket.totalSeats;
	}

	public String getShowName()
	{
		return this.showName;
	}

	public int getAvailableSeats()
	{
		return this.availableSeats;
	}

	public double getPrice()
	{
		return this.price;
	}

	public Movie getMovie()
	{
		return this.movie;
	}
}