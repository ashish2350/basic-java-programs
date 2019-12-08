import java.util.*;
public class MobileNumberValidation
{
	private String mobileNo;

	public MobileNumberValidation(String mobileNo)
	{
		this.mobileNo = mobileNo;
	}

	public void isValid()
	{
		int len = mobileNo.length();
		if(len == 10)
		{
			if((mobileNo.charAt(0) != '0'))
			{
				boolean flag = true;
				for(int i = 1; i < len; i++)
				{
					if(!((mobileNo.charAt(i) >= 48) && (mobileNo.charAt(i) <= 57)))
					{
						flag = false;
						break;
					}
				}
				if(flag == true)
					System.out.println("\nEntered Mobile No. : "+mobileNo);
				else
					System.out.println("\nInvalid Mobile No.");
			}
			else
				System.out.println("\nInvalid Mobile No. Can't start with '0'.");
		}
		else
			System.out.println("\nInvalid Mobile No. Should be 10 characters long.");
	}

	public static void main(String[] args)
	{
		System.out.print("\nEnter Mobile No. : ");
		Scanner sc = new Scanner(System.in);
		String mobileNo = sc.nextLine();
		MobileNumberValidation mnv = new MobileNumberValidation(mobileNo);
		mnv.isValid();
		sc.close();
	}
}