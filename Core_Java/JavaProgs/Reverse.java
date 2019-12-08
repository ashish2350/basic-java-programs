import java.util.*;
public class Reverse
{
	private int n;

	public Reverse(int n)
	{
		this.n = n;
	}

	public void rev()
	{
		int temp = n, rem, sum = 0;
		while(temp != 0)
		{
			rem = temp % 10;
			sum = sum * 10 + rem;
			temp = (int) temp / 10;
		}
		System.out.println("\nReverse of "+n+" is "+sum);
	}

	public static void main(String args[])
	{
		System.out.print("\nEnter a number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Reverse r = new Reverse(n);
		r.rev();
		sc.close();
	}
}