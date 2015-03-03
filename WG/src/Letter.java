/*Author: 			Ruben Swyers
* Creation Date: 	February 27, 2015 
* Due Date: 		 
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#1
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
	
	public Letter(char l)
	{
		this.letter = l;
		this.guessed = false;
		this.blank = false;
	}
	//returns true if it is guessed, false if not
	public boolean isGuessed()
	{
		return this.guessed;
	}
	//called to guess a letter, will make the guessed value true, so that
	//I can tell it is guessed
	public void guess()
	{
		this.guessed = true;
	}
	public void makeBlank()
	{
		this.blank = true;
	}
	public String toString()
	{
		String result = "";
		if(this.blank)
		{
			result += "_";
		}
		else
		{
			result += Character.toString(this.letter);
		}
		return result;
	}
}
