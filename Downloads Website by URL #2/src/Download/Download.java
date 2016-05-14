package Download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Download 
{
	public static void main(String args[])
	{
		try 
		{
			URL url = new URL("https://www.oracle.com/corporate/careers/index.html");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String input;
			while ((input = in.readLine()) != null)
			{
				int index;
				while ((index = input.indexOf("href=" + (char)34)) != -1)
				{
					input = input.substring(index+6, input.length());
					
					int index2 = input.indexOf((char)34);
					System.out.println(input.substring(0, index2));
				}
			}
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
