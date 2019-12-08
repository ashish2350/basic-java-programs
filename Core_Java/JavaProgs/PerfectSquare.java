import java.util.*;
public class PerfectSquare
{
	private int n, count;

	public PerfectSquare(int n)
	{
		this.n = n;
	}

	public void testSqr()
	{
		if(n >= 0)
		{
			for(int i = 1; (i * i) <= n; i++)
			{
				if(n != (i * i))
				{
					count = 1;
				}
				else
				{
					count = 0;
				}
			}
			disp();
		}
		else
			System.out.println("\nPlease enter a valid number");
	}

	public void disp()
	{
		if(count == 0)
		{
			System.out.println("\n"+n+" is a perfect square.");
		}
		else
		{
			System.out.println("\n"+n+" is not a perfect square.");
		}
	}

	public static void main(String args[])
	{
		System.out.print("\nEnter a number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PerfectSquare s = new PerfectSquare(n);
		s.testSqr();
		sc.close();
	}
}