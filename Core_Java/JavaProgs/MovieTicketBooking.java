import java.util.*;
public class MovieTicketBooking
{

	private Scanner sc;
	private Movie movie[] = new Movie[4];
	private Theatre th[] = new Theatre[4];
	private Address addrs[] = new Address[4];
	private Ticket ticket[] = new Ticket[4];
	
	public MovieTicketBooking()
	{
			sc = new Scanner(System.in);
			addrs[0] =  new Address(" Tank Bund Road "," NTR Garden "," 9866114049 ");
			addrs[1] =  new Address(" Hyderabad Central Road "," Punjagutta "," 9866226709 ");
			addrs[2] =  new Address(" Road No. 2 "," Banjara Hills "," 9908461852 ");
			addrs[3] =  new Address(" Jawaharlal Nehru Road "," Koti "," 9603076808 ");
				
			movie[0] =  new Movie(" Nayak "," Ramcharan "," Kajal Aggarwal - Amala Paul "," Devi Sri Prasad ");
			movie[1] =  new Movie(" Sarocharu "," Ravi Teja "," Kajal Aggarwal "," Devi Sri Prasad ");
			movie[2] = new Movie(" Yeto Vellipoyindhi Manasu "," Nani "," Samantha "," Ilaiyaraaja ");
			movie[3] = new Movie(" Damarukam "," Nagarjuna "," Anushka Shetty"," Devi Sri Prasad ");
			
			ticket[0] = new Ticket(" Morning Show(10:00 A.M. - 12:30 P.M.) ",30.00,movie[0]);
			ticket[1] = new Ticket(" Matinee Show(1:00 P.M. - 3:30 P.M.) ",50.00,movie[1]);
			ticket[2] = new Ticket(" First   Show(4:00 P.M. - 6:30 P.M.) ",80.00,movie[2]);
			ticket[3] = new Ticket(" Second  Show(8:00 A.M. - 10:30 P.M.) ",150.00,movie[3]);
			
			th[0] = new Theatre(" Prasads I-Max ",addrs[0],ticket[0]);
			th[1] = new Theatre(" PVR Cinemas",addrs[1],ticket[1]);
			th[2] = new Theatre(" Cinemax ",addrs[2],ticket[2]);
			th[3] = new Theatre(" Ramakrishna ",addrs[3],ticket[3]);
	}

	public int getOption(int last)
	{
		while(true)
		{
		int opt = sc.nextInt();
		if(opt >= 0 && opt < last)
			return opt;
		System.out.println("\n Invalid Option \n");
		}
	}

	public int printMovies()
	{
		System.out.println("\n ------Movies Menu------ ");
		for(int i = 0,temp = 0;i < movie.length;i++,temp++)
		{
			Movie m = ticket[i].getMovie();
			System.out.println(temp+". Movie Name: "+m.getName()+"\n");
			System.out.println(" Actor: "+m.getActor());
			System.out.println(" Actress: "+m.getActress());
			System.out.println(" Music: "+m.getMusic());
			System.out.println(" Theatre Name: "+th[i].getName());
			System.out.println(" ------Address------\n"+th[i].getAddress()+"\n");
		}
		System.out.print("\n Pls Enter Option for Availability : ");
		return getOption(movie.length);
	}
	
	public void printShows()
	{
		System.out.println(" ------Show Menu------ ");
		for(int i = 0,temp = 0;i < ticket.length;i++,temp++)
		{
			System.out.println(temp+". "+ticket[i].getShowName());
			System.out.println("\tTotal No.of Seats: "+Ticket.getTotalSeats());
			System.out.println("\tAvailable No.of Seats: "+ticket[i].getAvailableSeats());
			System.out.println("\tTicket Price: "+ticket[i].getPrice()+"\n");
		}
	}

	public void close()
	{
		System.exit(0);
	}

	public Movie[] getMovie()
	{
		return this.movie;
	}

	public void bookTicket(int opt)
	{
		int no = 0;
		double enter_money = 0.0;
		do
		{
			System.out.print("\nEnter No: of Tickets(less than Available): ");
			no = sc.nextInt();
		}
		while(no > ticket[opt].getAvailableSeats());
		ticket[opt].subAvailableSeats(no);
		double money = no*(ticket[opt].getPrice());
		do
		{
			System.out.print("\nEnter Total Money ("+money+") fo payment: ");
			enter_money = sc.nextDouble();
		}
		while(enter_money != money);
		System.out.println("\n Thank you for Booking...!");
	}

	public void cancelTicket(int opt)
	{
		int no = 0;
		double enter_money = 0.0;
		do
		{
			System.out.print("\nEnter No: of Tickets to cancel: ");
			no = sc.nextInt();
		}
		while(no > (Ticket.getTotalSeats() - ticket[opt].getAvailableSeats()));
		ticket[opt].addAvailableSeats(no);
		double money = no*(ticket[opt].getPrice());
		do
		{
			System.out.print("\nEnter Total Money ("+money+") for refund: ");
			enter_money = sc.nextDouble();
		}
		while(enter_money != money);
		System.out.println("\n Thank you for Cancelling...!");
	}
}