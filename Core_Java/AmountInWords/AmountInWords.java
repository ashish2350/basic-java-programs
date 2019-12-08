import java.util.*;
public class AmountInWords
{
	private String amount = "";
	private int count, f, l;
	private String ones[] = {"Zero ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
	private String tens[] = {"","", "Twenty ", "Thirty ", "Fourty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
	private String huns[] = {"Hundred ", "Thousand ", "Lakh ", "Crore "};

	public int getCount(int temp)
	{
		int count = 0;
		while(temp != 0)
		{
			temp /= 10;
			count++;			
		}
		return count;
	}

	public String getWords(int num)
	{
		String str = "";
		l = num / 10;
		f = num % 10;
		if(l != 0)
		str += tens[l];
		if(f != 0)
		str += ones[f];
		return str;	
	}

	public String getAmount(int num)
	{
		while((count = this.getCount(num)) >= 1)
		{
			switch(count)
			{
				case 1 :

				case 2 :	if(num < 20)
							amount  += ones[num];
						else
							amount += getWords(num);
						num = 0;
						break;

				case 3 :	l = num / 100;
						amount += ones[l] + huns[0];
						num %= 100;
						break;

				case 4 :

				case 5 :	l = num / 1000;
						if(l < 20)
							amount += ones[l] + huns[1];
						else
							amount += this.getWords(l) + huns[1];
						num %= 1000;
						break;

				case 6 :

				case 7 :	l = num / 100000;
						if(l < 20)
							amount += ones[l] + huns[2];
						else
							amount += this.getWords(l) + huns[2];
						num %= 100000;
						break;

				default :	l = num / 10000000;					
						if(l < 100)
						{
							if(l < 20)
								amount += ones[l] + huns[3];
							else
								amount += this.getWords(l) + huns[3];
						}
						else
							amount = this.getAmount(l) + huns[3];
						num %= 10000000;
						break;
			}
		}
		return amount;
	}

	public void displayInWords(int num)
	{
		if(num < 20)
			System.out.println("\nEntered Amount in Words: "+ones[num]+"Only.");
		else
			System.out.println("\nEntered Amount in Words : "+getAmount(Math.abs(num)) + "Only.");
	}

	public static void main(String[] args)
	{
		AmountInWords a = new AmountInWords();
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter an Amount in numbers: ");
		int num = sc.nextInt();
		a.displayInWords(num);
		sc.close();
	}
}