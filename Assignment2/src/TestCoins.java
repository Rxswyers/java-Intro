
public class TestCoins
{
	public static void main(String args[])
	{
		Penny p1 = new Penny();
		Penny p2 = new Penny();
		double sum = 0;
		
		sum = p1.add(p2);
		
		System.out.println(sum + " This is the sum");
	}
}
