/*Author: 			Ruben Swyers (Orignal Author: Dr.Kaplan)
* Creation Date: 	February 27, 2015 
* Due Date: 		 
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#1
* Filename: 		RandomInteger.java
* Purpose:		  	Class, gets a random number within a certain range
*/
import java.util.Random;

public class RandomInteger
{
	
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