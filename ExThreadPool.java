package oneHundred;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 对线程池的扩展
 * @author feng-hong-zhang
 *
 * 2017年9月13日
 */
public class ExThreadPool {
	public static class MyTask implements Runnable {

		public  String name ;
		
		public MyTask(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println("正在执行线程id"+Thread.currentThread().getId()+"name:"+name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * beforeExecute
	 * afterExecute
	 * terminated
	 * 这三个方法分别记录一个任务的开始,结束和整个线程池的退出.
	 * shutdown方法执行后,带来线程池不接受新的任务,等所有任务完成后,关闭线程池.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es =
				new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()) {
				
					@Override
					protected void beforeExecute(Thread t, Runnable r) {
						System.out.println("准备执行:"+  ((MyTask) r).name);
					
					}

					@Override
					protected void afterExecute(Runnable r, Throwable t) {
						System.out.println("执行完毕:"+((MyTask)r ).name);
					}

					//终结
					@Override
					protected void terminated() {
						System.out.println("线程池退出");
					}
		};
		
		for (int i = 0; i < 5; i++) {
			MyTask mt = new MyTask("Task"+i);
			es.execute(mt);
			Thread.sleep(1000);
		}
		
		es.shutdown();
	}
	
}
