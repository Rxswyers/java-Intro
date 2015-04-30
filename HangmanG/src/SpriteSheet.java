import java.awt.image.BufferedImage;
/**
Handles getting parts of a sprite sheet to animate
*/
public class SpriteSheet
{
	/**
	Holds the entire sprite sheet
	*/
  public BufferedImage spriteSheet;
	/**
	Constructor, sets the sprite 
	@param ss					Sprite sheet
	*/
  public SpriteSheet(BufferedImage ss)
  {
    this.spriteSheet = ss;
  }
	/**
	Gets a specific part of the whole sprite sheet
	@param x				X coordinate
	@param y				Y coordinate
	@param width		Width of the sprite
	@param height		Height of the sprite
	*/
  public BufferedImage getSprite(int x, int y, int width, int height)
  {
    BufferedImage sprite = spriteSheet.getSubimage(x,y,width,height);
    return sprite;
  }
}