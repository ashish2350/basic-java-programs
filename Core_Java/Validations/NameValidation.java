import java.util.*;
public class NameValidation
{
	private String name;

	public NameValidation(String name)
	{
		this.name = name;
	}

	public void isValid()
	{
		int len = name.length();
		boolean flag = true;
		for(int i = 0; i < len; i++)
		{
			if(!(((name.charAt(i) >= 65) && (name.charAt(i) <= 90)) || ((name.charAt(i) >= 97) && (name.charAt(i) <= 122))))
			{
				flag = false;
				break;
			}
		}
		if(flag == true)
			System.out.println("\nName Entered: "+name);
		else
			System.out.println("\nInvalid Name.");
	}

	public static void main(String[] args)
	{
		System.out.print("\nEnter a name :");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		NameValidation nv = new NameValidation(name);
		nv.isValid();
		sc.close();
	}
}