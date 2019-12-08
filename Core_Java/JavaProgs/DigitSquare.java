import java.util.*;
public class DigitSquare
{
	private int n;

	DigitSquare(int n)
	{
		this.n = n;
	}

	public void getDigitSquare()
	{
		int temp = n, rem = 0;
		String s = "";
		while(temp!= 0)
		{
			rem = temp % 10;
			s = Integer.toString(rem * rem) + s;
			temp = (int) temp / 10;
		}
		System.out.println("\nSquare of each of the digits of "+n+" is "+s);
	}

	public static void main(String[] args)
	{
		System.out.print("\nEnter a number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		DigitSquare ds = new DigitSquare(n);
		ds.getDigitSquare();
		sc.close();
	}
}