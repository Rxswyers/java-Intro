/*Author: 			Ruben Swyers
* Creation Date: 	February 27, 2015 
* Due Date: 		 
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
	ArrayList<Letter> word;
	//boolean guessed;
	boolean used;
	
	public Word(String s)
	{
		this.word = new ArrayList<Letter>();
		for(int i = 0; i < s.length(); i ++)
		{
			word.add(new Letter(s.charAt(i)));
		}
		this.used = false;
	}
	public void use()
	{
		this.used = true;
	}
	public void resetUsed()
	{
		this.used = false;
	}
	public boolean isUsed()
	{
		return this.used;
	}
	public void guessBlanks(String g)
	{
		int letterIndex;
		int count = 0;
		//goes through the string (which will be the user's guess)
		//and checks to see if the letter is blanked out
		//if the user guesses all of the blanks it will print out
		//that you guessed them all!
		for(int i = 0; i < g.length(); i ++)
		{
			char c = (g.charAt(i));
			System.out.println("the new letter is " +c);
			//the word has one of the letters that were guessed
			if(this.has(c))
			{
				System.out.println("it has " + c);
				//gets the location of the letter
				letterIndex = this.indexOf(c);
				System.out.println("Has an index of " + letterIndex);
				//checks to see if that letter is blanked or not,
				//if it is blanked, it will increase the count
				//if it is not blanked it will skip
				if(this.word.get(letterIndex).isBlank())
				{
					if(!this.word.get(letterIndex).isGuessed())
					{
						this.word.get(letterIndex).guess(c);
						count ++;
					}
				}
			}
		}
		System.out.println("The number of things guessed right " +count);
	}
	public boolean has(char c)
	{
		for(Letter l:this.word)
		{
			if(l.is(c))
			{
				return true;
			}
		}
		return false;
	}
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
	//generates the blanks randomly
	public void genBlanks()
	{
		int count = 0;
		int randomNum = 0;
		RandomInteger rand = new RandomInteger(0,this.word.size()-1);
		//I'm only making half of the word blanked out because for longer words
		//it will be extremely difficult if only one letter were to be shown
		while(count < (this.word.size()-1)/2)
		{
			randomNum = rand.nextRandomIntegerInRange();
			if(this.word.get(randomNum).isBlank())
			{
				continue;
			}
			else
			{
				this.word.get(randomNum).makeBlank();
				count ++;
			}
		}
	}
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
