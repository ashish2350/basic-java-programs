public class SpecialCharacters
{
	private String str;
	private int count;

	public SpecialCharacters(String str)
	{
		this.str = str;
	}

	public int getCount()
	{
		return count;
	}

	public void disp()
	{
		char c;
		int n = str.length();
		System.out.print("\nSpecial Characters in the string: ");
		for(int i = 0; i < n; i++)
		{
			c = str.charAt(i);
			if(((c >= 32) && (c <= 47))||((c >= 58) && (c <= 64))||((c >= 91) && (c <= 96))||((c >= 123) &&(c <= 126)))
			{
				System.out.print(c+" ");
				count++;
			}
		}
		System.out.println("\n\nNo. of Special Characters: "+getCount());
	}

	public static void main(String[] args)
	{
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("\nEnter a string with special characters: ");
		String str = sc.nextLine();
		SpecialCharacters sh = new SpecialCharacters(str);
		sh.disp();
		sc.close();
	}
}