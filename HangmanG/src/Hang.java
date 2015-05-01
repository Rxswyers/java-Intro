import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Hang extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int part;
	BufferedImage ss;
	BufferedImage letter;
	BufferedImage letter2;
	BufferedImage letter3;
	public Hang()
	{
		BufferedImageLoader loader = new BufferedImageLoader();

		part = 7;
		try
		{
			File dir = new File(".");
			ss = loader.loadImage(dir.getCanonicalPath() + File.separator + "dash.png");
			letter = loader.loadImage(dir.getCanonicalPath() + File.separator + "A.png");
			letter2 = loader.loadImage(dir.getCanonicalPath() + File.separator + "B.png");
			letter3 = loader.loadImage(dir.getCanonicalPath() + File.separator + "C.png");
		}catch(IOException e)
		{
			System.out.println(e);
		}
		
		
	}
	public void nextPart()
	{
		part --;
	}
	public boolean checkLoss()
	{
		if(part == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void reset()
	{
		part = 7;
	}
	protected void paintComponent(Graphics g)
	{
		//150,200
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
