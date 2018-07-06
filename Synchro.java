public class Synchro{
	public static void main(String[] args){
		//create and start() two threads which
		//should print 10000, each trhead printing
		//5000 times
		
		
		Count c = new Count();
		Runnable job = new TestRunnable(c);
		
		Thread t1 = new Thread(job);
		Thread t2 = new Thread(job);
		
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException ex){
			ex.getMessage();
		}
		
		System.out.println("Count = " + c.count);
	}
}

class Count{
	int count;
	
	public synchronized void Increment(){
		count++;
	}
}

class TestRunnable implements Runnable{
	Count c;
	
	public TestRunnable(Count c){
		this.c = c;
	}
	
	public void run(){
		for(int i = 0; i < 5000; i++){
			c.Increment();
			
		}
	}
	
}