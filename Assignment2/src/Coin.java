
public class Coin
{
	protected double value;
	
	public Coin()
	{
	}
	public double getValue()
	{
		return this.value;
	}
	public double add(Coin C)
	{
		return C.getValue() + this.getValue();
	}
}
