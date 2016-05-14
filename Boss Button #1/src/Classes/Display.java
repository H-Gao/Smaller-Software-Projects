package Classes;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Display extends JFrame
{
	public Display(BufferedImage img)
	{
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setSize((int)d.getWidth(), (int)d.getHeight());
		this.setUndecorated(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel image = new JLabel();
		image.setIcon(new ImageIcon(img));
		image.setSize(img.getWidth(), img.getHeight());
		this.add(image);
		
	}
}
