/*Author: 			Ruben Swyers (Orignal Author: Dr.Kaplan)
* Creation Date: 	February 27, 2015 
* Due Date: 		April 30, 2015
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#3
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
	//Name:			RandomInteger
	//Description:	Constructor for RandomInteger
	//Parameters:	int low - low range
	//				int high - high range
	//Returns:		none
	public RandomInteger(int low, int high)
	{
		super();
		
		this.low = low;
		this.high = high;
		
		rm = new Random();
	}
	//Name:			nextRandomIntegerInRange
	//Description:	Gets a random integer that is in the appropriate range
	//Parameters:	none
	//Returns:		int - integer that is randomly generated
	public int nextRandomIntegerInRange()
	{
		int randomInteger = 0;
		
		randomInteger = rm.nextInt(high-low+1)+low;
		
		return randomInteger;
	}
}