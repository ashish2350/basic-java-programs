import java.util.*;
public class Swapping
{
	private int a, b;

	public Swapping(int a, int b)
	{
		this.a = a;
		this.b = b;
	}

	public void swap()
	{
		System.out.println("\nNumbers before swapping are "+a+" and "+b);
		b += a;
		a = (b - a);
		b = (b - a);
		System.out.println("\nNumbers after swapping are "+a+" and "+b);
	}

	public static void main(String args[])
	{
		System.out.print("\nEnter two numbers to swap: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		Swapping s = new Swapping(a, b);
		s.swap();
		sc.close();
	}
}