/*Author: 			Ruben Swyers
* Creation Date: 	April 30, 2015 
* Due Date: 		April 30, 2015
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#3
* Filename: 		Letter.java
* Purpose:		  	Class, Makes up the object that the project will essentially be based
* off of. The Letter class is basically a character, but with a few members and methods to help
* make the game logic easier
*/
public class Letter
{
	//members
	char letter;
	boolean blank;
	boolean guessed;
	//Name:			Letter
	//Description:	Constructor for a Letter
	//Parameters:	char - the letter that will be represented in the Letter class
	//Returns:		none
	public Letter(char l)
	{
		this.letter = l;
		this.guessed = false;
		this.blank = false;
	}
	//Name:			isGuessed
	//Description:	returns the value of guessed
	//Parameters:	none
	//Returns:		boolean - value of guessed
	public boolean isGuessed()
	{
		return this.guessed;
	}
	//Name:			setGuessed
	//Discription:	guesses the letter without the need for a char
	//Parameters:	n/a
	//Returns:		n/a
	public void setGuessed()
	{
		this.guessed = true;
	}
	//Name:			guess
	//Description:	called to guess a letter, will make the guessed value true so that I can
	//				tell if it is guessed
	//Parameters:	char - letter that is guessed
	//Returns:		none
	public void guess(char l)
	{
		if(l == this.letter)
		{
			this.guessed = true;
		}
	}
	//Name:			is
	//Description:	checks the letter that is represented by the Letter object
	//Parameters:	char - letter to be checked
	//Returns:		boolean
	//				true - if it's the letter that's represented
	//				false - if it is not the letter
	public boolean is(char c)
	{
		if(this.letter == c)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Name:			isBlank
	//Description:	gets the value of the blank member
	//Parameters:	none
	//Returns:		boolean - the value of the blank member
	public boolean isBlank()
	{
		return this.blank;
	}
	//Name:			makeBlank
	//Description:	sets the value of the blank member to true
	//Parameters:	none
	//Returns:		none
	public void makeBlank()
	{
		this.blank = true;
	}
	//Name:			clearBlank
	//Description:	sets the blank member to false
	//Parameters:	none
	//Returns:		none
	public void clearBlank()
	{
		this.blank = false;
	}
	//Name:			getChar
	//Description:	gets the character that the Letter is using
	//Parameters:	none
	//Returns:		The char the Letter is using
	public char getChar()
	{
		return this.letter;
	}
	//Name:			toString
	//Description:	returns a string representation of the Letter
	//Parameters:	none
	//Returns:		String - string representation of the Letter
	public String toString()
	{
		String result = "";
		if(this.blank)
		{
			result += "X";
		}
		else
		{
			result += Character.toString(this.letter);
		}
		return result;
	}
}
