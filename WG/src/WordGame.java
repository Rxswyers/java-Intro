/*Author: 			Ruben Swyers
* Creation Date: 	February 27, 2015 
* Due Date: 		March 5, 2015
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#1
* Filename: 		WordGame.java
* Purpose:		  	Class, Handles the game and its methods
*/
import java.util.Scanner;
public class WordGame
{
	//members
	private Player P;
	private WordList Wordlist;
	private Puzzle pz;
	private boolean over;
	private int guesses;
	private Scanner keyboard;
	
	//Name:			WordGame
	//Description:	Constructor for a WordGame
	//Parameters:	none
	//Returns:		none
	public WordGame()
	{
		this.P = new Player();
		this.Wordlist = new WordList();
		this.Wordlist.loadWords();
		this.pz = this.Wordlist.getWord().toPuzzle();
		this.over = false;
		this.guesses = 0;
		this.keyboard = new Scanner(System.in);
	}
	//Name:			preGame
	//Description:	Prints out instructions for the player, then asks them if they want to play or see the instructions
	//if they choose to view the instructions, the game begins right after
	//Parameters:	none
	//Returns:		none
	public void preGame()
	{
		String choice;
		this.printInstructions();
		System.out.println("Would you like to play or would you like to see the instructions again? (y/Y for to play, n/N to quit, or i/I to see the instructions)");
		choice = keyboard.nextLine();
		if(choice.equalsIgnoreCase("i"))
		{
			this.printInstructions();
			System.out.println("The game will now start");
			this.startGame();
		}
		else if(choice.equalsIgnoreCase("n"))
		{
			System.out.println("You chose not to play, bye");
			System.exit(0);
		}
		else if(choice.equalsIgnoreCase("y"))
		{
			this.startGame();
		}
		else
		{
			System.out.println("You did not enter y/Y, n/N, or i/I, please do");
			choice = keyboard.nextLine();
			if(choice.equalsIgnoreCase("i"))
			{
				this.printInstructions();
				System.out.println("The game will now start");
				this.startGame();
			}
			else if(choice.equalsIgnoreCase("n"))
			{
				System.out.println("You chose not to play, bye");
				System.exit(0);
			}
			else if(choice.equalsIgnoreCase("y"))
			{
				this.startGame();
			}
			else
			{
				System.exit(0);
			}
		}
	}
	//Name:			startGame
	//Description:	the method of the class that makes the game keep going or to end
	//Parameters:	none
	//Returns:		none
	public void startGame()
	{
		while(!this.over)
		{
			this.nextTurn();
		}
	}
	//Name:			nextTurn
	//Description:	Handles one turn of guessing a word
	//Parameters:	none
	//Returns:		none
	public void nextTurn()
	{
		
		this.pz.genBlanks();
		System.out.println("Please guess the blanks");
		System.out.println(this.pz);
		this.score(this.getGuess());
		//gets a new puzzle if the game isn't going to end
		if(this.guesses == 3)
		{
			this.stopGame();
		}
		else
		{
			this.pz = this.Wordlist.getWord().toPuzzle();
		}
	}
	//Name:			getGuess
	//Description:	Gets a user's guess and checks to see if it is the appropriate length
	//Parameters:	none
	//Returns:		String - the user's guess
	public String getGuess()
	{
		String guess;
		guess = this.keyboard.nextLine();
		if(!this.checkGuess(guess))
		{
			System.out.println("You did not enter the right amount of blanks, please try again!");
			System.out.println(this.pz);
			guess = this.keyboard.nextLine();
		}
		return guess;
	}
	//Name:			score
	//Description:	Handles the scoring of the puzzle
	//Parameters:	String - the user's guess
	//Returns:		none
	public void score(String g)
	{
		if(pz.guessBlanks(g))
		{
			System.out.println("You guessed right!");
			System.out.println("You recieved a score of " + pz.score());
			P.addScore(pz.score());
			System.out.println("You have a score of "+ P.getScore());
			if(!keepGoing())
			{
				this.stopGame();
			}
			this.guesses = 0;
		}
		else
		{
			System.out.println("You guessed wrong");
			this.pz.clearBlanks();
			System.out.println("The correct word was " + pz);
			System.out.println("You lost " + pz.score() + " points");
			P.subtractScore(pz.score());
			System.out.println("You have a score of "+ P.getScore());
			this.guesses ++;
		}
		
	}
	//Name:			keepGoing
	//Description:	Asks the user if they wish to keep going
	//Parameters:	none
	//Returns:		boolean
	//				true - if they say yes
	//				false - if they say no
	public boolean keepGoing()
	{
		String choice;
		System.out.println("Would you like to continue? (Y/y for yes, N/n for no)");
		choice = this.keyboard.nextLine();
		if(choice.equals("y") || choice.equals("Y"))
		{
			return true;
		}
		else if(choice.equals("n") || choice.equals("N"))
		{
			return false;
		}
		else
		{
			System.out.println("Please type in Y/y for yes or N/n for no");
			choice = this.keyboard.nextLine();
			if(choice.equals("y") || choice.equals("Y"))
			{
				return true;
			}
			else //if they don't enter y or Y, then the game will end no matter what
			{
				return false;
			}
		}
		
	}
	//Name:			checkGuess
	//Description:	Checks to see if the user guessed the right amount of characters
	//Parameters:	String - user's guess
	//Returns:		boolean
	//				true - if they guessed the appropriate amount
	//				false - if they didn't guess the appropriate amount
	public boolean checkGuess(String g)
	{
		if(g.length() == this.pz.numBlanks())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Name:			printInstructions
	//Description:	Prints the instructions for the game
	//Parameters:	none
	//Returns:		none
	public void printInstructions()
	{
		System.out.println("This is a word game.");
		System.out.println("You will be given a word that has letter blanked out with X's (X)");
		System.out.println("There may be one or more X's in each word");
		System.out.println("You are to enter the characters that you think fill in the blanks");
		System.out.println("If you have three wrong guesses in a row, the game will end");
		System.out.println("Please do not leave any spaces in between the characters when you enter them");
	}
	//Name:			stopGame
	//Description:	stops the game and displays the score of the player
	//Parameters:	none
	//Returns:		none
	public void stopGame()
	{
		System.out.println("The game has ended");
		System.out.println("You have a score of " + P.score);
		this.keyboard.close();
		System.exit(0);
	}
}
