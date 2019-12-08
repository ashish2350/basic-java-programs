import java.util.*;
public class Pattern4
{
	private int n;

	public Pattern4(int n)
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
				for(int j = 1; j<=i; j++)
				{
					System.out.print(i+"\t");
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
		Pattern4 p4 = new Pattern4(n);
		p4.disp();
		sc.close();
	}
}