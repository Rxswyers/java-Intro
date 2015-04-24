/*Author: 			Ruben Swyers
* Creation Date: 	February 27, 2015 
* Due Date: 		March 5, 2015
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#1
* Filename: 		Player.java
* Purpose:		  	Class, Player will contain all of the information and functionality
* to handle what the player does in this project
*/
public class Player
{
	//members
	int score;
	
	//Name:			Player
	//Description:	Constructor for a Player - sets their score to 0
	//Parameters:	none
	//Returns:		none
	public Player ()
	{
		this.score = 0;
	}
	//Name:			addScore
	//Description:	adds a value to the score
	//Parameters:	int - value to be added
	//Returns:		none
	public void addScore(int n)
	{
		this.score += n;
	}
	//Name:			subtractScore
	//Description:	subtracts a value from the score
	//Parameters:	int - value to be subtracted
	//Returns:		none
	public void subtractScore(int n)
	{
		this.score -= n;
	}
	//Name:			getScore
	//Description:	gets the score of the player
	//Parameters:	none
	//Returns:		int - the score of the player
	public int getScore()
	{
		return this.score;
	}
}
