/*Author: 			Ruben Swyers
* Creation Date: 	February 27, 2015 
* Due Date: 		 
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#1
* Filename: 		Test.java
* Purpose:		  	Tests aspects of the game as soon as I make the objects.
*/

public class Test
{
	public static void main(String []args)
	{
		/*Scanner keyboard = new Scanner(System.in);
		WordList w = new WordList();
		Puzzle pz;
		String guess;
		Player p = new Player("Ruben");
		
		w.loadWords();
		pz = w.getWord().toPuzzle();
		//pz = new Puzzle("poop");
		System.out.println(pz);
		
		pz.genBlanks();
		System.out.println(pz);
		guess = keyboard.nextLine();
		
		if(guess.length() != pz.numBlanks())
		{
			System.out.println("You have entered the wrong amount of characters to guess, please try again");
			System.out.println(pz);
			guess = keyboard.nextLine();
		}
		if(pz.guessBlanks(guess))
		{
			System.out.println("You guessed right!");
			System.out.println("You recieved a score of " + pz.score());
			p.addScore(pz.score());
		}
		else
		{
			System.out.println("You guessed wrong");
			System.out.println("You lost " + pz.score() + " points");
			p.subtractScore(pz.score());
		}
		System.out.println(p.getName() + "'s score is "+ p.getScore());
		keyboard.close();*/
		WordGame game = new WordGame();
		game.preGame();
	}
}
