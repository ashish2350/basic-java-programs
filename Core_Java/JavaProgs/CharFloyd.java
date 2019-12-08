import java.util.*;
public class CharFloyd
{
	private int n;

	public CharFloyd(int n)
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
			char k = 'A';
			for(int i=1; i <= n; i++)
			{
				for(int j=1; j <= i; j++)
				{
					System.out.print(k+"\t");
					k++;
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
		System.out.print("\nEnter no. of rows:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		CharFloyd c = new CharFloyd(n);
		c.disp();
		sc.close();
	}
}