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
	void getCounts(int[] cs)
	{
		for(int i = 0; i < 6; i ++)
		{
			cs[i] = coinCount[i];
		}
	}
	double getTotal()
	{
		return total;
	}
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
