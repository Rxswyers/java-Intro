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
		WordList w = new WordList();
		
		w.loadWords();

		System.out.println(w);
	}
}
