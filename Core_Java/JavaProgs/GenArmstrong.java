import java.util.*;
public class GenArmstrong
{
	private int n;

	public GenArmstrong(int n)
	{
		this.n = n;
	}

	public void disp()
	{
		System.out.println("\n------Armstrong numbers upto "+n+"------\n");
		for(int i = 0; i <= n; i++)
		{
			int temp = i, rem = 0, sum = 0;
			while(temp != 0)
			{
				rem = temp % 10;
				sum += (rem * rem * rem);
				temp /= 10;
			}
			if(sum == i)
				System.out.print(i+" ");
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a limit: ");
		int n = sc.nextInt();
		GenArmstrong p = new GenArmstrong(n);
		p.disp();
		sc.close();
	}
}