import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
public class BufferedImageLoader
{
  public BufferedImage loadImage(String fileName) throws IOException
  {
    BufferedImage img = ImageIO.read(new File(fileName));
    return img;
  }
}