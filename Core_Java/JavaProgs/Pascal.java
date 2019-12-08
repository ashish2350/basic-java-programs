import java.util.*;
public class Pascal
{
	private int n;

	public Pascal(int n)
	{
		this.n = n;
	}


	boolean isValid(int no)
	{
		if(no > 0)
			return true;
		else
			return false;
	}

	void getPascal()
	{
		if(isValid(n) == true)
		{
			System.out.println();
			for(int i = 0; i < n; i++)
			{
				int p = 1;
				for(int j = 1; j <= (n - i - 1); j++)
				{
					System.out.print(" ");
				}
				for(int k = 0; k <= i; k++)
				{
					System.out.print(p+" ");
					p = p * (i - k) / (k + 1);
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("\nPlease enter a valid number.");
		}
	}

	public static void main(String args[])
	{
		System.out.print("\nEnter no.of rows: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Pascal p = new Pascal(n);
		p.getPascal();
		sc.close();
	}
}