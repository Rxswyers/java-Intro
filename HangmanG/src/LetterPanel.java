/*Author: 			Ruben Swyers
* Creation Date: 	April 30, 2015 
* Due Date: 		April 30, 2015
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#3
* Filename: 		LetterPanel.java
* Purpose:		  	Panel that holds the letters and dashes in the game
*/
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;


public class LetterPanel extends JPanel
{
	/**
	 * Pleasing the Eclipse editor by making it have a serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	//members
	ArrayList<BufferedImage> Letters;
	BufferedImage Dash;
	BufferedImageLoader loader;
	int xOff;
	//Constructor for letterpanel
	public LetterPanel()
	{
		//uses the loading utility I made
		loader = new BufferedImageLoader();
		//sets up the letters
		Letters = new ArrayList<BufferedImage>();
		//gets the dash image
		try
		{
			Dash = loader.loadImage("dash.png");
		}catch(IOException e)
		{
			System.out.println(e);
		}
		//sets the x offset for a letter
		xOff = 60;
		
	}
	//Name:			resetLetters
	//Discription:	clears all of the images from the arraylist
	//Parameters:	n/a
	//Returns:		n/a
	public void resetLetters()
	{
		Letters.clear();
	}
	//Name:			setWord
	//Discription:	sets the word for the letterpanel
	//Parameters:	the word to set
	//Returns:		n/a
	public void setWord(Word w)
	{
		//clears it out before adding more
		resetLetters();
		//sets up the temp image
		BufferedImage temp = null;
		//sets up what displays on the letterpanel
		for(int i = 0; i < w.length(); i++)
		{
			try
			{
				//if the letter is guessed, it'll show
				if(w.letterAt(i).isGuessed())
				{
					temp = loader.loadImage(Character.toString(w.charAt(i)).toUpperCase()+".png");
				}
				//if it's not guessed, a blank will be shown
				else
				{
					temp = loader.loadImage("blank.png");
				}
			}catch(IOException e)
			{
				System.out.println(e);
			}
			//adds the letter to the arraylist
			Letters.add(temp);
		}
	}
	//Name:			paintComponent
	//Discription:	paints the letters on the panel
	//Parameters:	Graphics
	//Returns:		n/a
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i = 0; i < Letters.size(); i ++)
		{
			g.drawImage(Letters.get(i),(0+(i*xOff)),0,64,64,this);
			g.drawImage(Dash, (2+(i*xOff)), 15, 64, 64, this);
		}
	}
}
