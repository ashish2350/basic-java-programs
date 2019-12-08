public class MultiTables
{
	public void disp()
	{
		for(int i = 1; i <= 20; i++)
		{
			System.out.println("\n ------Multiplication table for "+i+"------\n ");
			for(int j = 1; j <= 10; j++)
			{
				System.out.println(i+" x "+j+" = "+(i * j));
			}
		}
	}

	public static void main(String[] args)
	{
		MultiTables m = new MultiTables();
		m.disp();
	}
}