/*Author: 			Ruben Swyers
* Creation Date: 	February 27, 2015 
* Due Date: 		March 5, 2015
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#1
* Filename: 		WordList.java
* Purpose:		  	Class, Hold words to be used for the game
*/
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class WordList
{
	//members
	ArrayList<Word> words;
	
	//Name:			WordList
	//Description:	Constructor for a WordList
	//Parameters:	none
	//Returns:		none
	public WordList ()
	{
		this.words = new ArrayList<Word>();
	}
	//Name:			loadFromFile
	//Description:	loads the list from a file "words.txt", if it doesn't work for some reason
	//				an IOException will be thrown
	//Parameters:	none
	//Returns:		none
	public void loadFromFile() throws IOException
	{
		File dir = new File(".");
		//File.separator is platform independent, so it will use / or \ depending on
		//the system it runs on. getCononicalPath is the abosulte path
		File fin = new File(dir.getCanonicalPath() + File.separator + "newWords.txt");
		FileInputStream fileinput = new FileInputStream(fin);
		BufferedReader buff = new BufferedReader(new InputStreamReader(fileinput));
		
		String line = null;
		
		while((line = buff.readLine()) != null)
		{
			String [] parts = line.split(" ");
			//adds the word to the file
			//the file should have a word on each line
			this.words.add(new Word(parts[0],parts[1]));
		}
		//close out the file
		buff.close();
	}
	//Name:			loadWords
	//Description:	calls loadFromFile, if it fails it will load the list with a default set
	//				of words
	//Parameters:	none
	//Returns:		none
	public void loadWords()
	{
		try
		{
			this.loadFromFile();
		}catch (IOException e)
		{
			System.out.println("Your file didn't load " + e);
			System.out.println("Using predefined word list.");
			//make a default array of 25 strings to be converted to the wordlist
			String [] defWords = {"array","player","simple", "list","word","mouse","keyboard",
					"letter","friend","orange","fresh","integer","external","attemp","note",
					"charge","drive","battery","beach","access","initial","student","universal",
					"screwdriver","raspberry"};
			this.setDefaultWords(defWords);
		}
	}
	//Name:			setDefaultWords
	//Description:	takes in an array of strings that will be added to the word list
	//Parameters:	String array - Strings to be put into the list
	//Returns:		none
	public void setDefaultWords(String [] ws)
	{
		for(String w:ws)
		{
			this.words.add(new Word(w,"thing"));
		}
		
	}
	//Name:			getWord
	//Description:	gets an unused word from the list
	//Parameters:	none
	//Returns:		Word - an unused word
	public Word getWord()
	{
		RandomInteger rand = new RandomInteger(0,this.words.size()-1);
		int randomNum = 0;
		int count = 0;
		//get a random number that is between size of the list - 1 and 0
		//check that index and see if the word is used, if it is, get another random num
		while(count < this.words.size())
		{
			randomNum = rand.nextRandomIntegerInRange();
			if(this.words.get(randomNum).isUsed())
			{
				count ++;
				continue;
			}
			else
			{
				this.words.get(randomNum).use();
				return this.words.get(randomNum);
				
			}
		}
		return new Word("Return","thing");
	}
	//Name:			resetWordsUsed
	//Description:	resets all of the used values for used in the list
	//Parameters:	none
	//Returns:		none
	public void resetWordsUsed()
	{
		for(Word w: this.words)
		{
			w.resetUsed();
		}
	}
	//Name:			toString
	//Description:	returns a string representation of the word list
	//Parameters:	none
	//Returns:		String - string representation of the word list
	public String toString()
	{
		String result = "";
		for(Word w: words)
		{
			result += w.toString() + "\n";
		}
		return result;
	}
}
