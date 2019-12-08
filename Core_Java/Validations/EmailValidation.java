import java.util.*;
public class EmailValidation
{
	private String email;

	public EmailValidation(String email)
	{
		this.email = email;
	}

	public void isValid()
	{
		int len = email.length();
		if((email.charAt(0) >= 97) && (email.charAt(0) <= 122))
		{
			boolean flag = false;
			int count = 0;
			char c;
			for(int i = 0; i < len; i++)
			{
				c = email.charAt(i);
				if(c == '@')
				{
					flag = true;
					count++;
				}
			}
			boolean ch = true;
			for(int i = 0; i < len; i++)
			{
				c = email.charAt(i);
				if(((c >= 32) && (c < 46)) || (c == 47) || ((c >= 58) && (c < 64)) || ((c >= 91) && (c < 95)) || (c == 96) || ((c >= 123) && (c <= 126)))
				{
					ch = false;
					break;
				}
			}
			if((flag == true) && (count == 1) && (ch == true))
			{
				if((email.indexOf(".@") == -1) && (email.indexOf("..") == -1) && (email.indexOf("@.") == -1))
				{
					int dot = 0;
					for(int i = email.indexOf('@'); i < len ; i++)
					{
						if(email.charAt(i) == '.')
						{
							dot++;
						}
					}
					if((dot > 0) && (dot < 3) && (email.charAt(len - 1) != '.'))
					{
						System.out.println("Email Address Entered: "+email);
					}
					else
					{
						System.out.println("\nEmail Address is not valid.\n\nReasons:\nShould contain '.' after '@ with some characters' for domain.\nCan't have '.' more than two times after '@'.\nCan't end with '.'");
					}
				}
				else
				{
					System.out.println("\nEmail Address is not valid.\n\nReasons:\nCan't contain '.@', '@.' or '..'");
				}
			}
			else
			{
				System.out.println("\nEmail Address is not valid.\n\nReasons:\nShould contain '@'.\nCan't contain '@' more than once.\nCan't contain any special character other than '.' or '_' before '@'.\nCan't contain spaces.");
			}
		}
		else
		{
			System.out.println("\nEmail Address not valid.\n\nReasons:\nIt should start with a lower case alphabet.");
		}
	}

	public static void main(String[] args)
	{
		System.out.print("\nEnter an email address: ");
		Scanner sc = new Scanner(System.in);
		String email = sc.nextLine();
		EmailValidation ev = new EmailValidation(email);
		ev.isValid();
		sc.close();
	}
}