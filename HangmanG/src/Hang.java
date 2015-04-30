import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Hang extends JPanel
{
	private int part;
	BufferedImage test;
	public Hang()
	{
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage ss = null;
		
		try
		{
			File dir = new File(".");
			ss = loader.loadImage(dir.getCanonicalPath() + File.separator + "Alphabet.png");
		}catch(IOException e)
		{
			System.out.println(e);
		}
		SpriteSheet sprite = new SpriteSheet(ss);
		test = sprite.getSprite(0, 0, 64, 64);
	}
	public void nextPart()
	{
		part ++;
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawRect(0, 0, 20, 20);
		g.fillRect(0, 0, 20, 20);
		g.drawImage(test,0,0,64,64,this);
	}
}
