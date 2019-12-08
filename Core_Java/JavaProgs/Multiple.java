import java.util.*;
public class Multiple
{
	private int n;

	public Multiple(int n)
	{
		this.n = n;
	}

	public void multi()
	{
		if((n <= 10) &&(n > 0))
		{
			System.out.println("\n---------Multiplication table for "+n+"----------\n");
			for(int i = 1; i <= 10; i++)
			{
				System.out.println(n+" x "+i+" = "+(n * i));
			}
		}
		else
		{
			System.out.println("Please enter a number greater than 0 and less than or equal to 10");
		}
	}

	public static void main(String args[])
	{
		System.out.print("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Multiple m = new Multiple(n);
		m.multi();
		sc.close();
	}
}