import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Hang extends JPanel
{
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawRect(0, 0, 20, 20);
		g.fillRect(0, 0, 20, 20);
	}
}
