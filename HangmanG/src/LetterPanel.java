import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;


public class LetterPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<BufferedImage> Letters;
	BufferedImage Dash;
	BufferedImageLoader loader;
	
	public LetterPanel()
	{
		loader = new BufferedImageLoader();
		Letters = new ArrayList<BufferedImage>();
		try
		{
			Dash = loader.loadImage("dash.png");
		}catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	public void setWord(Word w)
	{
		
		BufferedImage temp = null;
		for(int i = 0; i < w.length(); i++)
		{
			try
			{
				temp = loader.loadImage(Character.toString(w.charAt(i))+".png");
			}catch(IOException e)
			{
				System.out.println(e);
			}
			Letters.add(temp);
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i = 0; i < Letters.size(); i ++)
		{
			
		}
	}
}
