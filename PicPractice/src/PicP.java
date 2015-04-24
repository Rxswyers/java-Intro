//Ruben Swyers
//Picture Practice

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PicP extends JFrame
{
	public PicP(String s)
	{
		super(s);
		setSize(1000,667);
		PicturePanel picturePanel = new PicturePanel();
		add(picturePanel);
		this.setVisible(true);
	}
	private class PicturePanel extends JPanel
	{
		BufferedImage img;
		public PicturePanel()
		{
			img = getImage("http://apod.nasa.gov/apod/image/1504/IMG_2999korosecMilkyMet.png");
		}
		public void paintComponent(Graphics g)
		{
			g.drawImage(img,0,0,this);
		}
		private BufferedImage getImage(String fname)
		{
			try{
				URL url = new URL(fname);
				return ImageIO.read(url);
			}catch(IOException e)
			{
				System.out.println("Your file couldn't be loaded");
				
				System.exit(1);
			}
			return null;
		}
	}
	public static void main (String args[])
	{
		new PicP("Apod Pic");
	}
}