import java.util.*;
public class Pattern6
{
	private int n;

	public Pattern6(int n)
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
			for(int i = n; i >= 1; i--)
			{
				for(int j = 1; j <= i; j++)
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
		Pattern6 p6 = new Pattern6(n);
		p6.disp();
		sc.close();
	}
}