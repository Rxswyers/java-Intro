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
	boolean guessed;
	boolean used;
	
	public Word(String s)
	{
		this.word = new ArrayList<Letter>();
		for(int i = 0; i < s.length(); i ++)
		{
			word.add(new Letter(s.charAt(i)));
		}
	}
	//generates the blanks randomly
	public void genBlanks()
	{
		System.out.println("Do something");
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
