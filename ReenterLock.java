package oneHundred;

import java.util.concurrent.locks.ReentrantLock;
/**
 * 重入锁
 * @author feng-hong-zhang
 *
 * 2017年9月12日
 */
public class ReenterLock implements Runnable{

	public static ReentrantLock r = new ReentrantLock();
	public static int i = 0;
	
	@Override
	public void run() {
		for (int j = 0; j < 1000000; j++) {
			r.lock();
			try {
				//System.out.println(Thread.currentThread().getName());
				i++;
				
			} finally {
				r.unlock();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReenterLock r = new ReenterLock();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		//不join会怎么样呢?
		t1.join();
		t2.join();
		System.out.println(i);
	}
	
}
