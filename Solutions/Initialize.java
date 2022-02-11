import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Initialize 
{
	int scanLen, tumorLen;
	String file;
	List<String> fileLines;
	
	public Initialize(String file)
	{
		this.file = file;
		fileLines = new ArrayList<String>();
		initHeights();
	}
	
	public void initHeights()
	{
		Scanner inFile = null;
		try 
		{
			inFile = new Scanner(new File(file));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		while(inFile.hasNext())
		{
			fileLines.add(inFile.nextLine());
			int len = fileLines.size();
			if(fileLines.size() > 1 && fileLines.get(len - 1).length() != fileLines.get(len - 2).length())
			{
				scanLen = len - 1;
			}
		}
		inFile.close();
		
		tumorLen = fileLines.size() - scanLen;
	}
	
	public List<String> getScan()
	{
		List<String> lines = new ArrayList<String>();
		for(int i = 0; i < scanLen; i++)
		{
			lines.add(fileLines.get(i));
		}
		
		return lines;
	}
	
	public List<String> getTumor()
	{
		List<String> lines = new ArrayList<String>();
		for(int i = fileLines.size() - tumorLen; i < fileLines.size(); i++)
		{
			lines.add(fileLines.get(i));
		}
		
		return lines;
	}
}
