/*Author: 			Ruben Swyers
* Creation Date: 	March 24, 2015 
* Due Date: 		March 24, 2015
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#2
* Filename: 		Coin.java
* Purpose:		  	Class, base class for all of the other coins.
*/
public class Coin
{
	//members
	protected double value;
	//constructor
	public Coin()
	{
	}
	//get
	public double getValue()
	{
		return this.value;
	}
	//add function
	public double add(Coin C)
	{
		return C.getValue() + this.getValue();
	}
	public double add(double d)
	{
		return this.getValue() + d;
	}
}
