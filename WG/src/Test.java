import java.io.IOException;
public class Test
{
	public static void main(String []args)
	{
		//Word w = new Word("Testing");
		WordList w = new WordList();
		try
		{
			w.loadWords();
		}catch (IOException e)
		{
			System.out.println("Your file didn't load");
			System.out.println(e);
		}
		
		System.out.println(w);
		//System.out.println(w);
	}
}
