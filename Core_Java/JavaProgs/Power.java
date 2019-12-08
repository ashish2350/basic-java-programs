import java.util.*;
public class Power
{
	private int a, b;

	public Power(int a, int b)
	{
		this.a = a;
		this.b = b;
	}

	public void pow()
	{
		int p = 1;
		for(int i = 1; i <= b; i++)
		{
			p *= a;
		}
		System.out.println("\n"+a+" to the power of "+b+" is "+p);
	}

	public static void main(String args[])
	{
		System.out.print("\nEnter base 'm': ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.print("\nEnter power 'n': ");
		int b = sc.nextInt();
		Power p = new Power(a, b);
		p.pow();
		sc.close();
	}
}