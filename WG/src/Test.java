/*Author: 			Ruben Swyers
* Creation Date: 	February 27, 2015 
* Due Date: 		 
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#1
* Filename: 		Test.java
* Purpose:		  	Tests aspects of the game as soon as I make the objects.
*/
import java.util.Scanner;
public class Test
{
	public static void main(String []args)
	{
		Scanner keyboard = new Scanner(System.in);
		WordList w = new WordList();
		Word Puzzle;
		String guess;
		w.loadWords();
		//Puzzle = w.getWord();
		Puzzle = new Word("poop");
		System.out.println(Puzzle);
		
		Puzzle.genBlanks();
		System.out.println(Puzzle);
		guess = keyboard.nextLine();
		Puzzle.guessBlanks(guess);
		keyboard.close();
	}
}
