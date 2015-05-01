/*Author: 			Ruben Swyers
* Creation Date: 	April 30, 2015 
* Due Date: 		April 30, 2015
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#3
* Filename: 		Hang.java
* Purpose:		  	Handles the gallows of the game
*/
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Hang extends JPanel
{
	/**
	 * Pleasing the Eclipse editor by making it have a serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private int part;
	BufferedImage ss;
	BufferedImage letter;
	BufferedImage letter2;
	BufferedImage letter3;
	//Constructor for Hang
	public Hang()
	{
		//set the number of parts to guess
		part = 7;
		
	}
	//Name:			nextPart
	//Discription:	updates the gallows by adding another part on it
	//Parameters:	n/a
	//Returns:		n/a
	public void nextPart()
	{
		part --;
	}
	//Name:			checkLoss
	//Discription:	checks to see if the last body part is showing
	//Parameters:	n/a
	//Returns:		true - you lost
	//				false - you didn't lose
	public boolean checkLoss()
	{
		if(part == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Name:			reset
	//Discription:	resets the gallows
	//Parameters:	n/a
	//Returns:		n/a
	public void reset()
	{
		part = 7;
	}
	//Name:			paintComponent
	//Discription:	handles the paint for the gallows
	//Parameters:	Graphics
	//Returns:		n/a
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//the right side
		g.drawLine(149, 0, 149, 199);
		//top line
		g.drawLine(149, 0, 75, 0);
		//line going vertical from the top
		g.drawLine(75, 0, 75, 40);
		//Bottom line
		g.drawLine(75, 199, 149, 199);
		//Diagonal
		g.drawLine(130, 199, 149, 180);
		
		switch(part)
		{
			case 1:
				//right leg
				g.drawLine(75, 100, 95, 120);
			case 2:
				//left leg
				g.drawLine(75,100,55,120);
			case 3:
				//right arm
				g.drawLine(75, 80, 95, 70);
			case 4:
				//left arm
				g.drawLine(75, 80, 55, 70);
			case 5:
				//body
				g.drawLine(75, 70, 75, 100);
			case 6:
				//head
				g.drawOval(60, 40, 30, 30);
		}
	}
}
