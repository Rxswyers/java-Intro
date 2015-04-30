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
	
	public LetterPanel()
	{
		Letters = new ArrayList<BufferedImage>();
		//Dash = new BufferedImage();
	}
	
	public void setWord(Word w)
	{
		BufferedImageLoader loader = new BufferedImageLoader();
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
		}
	}
}
