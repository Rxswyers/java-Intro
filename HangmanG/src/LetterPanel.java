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
	int xOff;
	//int YOff;
	
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
		xOff = 60;
		
	}
	public void resetLetters()
	{
		Letters.clear();
	}
	public void setWord(Word w)
	{
		resetLetters();
		BufferedImage temp = null;
		for(int i = 0; i < w.length(); i++)
		{
			try
			{
				if(w.letterAt(i).isGuessed())
				{
					temp = loader.loadImage(Character.toString(w.charAt(i)).toUpperCase()+".png");
				}
				else
				{
					temp = loader.loadImage("blank.png");
				}
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
			g.drawImage(Letters.get(i),(0+(i*xOff)),0,64,64,this);
			g.drawImage(Dash, (2+(i*xOff)), 15, 64, 64, this);
		}
	}
}
