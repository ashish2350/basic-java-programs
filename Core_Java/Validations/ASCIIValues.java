class ASCIIValues
{
	public static void main(String[] args)
	{
		char c;
		for(int i = 32; i < 127; i++)
		{
			c = (char) i;
			System.out.println(i+" = "+c);
		}
	}
}