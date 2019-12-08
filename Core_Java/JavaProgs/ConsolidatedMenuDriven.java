import java.util.*;
public class ConsolidatedMenuDriven
{
	private int value;
	private Scanner sc;

	public ConsolidatedMenuDriven()
	{
		value = 0;
		sc = new Scanner(System.in);
	}

	public void menu1()
	{
		while(true)
		{
			System.out.println("\n------Menu1------\n1. Check Prime Number\n2. Check Palindrome String\n3. Check Perfect Square Number\n4. Factorial of a number\n5. Check bigger String\n6. Print Fibonacci Series\n7. Check Armstrong Number\n8. Display Vowels in a String\n\n9. Next\n\n0. Exit");
			System.out.print("Enter an option from above menu: ");
			value = sc.nextInt();
			switch(value)
			{
				case 1:	System.out.print("\nEnter a number: ");
					int n = sc.nextInt();
					CheckPrime cp = new CheckPrime(n);
					cp.getPrime();
					break;

				case 2:	System.out.print("\nEnter a string: ");
					String str = sc.next();
					PalindromeString ps = new PalindromeString(str);
					ps.getPalindrome();
					break;

				case 3:	System.out.print("\nEnter a number: ");
					n = sc.nextInt();
					PerfectSquare s = new PerfectSquare(n);
					s.testSqr();
					break;

				case 4:	System.out.print("\nEnter a number: ");
					n = sc.nextInt();
					Factorial f = new Factorial(n);
					f.fact();
					break;

				case 5:	System.out.print("\nEnter the first string: ");
					String str1 = sc.next();
					System.out.print("\nEnter the second string: ");
					String str2 = sc.next();
					BigString b = new BigString(str1, str2);
					b.isBig();
					break;

				case 6:	System.out.print("\nEnter the limit for Fibonacci series: ");
					n = sc.nextInt();
					Fibonacci fb = new Fibonacci(n);
					fb.fib();
					break;

				case 7:	System.out.print("\nEnter a number: ");
					n = sc.nextInt();
					CheckArmstrong ca = new CheckArmstrong(n);
					ca.getArm();
					break;

				case 8:	System.out.print("Enter a string: ");
					str = sc.next();
					Vowel v = new Vowel(str);
					v.isVowel();
					break;

				case 9:	menu2();
					break;

				case 0:	System.out.println("\nThank You.");
					System.exit(0);
					break;

				default: System.out.println("\nInvalid Option");
					 break;
			}
		}
	}

	public void menu2()
	{
		while(true)
		{
			System.out.println("\n------Menu2------\n1. Get Even & Odd numbers from a set\n2. Display 'm' to the power of 'n'\n3. Reverse of a number\n4. Converting a String from lowercase to uppercase\n5. Display Special charactes in a String\n6. Get Employee Details\n7. Swapping two numbers\n8. Multiplication table for a number\n\n9. Next\n10. Previous\n\n0. Exit");
			System.out.print("Enter an option from above menu: ");
			value = sc.nextInt();
			switch(value)
			{
				case 1:	System.out.println("\n------Odd Even Sorting------\n");
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
					break;

				case 2:	System.out.print("\nEnter base 'm': ");
					int a = sc.nextInt();
					System.out.print("\nEnter power 'n': ");
					int b = sc.nextInt();
					Power p = new Power(a, b);
					p.pow();
					break;

				case 3:	System.out.print("\nEnter a number: ");
					n = sc.nextInt();
					Reverse r = new Reverse(n);
					r.rev();
					break;

				case 4:	System.out.print("\nEnter a string in lower case: ");
					String str = sc.next();
					LowerToUpperCase lu = new LowerToUpperCase(str);
					System.out.println("\nString in uppercase: "+lu.getUpper());
					break;

				case 5:	System.out.print("\nEnter a string with special characters: ");
					str = sc.next();
					SpecialCharacters sh = new SpecialCharacters(str);
					sh.disp();
					break;

				case 6:	System.out.print("\nEnter empno: ");
					int empno = sc.nextInt();
					System.out.print("Enter ename: ");
					String ename = sc.next();
					System.out.print("Enter salary: ");
					int salary = sc.nextInt();
					System.out.print("Enter designation: ");
					String designation = sc.next();
					Employee e = new Employee(empno, ename, salary, designation);
					e.emp();
					break;

				case 7:	System.out.print("\nEnter two numbers to swap: ");
					a = sc.nextInt();
					b = sc.nextInt();
					Swapping s = new Swapping(a, b);
					s.swap();
					break;

				case 8:	System.out.print("Enter a number: ");
					n = sc.nextInt();
					Multiple m = new Multiple(n);
					m.multi();
					break;

				case 9:	menu3();
					break;

				case 10: menu1();
					 break;

				case 0:	System.out.println("\nThank You.");
					System.exit(0);
					break;

				default: System.out.println("\nInvalid Option");
					 break;
			}
		}
	}

	public void menu3()
	{
		while(true)
		{
			System.out.println("\n------Menu3------\n1. Calculator Menu\n2. Check Leap Year\n3. Squares of each digit of a number\n4. Sum of Squares of each digit of a number\n5. Movie Ticket Booking App\n6. Pattern1\n7. Pattern2\n8. Pattern3\n\n9. Next\n10. Previous\n\n0. Exit");
			System.out.print("Enter an option from above menu: ");
			value = sc.nextInt();
			switch(value)
			{
				case 1:	MenuDriven m = new MenuDriven();
					m.call();
					break;

				case 2:	System.out.print("\nEnter an year: ");
					int year = sc.nextInt();
					LeapYear ly = new LeapYear(year);
					ly.disp();
					break;

				case 3:	System.out.print("\nEnter a number: ");
					int n = sc.nextInt();
					DigitSquare ds = new DigitSquare(n);
					ds.getDigitSquare();
					break;

				case 4:	System.out.print("\nEnter a number: ");
					n = sc.nextInt();
					DigitSquareSum dss = new DigitSquareSum(n);
					dss.getDigitSquareSum();
					break;

				case 5:	TestMovieTicketBooking t = new TestMovieTicketBooking();
					t.test();
					break;

				case 6:	System.out.print("\nEnter no. of rows: ");
					n = sc.nextInt();
					Pattern1 p1 = new Pattern1(n);
					p1.disp();
					break;

				case 7:	System.out.print("\nEnter no. of rows: ");
					n = sc.nextInt();
					Pattern2 p2 = new Pattern2(n);
					p2.disp();
					break;

				case 8:	System.out.print("\nEnter no. of rows: ");
					n = sc.nextInt();
					Pattern3 p3 = new Pattern3(n);
					p3.disp();
					break;

				case 9:	menu4();
					break;

				case 10: menu2();
					 break;

				case 0:	System.out.println("\nThank You.");
					System.exit(0);
					break;

				default: System.out.println("\nInvalid Option");
					 break;
			}
		}
	}

	public void menu4()
	{
		while(true)
		{
			System.out.println("\n------Menu4------\n1. Pattern4\n2. Pattern5\n3. Pattern6\n4. Floyd's Triangle of numbers\n5. Floyd's Triangle of characters\n6. Pascal Triangle\n7. 1 to n Prime Numbers\n8. 1 to n Armstrong Numbers\n9. Mathematical tables 1 to 20\n\n10. Previous\n\n0. Exit");
			System.out.print("Enter an option from above menu: ");
			value = sc.nextInt();
			switch(value)
			{
				case 1:	System.out.print("\nEnter no. of rows: ");
					int n = sc.nextInt();
					Pattern4 p4 = new Pattern4(n);
					p4.disp();
					break;

				case 2:	System.out.print("\nEnter no. of rows: ");
					n = sc.nextInt();
					Pattern5 p5 = new Pattern5(n);
					p5.disp();
					break;

				case 3:	System.out.print("\nEnter no. of rows: ");
					n = sc.nextInt();
					Pattern6 p6 = new Pattern6(n);
					p6.disp();
					break;

				case 4:	System.out.print("\nEnter no. of rows:");
					n = sc.nextInt();
					Floyd f = new Floyd(n);
					f.disp();
					break;

				case 5:	System.out.print("\nEnter no. of rows:");
					n = sc.nextInt();
					CharFloyd c = new CharFloyd(n);
					c.disp();
					break;

				case 6:	System.out.print("\nEnter no.of rows: ");
					n = sc.nextInt();
					Pascal p = new Pascal(n);
					p.getPascal();
					break;

				case 7:	System.out.print("\nEnter a limit: ");
					n = sc.nextInt();
					GenPrime gp = new GenPrime(n);
					gp.getPrime();
					break;

				case 8:	System.out.print("Enter a limit: ");
					n = sc.nextInt();
					GenArmstrong ga = new GenArmstrong(n);
					ga.disp();
					break;

				case 9:	MultiTables m = new MultiTables();
					m.disp();
					break;

				case 10: menu3();
					 break;

				case 0:	System.out.println("\nThank You.");
					System.exit(0);
					break;

				default: System.out.println("\nInvalid Option");
					 break;
			}
		}
	}

	public static void main(String[] args)
	{
		ConsolidatedMenuDriven cmd = new ConsolidatedMenuDriven();
		cmd.menu1();
	}
}