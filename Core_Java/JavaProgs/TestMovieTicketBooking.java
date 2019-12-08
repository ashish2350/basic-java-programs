import java.util.*;
public class TestMovieTicketBooking
{
	private static MovieTicketBooking mb;
	private  static Scanner sc;
	private int show;

	public TestMovieTicketBooking()
	{
		mb = new MovieTicketBooking();
		sc = new Scanner(System.in);
	}

	public void book()
	{
		do
		{
			list();
			System.out.print("\n Pls Enter Option for Shows : ");
			show = mb.getOption(4);
			mb.bookTicket(show);
			System.out.print("Do you want to book more?(Yes or No): ");
		}
		while(sc.next().equalsIgnoreCase("YES"));
	}

	public void cancel()
	{
		do
		{
			list();
			System.out.print("\n Pls Enter Option for Shows : ");
			show = mb.getOption(4);
			mb.cancelTicket(show);
			System.out.print("Do you want to cancel more tickets?(Yes or No): ");
		}
		while(sc.next().equalsIgnoreCase("YES"));
	}

	public void list()
	{
		int opt  =mb.printMovies();
		System.out.println("\nMovie Name:"+mb.getMovie()[opt].getName()+"\n");
		mb.printShows();
	}

	public void test()
	{
		while(true)
		{
			System.out.println("\n\n ------Main Menu------ \n0. List of Movies and Availability\n1. Book Tickets\n2. Cancel Tickets\n3. Exit");
			System.out.print("\nPls Enter an option: ");
			int value = sc.nextInt();
			switch(value)
			{
				case 0:	list();
					break;

				case 1:	book();
					break;

				case 2:	cancel();
					break;

				case 3:	System.out.println("\nThank You.");
					System.exit(0);
					break;

				default: System.out.println("\nInvalid Option.");
					 break;
			}
		}
	}

	public static void main(String args[])
	{
		TestMovieTicketBooking t = new TestMovieTicketBooking();
		t.test();
	}
}