
public class TestCoins
{
	public static void main(String args[])
	{
		Coin C = new Coin();
		double sum = 0;
		
		C = new Penny();
		sum = C.add(sum);
		System.out.println("This is the sum: " + sum);
		
		C = new Dime();
		sum = C.add(sum);
		System.out.println("This is the sum: " + sum);
		
		C =  new Nickel();
		sum = C.add(sum);
		System.out.println("This is the sum: " + sum);
		
		C = new Quarter();
		sum = C.add(sum);
		System.out.println("This is the sum: " + sum);
		
		C = new HalfDollar();
		sum = C.add(sum);
		System.out.println("This is the sum: " + sum);
		
		C = new Dollar();
		sum = C.add(sum);
		System.out.println("This is the sum: " + sum);
	}
}
