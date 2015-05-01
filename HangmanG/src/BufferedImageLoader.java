/*Author: 			Ruben Swyers
* Creation Date: 	April 30, 2015 
* Due Date: 		April 30, 2015
* Course: 			CSC243
* Professor Name: 	Dr. Kaplan
* Assignment: 		#3
* Filename: 		BufferedImageLoader.java
* Purpose:		  	Utility to load a bufferedImage
*/
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BufferedImageLoader
{
	//Name:			loadImage
	//Discription:	gets an image from a file name
	//Parameters:	The file name
	//Returns:		The image with that name
	public BufferedImage loadImage(String fileName) throws IOException
	{
		BufferedImage img = ImageIO.read(new File(fileName));
		return img;
	}
}