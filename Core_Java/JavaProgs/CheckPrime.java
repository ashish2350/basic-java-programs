import java.util.*;
public class CheckPrime
{
	private int n, count;

	public CheckPrime(int n)
	{
		this.n = n;
	}

	public boolean isValid(int no)
	{
		if(no >0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void getPrime()
	{
		if(isValid(n) == true)
		{
			for(int i=2; i < n; i++)
			{
				if(n % i == 0)
				{
					count++;
				}
			}
			disp();
		}
		else
			System.out.println("\nPlease enter a valid number.");
	}

	public void disp()
	{
		if(n != 1)
		{
			if(count == 0)
			{
				System.out.println("\n"+n+" is a Prime Number.");
			}
			else
			{
				System.out.println("\n"+n+" is a Composite Number.");
			}
		}
		else
		{
			System.out.println("\n"+n+" is neither a Prime Number nor a Composite Number.");
		}
	}

	public static void main(String[] args)
	{
		System.out.print("\nEnter a number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		CheckPrime cp = new CheckPrime(n);
		cp.getPrime();
		sc.close();
	}
}