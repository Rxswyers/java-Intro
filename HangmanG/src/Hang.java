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
	public Hang()
	{
		BufferedImageLoader loader = new BufferedImageLoader();

		
		try
		{
			File dir = new File(".");
			ss = loader.loadImage(dir.getCanonicalPath() + File.separator + "dash.png");
		}catch(IOException e)
		{
			System.out.println(e);
		}
		
		
	}
	public void nextPart()
	{
		part ++;
	}
	protected void paintComponent(Graphics g)
	{
		//150,200
		//100,100
		super.paintComponent(g);
		//the right side
		//g.drawLine(99, 0, 99, 99);
		g.drawLine(149, 0, 149, 199);
		//top line
		//g.drawLine(99, 0, 50, 0);
		g.drawLine(149, 0, 75, 0);
		//line going vertical from the top
		//g.drawLine(50, 0, 50, 20);
		g.drawLine(75, 0, 75, 40);
		//Bottom line
		//g.drawLine(50, 99, 99, 99);
		g.drawLine(75, 199, 149, 199);
		//Diagonal
		//g.drawLine(80, 99, 99, 80);
		g.drawLine(130, 199, 149, 180);
		g.drawImage(ss,0,0,64,64,this);
	}
}
