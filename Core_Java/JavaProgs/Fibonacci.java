import java.util.*;
public class Fibonacci
{
	private int n;

	public Fibonacci(int n)
	{
		this.n = n;
	}

	public void fib()
	{
		int a, b, c;
		if(n > 0)
		{
			a = 0;
			b = 1;
			System.out.println("\n--------Fibonacci Series---------");
			System.out.print(a+"  ");
			System.out.print(b+"  ");
			c = a + b;
			while(c <=n)
			{
				System.out.print(c+"  ");
				a = b;
				b = c;
				c = a + b;
			}
		}
		else
			System.out.println("\nPlease enter a valid limit.");
	}

	public static void main(String args[])
	{
		System.out.print("\nEnter the limit for Fibonacci series: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Fibonacci f = new Fibonacci(n);
		f.fib();
		sc.close();
	}
}