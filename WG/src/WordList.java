import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class WordList
{
	//members
	ArrayList<Word> words;
	
	public WordList ()
	{
		this.words = new ArrayList<Word>();
	}
	//load the list from a file "words.txt"
	public void loadWords() throws IOException
	{
		File dir = new File(".");
		//File.separator is platform independent, so it will use / or \ depending on
		//the system it runs on. getCononicalPath is the abosulte path
		File fin = new File(dir.getCanonicalPath() + File.separator + "words.txt");
		FileInputStream fileinput = new FileInputStream(fin);
		BufferedReader buff = new BufferedReader(new InputStreamReader(fileinput));
		
		String line = null;
		
		while((line = buff.readLine()) != null)
		{
			System.out.println(line);
			//adds the word to the file
			//the file should have a word on each line
			this.words.add(new Word(line));
		}
		//close out the file
		buff.close();
		
	}
	public String toString()
	{
		String result = "";
		for(Word w: words)
		{
			result += w.toString() + "\n";
		}
		return result;
	}
}
