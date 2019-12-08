import java.util.*;
public class MenuDriven
{
	private int a, b, value;
	private Scanner sc = null;

	public void print()
	{
		System.out.print("\n--------Menu--------\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Exit\n\nEnter an option from the above menu: ");
		sc = new Scanner(System.in);
		value = sc.nextInt();
	}

	public void accept()
	{
		System.out.print("\nEnter two numbers: ");
		a = sc.nextInt();
		b = sc.nextInt();
	}

	public void sum()
	{
		System.out.println("\nSum of "+a+" and "+b+" is "+(a + b));
	}

	public void sub()
	{
		System.out.println("\nDifference of "+a+" and "+b+" is "+(a - b));
	}

	public void mul()
	{
		System.out.println("\nProduct of "+a+" and "+b+" is "+(a * b));
	}

	public void div()
	{
		System.out.println("\nResult of "+a+" and "+b+" is "+((float) a / b));
	}

	public void call()
	{
		while(true)
		{
			print();
			switch(value)
			{
				case 1:	accept();
					sum();
					break;

				case 2:	accept();
					sub();
					break;

				case 3:	accept();
					mul();
					break;

				case 4:	accept();
					div();
					break;

				case 5:	System.out.println("\nThank You.");
					System.exit(0);
					break;

				default:	System.out.println("\nInvalid option");
					break;
			}
		}
	}

	public static void main(String args[])
	{
		MenuDriven m = new MenuDriven();
		m.call();
	}
}