package src;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.Scanner;

public class Finder 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int target = in.nextInt();
		
		String loc = "C:\\Judo Workspace\\OfflinePOJ\\problems\\" + "prob " + ((target/50)*50) + 
				"-" + ((((target/50)+1)*50)-1) + "\\problem_" + (target+1000) + ".html";
			
		try 
		{
			Desktop.getDesktop().open(new File(loc));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
