import java.util.*;
public class Factorial
{
	private int n, f = 1;

	public Factorial(int n)
	{
		this.n = n;
	}

	public boolean isValid(int no)
	{
		if(no >=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void fact()
	{
		if(isValid(n) == true)
		{
			for(int i = 1; i <= n; i++)
			{
				f *= i;
			}
			System.out.println("\nFactorial of "+n+" is "+f+".");
		}
		else
			System.out.println("\nPlease enter a valid number");
	}

	public static void main(String[] args)
	{
		System.out.print("\nEnter a number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Factorial f = new Factorial(n);
		f.fact();
		sc.close();
	}
}