import java.util.concurrent.SynchronousQueue;

public class CoinCounterMechanism
{
	int coins[] = {1, 5 ,10, 25, 50, 100}; 
	RandomInteger rm = new RandomInteger(0,5);
	int coinCount[] = {0,0,0,0,0,0};
	boolean consumerFlag = false;
	boolean producerFlag = false;
	Coin C;
	double total;
	
	void setConsumerFlag()
	{
		consumerFlag = true;
	}
	
	void resetConsumerFlag()
	{
		consumerFlag = false;
	}
	
	void setProducerFlag()
	{
		producerFlag = true;
	}
	
	void resetProducerFlag()
	{
		producerFlag = false;
	}
	//added my own methods to help out
	//Name:			getCounts
	//Description:	changes the array of integers to the counts
	//Parameters:	Array of ints - the counts of the coins
	//Returns:		none
	void getCounts(int[] cs)
	{
		for(int i = 0; i < 6; i ++)
		{
			cs[i] = coinCount[i];
		}
	}
	//Name:			getTotal
	//Description:	returns the total
	//Parameters:	N/A
	//Returns:		the total
	double getTotal()
	{
		return total;
	}
	//Name:			chooseCoin
	//Description:	Returns the right coin based on the Integer that is taken in
	//				also increments the appropriate coinCount index
	//Parameters:	Integer I - should be 1,5,10,25,50, or 100
	//Returns:		Coin - the right coin based on I
	Coin chooseCoin(Integer I)
	{
		switch(I)
		{ 
			case 1:
				this.coinCount[0]++;
				return new Penny();
			case 5:
				this.coinCount[1]++;
				return new Nickel();
			case 10:
				this.coinCount[2]++;
				return new Dime();
			case 25:
				this.coinCount[3]++;
				return new Quarter();
			case 50:
				this.coinCount[4]++;
				return new HalfDollar();
			case 100:
				this.coinCount[5]++;
				return new Dollar();
			default:
				return new Coin();
			
		}
	}
	
	final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
	
	Thread producer = new Thread("PRODUCER"){
	
		public void run() 
		{
			Integer coin;
			
			while (producerFlag)
			try
			{	
				coin = new Integer(coins[rm.nextRandomIntegerInRange()]);
				queue.put(coin);
				System.out.println("Coin dropped: " + coin);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	};
	
	Thread consumer = new Thread("CONSUMER"){
		public void run ()
		{
			Integer coin;
			
			while (producerFlag)
			try 
			{
				coin = queue.take();
				System.out.println("Coin received: " + coin);
				C = chooseCoin(coin);
				total = C.add(total);
				System.out.println(total);
			} catch (InterruptedException e)  
			{
				e.printStackTrace();
			}
		}
	};

}
