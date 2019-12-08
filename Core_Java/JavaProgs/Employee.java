import java.util.*;
public class Employee
{
	private int empno, salary;
	private String ename, designation;

	public Employee(int empno, String ename, int salary, String designation)
	{
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
		this.designation = designation;
	}

	public boolean isValid(int no)
	{
		if(no >0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void emp()
	{
		double bonus;
		if((isValid(empno) == true) && (isValid(salary) == true))
		{
			if(salary >= 10000)
			{
				bonus = 0.25 * salary;
			}
			else if(salary >= 5000)
			{
				bonus = 0.15 * salary;
			}
			else
			{
				bonus = 0.1 * salary;
			}
			System.out.println("\n-------------Details of the Employee---------\n\nEMPNO: "+empno+"\nENAME: "+ename+"\nDesignation: "+designation+"\nBonus: "+bonus+"\nSalary: "+salary+"\nTotal Salary: "+(salary + bonus));
		}
		else
		{
			System.out.println("\nPlease enter valid values for empno and salary.");
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter empno: ");
		int empno = sc.nextInt();
		System.out.print("Enter ename: ");
		String ename = sc.next();
		System.out.print("Enter salary: ");
		int salary = sc.nextInt();
		System.out.print("Enter designation: ");
		String designation = sc.next();
		Employee e = new Employee(empno, ename, salary, designation);
		e.emp();
		sc.close();
	}
}