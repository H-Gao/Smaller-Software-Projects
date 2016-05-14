package UI;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class BossButton extends JDialog implements MouseListener
{
	UpdateImage update;
	OpenScreenCapture o;
	
	BossButton boss;
	JLabel hide;
	
	public BossButton()
	{
		boss = this;
		init();
		
		restartUpdate();
	}
	
	public void init()
	{
		this.setSize(100, 60);
		this.setUndecorated(true);
		this.setVisible(true);
		
		ImageIcon icon = new ImageIcon("BossButton.png");
		
		hide =  new JLabel();
		hide.addMouseListener(this);
		hide.setIcon(icon);
		hide.setSize(icon.getIconWidth(), icon.getIconHeight());
		this.add(hide);
	}
	
	public class UpdateImage extends Thread implements Runnable
	{
		boolean terminate = false;
		
		public UpdateImage()
		{
			this.start();
		}
		
		public void run()
		{
			while (!terminate)
			{
				try
				{
					boss.setVisible(false);
					this.sleep(10);
					
					Robot r = new Robot();
					hide.setIcon(new ImageIcon(r.createScreenCapture(new Rectangle(100, 60))));
					boss.setVisible(true);
					this.sleep(2000);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void restartUpdate()
	{
		update = new UpdateImage();
	}
	
	public static void main(String args[])
	{
		BossButton b = new BossButton();
	}

	public void mouseClicked(MouseEvent e) 
	{
		update.terminate = true;
		o = new OpenScreenCapture(this);
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}
