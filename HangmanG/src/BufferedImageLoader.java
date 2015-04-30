import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
public class BufferedImageLoader
{
  public BufferedImage loadImage(String fileName) throws IOException
  {
    URL url = new URL(fileName);
    BufferedImage img = ImageIO.read(url);
    return img;
  }
}