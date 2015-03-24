
public class TestCoins
{
	public static void main(String args[])
	{
		Penny p1 = new Penny();
		Penny p2 = new Penny();
		Nickel n1 = new Nickel();
		double sum = 0;
		Coin C = new Penny();
		
		sum = p1.add(p2);
		sum = n1.add(sum);
		sum = C.add(sum);
		System.out.println(sum + " This is the sum");
	}
}
