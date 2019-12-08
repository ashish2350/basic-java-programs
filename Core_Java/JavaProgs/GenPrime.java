import java.util.*;
public class GenPrime
{
	private int n;

	public GenPrime(int n)
	{
		this.n = n;
	}

	public void getPrime()
	{
		System.out.println("\n------Prime numbers upto "+n+"------\n");
		for(int i = 1; i <= n; i++)
		{
			int c = 0;
			for(int j = 1; j < i; j++)
			{
				if(i % j == 0)
					c++;
			}
			if(c == 1)
				System.out.print(i+" ");
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter a limit: ");
		int n = sc.nextInt();
		GenPrime p = new GenPrime(n);
		p.getPrime();
		sc.close();
	}
}