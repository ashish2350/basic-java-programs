import java.util.*;
public class Vowel
{
	private String str;
	private int count;
	private char ch;

	public Vowel(String str)
	{
		this.str = str;
	}

	public void isVowel()
	{
		int l = str.length();
		System.out.print("\nVowels in the string: ");
		for(int i = 0; i < l; i++)
		{
			ch = str.charAt(i);
			switch(ch)
			{
				case 'A':

				case 'a':	System.out.print(ch+" ");
						count++;
						break;

				case 'E':

				case 'e':	System.out.print(ch+" ");
						count++;
						break;

				case 'I':

				case 'i':	System.out.print(ch+" ");
						count++;
						break;

				case 'O':

				case 'o':	System.out.print(ch+" ");
						count++;
						break;

				case 'U':

				case 'u':	System.out.print(ch+" ");
						count++;
						break;
			}
		}
		System.out.println();
		System.out.println("\nNo.of vowels in the string: "+count);
	}

	public static void main(String[] args)
	{
		System.out.print("\n------Vowel checking------\n");
		System.out.print("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Vowel v = new Vowel(str);
		v.isVowel();
		sc.close();
	}
}