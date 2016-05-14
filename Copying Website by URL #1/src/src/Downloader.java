package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Downloader 
{
	public static void main(String[] args)
	{
		HashMap<String, Boolean> beenFound = new HashMap<String, Boolean>();
		Queue<String> qu = new LinkedList<String>();
		
		try 
		{
			Scanner in = new Scanner(System.in);
			
			String str = in.nextLine();
			long maxFiles = in.nextLong()*1000000;
			
			String path = "C:\\Judo Workspace\\WebsiteCopying\\websites\\" + str.substring(str.indexOf(':')+3, str.substring(str.indexOf(':')+3, str.length()).indexOf('/') + str.substring(0, str.indexOf('/')+1).length()+1) + "\\";
			
			qu.add(str);
			
			if (!new File(path).exists()) new File(path).mkdir();
			
			while (!qu.isEmpty())
			{
				String website = qu.poll();
				
				String name = extractName(website);
				
				System.out.println(path);
				System.out.println(name);
				
				try
				{
					FileWriter out = new FileWriter(path + name);
					URL url = new URL(website);
					
					InputStream is = url.openStream();
				
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					
					String line;
			        while ((line = br.readLine()) != null)
			        {
			        	int indexOf;
			        	if ((indexOf = line.indexOf("href=")) != -1)
			        	{
			        		String temp = line.substring(indexOf, line.length());
			        		String link = temp.substring(6, temp.indexOf('>')-1);
			        		
			        		if (beenFound.get(link) == null && link.startsWith("http://schools.yrdsb.ca/richmondgreen.ss/history/history/") || link.startsWith("http://www.markville.ss.yrdsb.edu.on.ca/history/history/"))
			        		{
			        			qu.add(link);
			        			beenFound.put(link, true);
			        			System.out.println("Added " + link);
					        	out.write(line.substring(0, indexOf+6) + extractName(link) + line.substring((indexOf+link.length()+6), line.length()));
			        		}
			        		else System.out.println("Denied " + link);
			        					        		
			        		System.out.println(link);
			        	}
			        	else out.write(line);
			        }
			        
			        out.close();
			            
			        --maxFiles;
			        if (maxFiles <= 0)
			        {
			        	System.err.println("[Alert] You have run out of usuable memory. To prevent system damage, the program will stop.");
			        	break;
			        }
				}
				catch (Exception ioException) 
				{
					
				}
			}
	    }
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String extractName(String in)
	{
		if (in.charAt(in.length()-1) == '/') in = in.substring(0, in.length()-1);
		
		if (in.lastIndexOf('.') < in.lastIndexOf('/')) in += ".html";
		
		if (in.contains("/")) in = in.substring(in.lastIndexOf('/')+1, in.length());
		
		return in;
	}
}
