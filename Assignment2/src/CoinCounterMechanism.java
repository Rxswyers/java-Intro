import java.util.concurrent.SynchronousQueue;

public class CoinCounterMechanism
{
	int coins[] = {1, 5 ,10, 25, 50, 100}; 
	RandomInteger rm = new RandomInteger(0,5);
	int coinCount[] = {0,0,0,0,0,0};
	boolean consumerFlag = false;
	boolean producerFlag = false;
	
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
	Coin chooseCoin(Integer I)
	{
		switch(I)
		{ 
			case 1:
				return new Penny();
			case 5:
				return new Nickel();
			case 10:
				return new Dime();
			case 25:
				return new Quarter();
			case 50:
				return new HalfDollar();
			case 100:
				return new Dollar();
			
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
			} catch (InterruptedException e)  
			{
				e.printStackTrace();
			}
		}
	};

}
