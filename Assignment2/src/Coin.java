
public class Coin
{
	protected int value;
	
	public Coin()
	{
	}
	public int getValue()
	{
		return this.value;
	}
	public int add(Coin C)
	{
		return C.getValue() + this.getValue();
	}
}
