/*Author: 			Ruben Swyers
* Creation Date: 	February 27, 2015 
* Due Date: 		March 5, 2015 5PM
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#1
* Filename: 		Word.java
* Purpose:		  	Class, This will be a collection of Letters, creating a word.
*/
import java.util.ArrayList;
public class Word
{
	//members
	protected ArrayList<Letter> word;
	protected boolean used;
	//Name:			Word
	//Description:	Constructor for a Word - turns a string into a Word
	//Parameters:	String s - the string that the word is supposed to be
	//Returns:		none
	public Word(String s)
	{
		this.word = new ArrayList<Letter>();
		for(int i = 0; i < s.length(); i ++)
		{
			this.word.add(new Letter(s.charAt(i)));
		}
		this.used = false;
	}
	//Name:			use
	//Description:	sets the used member to true
	//Parameters:	none
	//Returns:		none
	public void use()
	{
		this.used = true;
	}
	//Name:			resetUsed
	//Description:	sets the used member to false
	//Parameters:	none
	//Returns:		none
	public void resetUsed()
	{
		this.used = false;
	}
	//Name:			isUsed
	//Description:	gets the value of the used member
	//Parameters:	none
	//Returns:		boolean - the value of the used member
	public boolean isUsed()
	{
		return this.used;
	}
	//Name:			score
	//Description:	gets the value of the word
	//Parameters:	none
	//Returns:		int - the value of the word
	public int score()
	{
		return this.word.size();
	}
	//Name:			toPuzzle
	//Description:	converts a word into a puzzle
	//Parameters:	none
	//Returns:		Puzzle - the converted word
	public Puzzle toPuzzle()
	{
		Puzzle puzz = new Puzzle(this.toString());
		return puzz;
	}
	//Name:			toString
	//Description:	prints out a string representation of the word
	//Parameters:	none
	//Returns:		String - a string representation of the word
	public String toString()
	{
		String result ="";
		for(Letter l:this.word)
		{
			result += l.toString();
		}
		return result;
	}
}
