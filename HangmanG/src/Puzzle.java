/*Author: 			Ruben Swyers
* Creation Date: 	February 27, 2015 
* Due Date: 		March 5, 2015
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#1
* Filename: 		Puzzle.java
* Purpose:		  	Class, this is a child of Word.
* 					It is what the user will see and guess in the game
*/
import java.util.ArrayList;
public class Puzzle extends Word
{
	//Name:			Puzzle
	//Description:	Constructor for a Puzzle
	//Parameters:	String - the string that the Puzzle will represent
	//Returns:		none
	public Puzzle (String s,String c)
	{
		super(s,c);
	}
	//Name:			guessBlanks
	//Description:	checks to see if the user guessed the right blanks
	//Parameters:	String - the user's guess
	//Returns:		boolean
	//				true - if the user guessed right
	//				false - if the user did not guess right
	public boolean guessBlanks(String g)
	{
		char guessChar = g.charAt(0);
		char lowerGuess = Character.toLowerCase(guessChar);
		boolean found = false;
		Letter l = null;
		//goes through the string (which will be the user's guess)
		//and checks to see if the letter is blanked out
		//if the user guesses all of the blanks it will print out
		//that you guessed them all!
		if(this.guess(lowerGuess))
		{
			for(int i = 0; i < word.size(); i ++)
			{
				l = word.get(i);
				char c = (l.getChar());
				
				//the word has one of the letters that were guessed
				System.out.println("Guess " + Character.toString(lowerGuess) + " letter " + Character.toString(c));
				if(c == lowerGuess)
				{
					if(!l.isGuessed())
					{
						l.guess(lowerGuess);
						found = true;
					}
				}
			}
		}
		return found;

	}
	public boolean guess(char g)
	{
		for(Letter l:word)
		{
			if(l.getChar() == g)
			{
				return true;
			}
		}
		return false;
	}
	//Name:			hasBlank
	//Description:	Looks to see if if the character is a blank
	//Parameters:	char - the character to check
	//Returns:		boolean
	//				true - if the character is a blank
	//				false - if it is not
	public boolean hasBlank(char c)
	{
		ArrayList<Letter> blanks = new ArrayList<Letter>();
		
		for(Letter l:this.word)
		{
			if(l.isBlank())
			{
				blanks.add(l);
			}
		}
		for (Letter blank:blanks)
		{
			if(blank.is(c))
			{
				if(blank.isGuessed())
				{
					continue;
				}
				else
				{
					blank.guess(c);
					return true;
				}
			}
		}
		return false;
	}
	public void guessAll()
	{
		for(Letter l: word)
		{
			l.setGuessed();
		}
	}
	//Name:			genBlanks
	//Description:	generates the blanks randomly
	//Parameters:	none
	//Returns:		none
	public void genBlanks()
	{
		//I'm only making half of the word blanked out because for longer words
		//it will be extremely difficult if only one letter were to be shown
		for(int i = 0; i < word.size(); i ++)
		{
				this.word.get(i).makeBlank();
		}
	}
	//Name:			numBlanks
	//Description:	Gets the number of blanks in the puzzle
	//Parameters:	none
	//Returns:		int - the number of blanks
	public int numBlanks()
	{
		int result = 0;
		for(Letter l: this.word)
		{
			if(l.isBlank())
			{
				result ++;
			}
		}
		return result;
	}
	//Name:			clearBlanks
	//Description:	Clears the blanks of the puzzle so it can be displayed properly
	//Parameters:	none
	//Returns:		none
	public void clearBlanks()
	{
		for(Letter l:this.word)
		{
			l.clearBlank();
		}
	}
	//Name:			indexOf
	//Description:	looks for the index of a character
	//Parameters:	char - character to look for
	//Returns:		int - the index of that character
	public int indexOf(char c)
	{
		for(Letter l:this.word)
		{
			if(l.is(c))
			{
				return this.word.indexOf(l);
			}
		}
		return -1;
	}
	//Name:			toString
	//Description:	Gets a string representation of the Puzzle
	//Parameters:	none
	//Returns:		String - string representation of the Puzzle
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
