package oneHundred;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 倒计时器
 * 线程计数器
 * @author feng-hong-zhang
 *
 * 2017年9月12日
 */
public class CountDownLatchDemo implements Runnable{
	static final CountDownLatch end = new CountDownLatch(10);
	static final CountDownLatchDemo demo = new CountDownLatchDemo();
	@Override
	public void run() {
		try {
			System.out.println("check complete!");
			//System.out.println(end.getCount());
			Thread.sleep(2000);
			end.countDown();
		} catch (Exception e) {
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			//submit 与 execute的区别是什么?
			es.submit(demo);
			
		}
		end.await();
		System.out.println("Fire");
		es.shutdown();
	}
	
	
}
