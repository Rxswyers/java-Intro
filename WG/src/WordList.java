/*Author: 			Ruben Swyers
* Creation Date: 	February 27, 2015 
* Due Date: 		 
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
import java.util.Scanner;
public class WordList
{
	//members
	ArrayList<Word> words;
	
	
	public WordList ()
	{
		this.words = new ArrayList<Word>();
	}
	//load the list from a file "words.txt"
	//if it doesn't work for some reason there will be an IOException
	public void loadFromFile() throws IOException
	{
		File dir = new File(".");
		//File.separator is platform independent, so it will use / or \ depending on
		//the system it runs on. getCononicalPath is the abosulte path
		File fin = new File(dir.getCanonicalPath() + File.separator + "words.txt");
		FileInputStream fileinput = new FileInputStream(fin);
		BufferedReader buff = new BufferedReader(new InputStreamReader(fileinput));
		
		String line = null;
		
		while((line = buff.readLine()) != null)
		{
			//adds the word to the file
			//the file should have a word on each line
			this.words.add(new Word(line));
		}
		//close out the file
		buff.close();
	}
	//loads the wordlist from words.txt, if it's not there it will fill the list
	//with a default list of words
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
	//takes in an array of strings that will be added to the word list
	//this will be used if reading from a file fails
	public void setDefaultWords(String [] ws)
	{
		for(String w:ws)
		{
			this.words.add(new Word(w));
		}
		
	}
	//returns an unused word from the list
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
		return new Word("Return");
	}
	//Asks the player if they want to reuse the list once every word is used once
	/*public void listExhausted()
	{
		char userIn;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("You have used every word in the list once already, would you like to keep playing? (Y/y for yes, N/n for no)");
		
		userIn = keyboard.next().charAt(0);
		if(userIn == 'Y' || userIn =='y')
		{
			this.resetWordsUsed();
		}
		else if(userIn == 'N' || userIn == 'n')
		{
			
		}
	}*/
	public void resetWordsUsed()
	{
		for(Word w: this.words)
		{
			w.resetUsed();
		}
	}
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
