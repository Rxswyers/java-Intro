/*Author: 			Ruben Swyers
* Creation Date: 	February 27, 2015 
* Due Date: 		 
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#1
* Filename: 		WordGame.java
* Purpose:		  	Class, Handles the game and its methods
*/

public class WordGame
{
	//members
	private Player P;
	private WordList Wordlist;
	private Word Puzzle;
	
	//name is the name of the player
	public WordGame(String name)
	{
		this.P = new Player(name);
		this.Wordlist = new WordList();
		this.Wordlist.loadWords();
		this.Puzzle = this.Wordlist.getWord();
	}
	
	
}
