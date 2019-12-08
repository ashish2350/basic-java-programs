import java.util.*;
public class PalindromeString
{
	private String str;

	public PalindromeString(String str)
	{
		this.str = str;
	}

	public boolean isPalindrome()
	{
		int l = str.length();
		for(int i = 0; i < l; i++)
		{
			if(str.charAt(i) != str.charAt(--l))
			{
				return false;
			}
		}
		return true;
	}

	public void getPalindrome()
	{
		if(isPalindrome() == true)
		{
			System.out.println("\n"+str+" is a Palindrome.");
		}
		else
		{
			System.out.println("\n"+str+" is not a Palindrome.");
		}
	}

	public static void main(String[] args)
	{
		System.out.println("------Checking palindrome------\n");
		System.out.print("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		PalindromeString ps = new PalindromeString(str);
		ps.getPalindrome();
		sc.close();
	}
}