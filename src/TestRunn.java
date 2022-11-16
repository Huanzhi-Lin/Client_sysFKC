import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
@Deprecated
public class TestRunn implements Runnable{
//	private int i = 0;
	private volatile AtomicInteger i = new AtomicInteger(0);
	Lock lock = new ReentrantLock();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (; i.get() < 100; /* i++ */) {
			lock.lock();
			if(i.get() % 2 == 0) {				
				if(i.get()<100) System.out.println(Thread.currentThread().getName() + i);
			}
			i.addAndGet(1);
			lock.unlock();
		}
	}
	
	public synchronized void t() {
		
	}
	
	
	public static void main(String[] args) {
		TestRunn c = new TestRunn();
		Thread a = new Thread(c);
		a.setName("线程A：");
		Thread b = new Thread(c);
		b.setName("线程二：");
		
		a.start();
		b.start();
	}
	
}



