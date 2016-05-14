package UI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OpenScreenCapture extends JFrame implements MouseListener
{
	BossButton boss;
	Dimension tk = Toolkit.getDefaultToolkit().getScreenSize();
	
	public OpenScreenCapture(BossButton b)
	{
		boss = b;
		
		this.setTitle("Boss Button");
		this.setSize((int)tk.getWidth(), (int)tk.getHeight());
		this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		JLabel screen = new JLabel();
		screen.addMouseListener(this);
		screen.setIcon(new ImageIcon("Screen.png"));
		screen.setSize(this.getWidth(), this.getHeight());
		this.add(screen);
	}

	public void mouseClicked(MouseEvent e) 
	{
		if (e.getX() > 800 &&  e.getY() < 200)
		{
			boss.restartUpdate();
			this.dispose();
		}
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}
