import java.util.*;
public class BigString
{
	private String str1, str2;

	public BigString(String str1, String str2)
	{
		this.str1 = str1;
		this.str2 = str2;
	}

	public void isBig()
	{
		int l1 = str1.length();
		int l2 = str2.length();
		if(l1 > l2)
		{
			System.out.println("\n"+str1+" is bigger.");
		}
		else if(l1 < l2)
		{
			System.out.println("\n"+str2+" is bigger.");
		}
		else
		{
			System.out.println("\nBoth are of equal length.");
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\n------Finding bigger String------\n");
		System.out.print("\nEnter the first string: ");
		String str1 = sc.next();
		System.out.print("\nEnter the second string: ");
		String str2 = sc.next();
		BigString b = new BigString(str1, str2);
		b.isBig();
		sc.close();
	}
}