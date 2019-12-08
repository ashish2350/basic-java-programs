import java.util.*;
public class CheckArmstrong
{
	private int n, sum;

	public CheckArmstrong(int n)
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

	public void getArm()
	{
		int temp, rem;
		if (isValid(n) == true)
		{
			temp = n;
			while(temp !=0)
			{
				rem = temp % 10;
				sum += (rem * rem* rem);
				temp = (int) temp / 10;
			}
			disp();
		}
		else
			System.out.println("\nPlease enter a valid number.");
	}

	public void disp()
	{
		if(sum == n)
		{
			System.out.println("\n"+n+" is an Armstrong Number.");
		}
		else
		{
			System.out.println("\n"+n+" is not an Armstrong Number.");
		}
	}

	public static void main(String[] args)
	{
		System.out.print("\nEnter a number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		CheckArmstrong ca = new CheckArmstrong(n);
		ca.getArm();
		sc.close();
	}
}