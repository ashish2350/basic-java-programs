import java.util.*;
public class DigitSquareSum
{
	private int n;

	DigitSquareSum(int n)
	{
		this.n = n;
	}

	public void getDigitSquareSum()
	{
		int temp = n, rem = 0;
		int s = 0;
		while(temp!= 0)
		{
			rem = temp % 10;
			s = (rem * rem) + s;
			temp = (int) temp / 10;
		}
		System.out.println("\nSum of the square of each of the digits of "+n+" is "+s);
	}

	public static void main(String[] args)
	{
		System.out.print("\nEnter a number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		DigitSquareSum dss = new DigitSquareSum(n);
		dss.getDigitSquareSum();
		sc.close();
	}
}