import java.util.*;
public class OddEven
{
	private static int odd[], even[], m[], i, j;

	public OddEven(int num[])
	{
		m = new int[num.length];
		even = new int[num.length];
		odd = new int[num.length];
		for(int i = 0; i < num.length; i++)
		{
			m[i] = num[i];
		}
	}

	public void sortNum()
	{
		for(int b: m)
		{
			if(b % 2 == 0)
			{
				even[i++] = b;
			}
			else
			{
				odd[j++] = b;
			}
		}
	}

	public void printNum()
	{
		sortNum();
		System.out.print("\n------Odd & Even Numbers except '0'------");
		System.out.print("\nOdd Numbers: ");
		for(int x: odd)
		{
			if(x > 0)
			{
				System.out.print(x+" ");
			}
		}
		System.out.print("\nEven Numbers: ");
		for(int y: even)
		{
			if(y > 0)
			{
				System.out.print(y+" ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\n------Odd Even Sorting------\n");
		System.out.print("Enter a limit for numbers: ");
		int n = sc.nextInt();
		int num[] = new int[n];
		System.out.print("\nEnter "+n+" numbers except '0': ");
		for(int i = 0; i < n; i++)
		{
			num[i] = sc.nextInt();
		}
		OddEven oe = new OddEven(num);
		oe.printNum();
		sc.close();
	}
}