
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
	public double add(double d)
	{
		return this.getValue() + d;
	}
}
