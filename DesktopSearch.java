import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DesktopSearch
{
	private static HashTable H;
	
	public static void main(String[] args) 
	{
		String[] commands = new String[args.length/2 +1];
		for(int i=0; i<args.length; i = i+2)
		{
			if(args[i] == null)	break;
			commands[i/2] = args[i+1];
		}
		H = new HashTable(Double.parseDouble(commands[1]));
		load(commands[0]);
		System.out.println("Hash tablosu olusturuldu");
		H.print();
		if(commands[2].equals("int"))
		{
			interactiveMod();
		}
		else
		{
			offlineMod(commands[3],commands[4]);
		}
		System.out.println("===================================");
	}
	
	public static void offlineMod(String offi,String offo)
	{
		PrintWriter outputStream = null;
		try
		{
			outputStream = new PrintWriter(offo);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void interactiveMod()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Sorgulari girebilirsiniz.");
		String query = keyboard.nextLine();
		while( !query.equals("-1"))
		{		
			
			query = keyboard.nextLine();
		}
	}
	public static void load(String directory)
	{
		Scanner keyboard = null;
		try
		{
			File file = new File(directory);
			File[] listOfFiles = file.listFiles();
			for(int i=0; i<listOfFiles.length; i++)
			{
				if(listOfFiles[i].isDirectory())
				{
					load(listOfFiles[i].getAbsolutePath());
				}
				else
				{
					if(listOfFiles[i].getName().endsWith(".txt"))
					{
						keyboard = new Scanner( new FileInputStream(listOfFiles[i].getName()) );
						while(keyboard.hasNextLine())
						{
							H.put(keyboard.nextLine(), listOfFiles[i].getAbsolutePath());
						}
					}
						
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
