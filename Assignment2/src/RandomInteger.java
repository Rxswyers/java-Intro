import java.util.Random;

public class RandomInteger {

//	private static final long serialVersionUID = 1L;
	
	int low;	// low of range
	int high;	// high of range
	int randomInteger; // Generated random integer in the specified range
	
	private Random rm;
	
	public RandomInteger(int low, int high)
	{
		super();
		
		this.low = low;
		this.high = high;
		
		rm = new Random();
	}
	
	public int nextRandomIntegerInRange()
	{
		int randomInteger = 0;
		
		randomInteger = rm.nextInt(high-low+1)+low;
		
		return randomInteger;
	}
}
