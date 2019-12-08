import java.util.*;
public class Pattern2
{
	private int n;

	public Pattern2(int n)
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

	void disp()
	{
		if(isValid(n) == true)
		{
			for(int i = 1; i <= n; i++)
			{
				for(int j = 1; j <= n; j++)
				{
					System.out.print("*\t");
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
		System.out.print("Enter no. of rows: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Pattern2 p2 = new Pattern2(n);
		p2.disp();
		sc.close();
	}
}