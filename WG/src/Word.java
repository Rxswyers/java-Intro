import java.util.ArrayList;
public class Word
{
	//members
	ArrayList<Letter> word;
	
	public Word(String s)
	{
		this.word = new ArrayList<Letter>();
		for(int i = 0; i < s.length(); i ++)
		{
			word.add(new Letter(s.charAt(i)));
		}
	}
	public String toString()
	{
		String result ="";
		for(Letter l:this.word)
		{
			result += l.toString();
		}
		return result;
	}
}
