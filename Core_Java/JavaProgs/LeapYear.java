import java.util.*;
public class LeapYear
{
	private int year;

	public LeapYear(int year)
	{
		this.year = year;
	}

	public boolean valid()
	{
		if((year > 999) && (year < 10000))
			return true;
		else
			return false;
	}

	public void disp()
	{
		if(valid() == true)
		{
			if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
				System.out.println("\n"+year+" is a Leap Year.");
			else
				System.out.println("\n"+year+" is not a Leap Year.");
		}
		else
		{
				System.out.println("\nPlease enter a four digit year.");
		}
	}

	public static void main(String args[])
	{
		System.out.print("\nEnter an year: ");
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		LeapYear ly = new LeapYear(year);
		ly.disp();
		sc.close();
	}
}