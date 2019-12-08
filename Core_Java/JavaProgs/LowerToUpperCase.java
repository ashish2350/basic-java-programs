import java.util.*;
public class LowerToUpperCase
{
	private String str;

	public LowerToUpperCase(String str)
	{
		this.str = str;
	}

	public String getUpper()
	{
		int len = str.length();
		char c[] = new char[len];
		for(int i = 0; i < len; i++)
		{
			c[i] = str.charAt(i);
			if((c[i] >= 97) && (c[i] <= 122))
			{
				c[i] = (char) (c[i] - 32);
			}
		}
		String s = new String(c);
		return s;
	}

	public static void main(String[] args)
	{
		System.out.print("\nEnter a string in lower case: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		LowerToUpperCase lu = new LowerToUpperCase(str);
		System.out.println("\nString in uppercase: "+lu.getUpper());
		sc.close();
	}
} 