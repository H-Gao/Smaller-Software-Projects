package Classes;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Detector 
{
	static Display d;
	
	public static void main(String args[]) throws Exception
	{
		while (true)
		{
			Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
			Transferable t = c.getContents(null);
			
			if (t.getTransferDataFlavors().length == 1 && t.getTransferDataFlavors()[0].equals(DataFlavor.imageFlavor))
			{
				BufferedImage img = (BufferedImage)t.getTransferData(DataFlavor.imageFlavor);
				
				int counter = 0;
			
				while (counter < 150)
				{
					PointerInfo p = MouseInfo.getPointerInfo();
					
					if (p.getLocation().x > 1200 && p.getLocation().y < 100)
					{
						++counter;
					}
					else
					{
						counter = 0;
					}
					
					Thread.sleep(10);
				}
				
				d = new Display(img);
				
				counter = 0;
				
				while (counter < 800)
				{
					PointerInfo p = MouseInfo.getPointerInfo();
					
					if (p.getLocation().x > 1200 && p.getLocation().y < 100)
					{
						++counter;
					}
					else
					{
						counter = 0;
					}
					
					Thread.sleep(10);
				}
				
				d.dispose();
				Thread.sleep(1000);
			}
			
			Thread.sleep(10);
		}
	}
}
