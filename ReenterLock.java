package oneHundred;

import java.util.concurrent.locks.ReentrantLock;
/**
 * ������
 * @author feng-hong-zhang
 *
 * 2017��9��12��
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
		//��join����ô����?
		t1.join();
		t2.join();
		System.out.println(i);
	}
	
}
