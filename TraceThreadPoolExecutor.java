package oneHundred;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自己实现一个线程池.
 * 弹出错误提示.
 * @author feng-hong-zhang
 *
 * 2017年9月13日
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor{

	public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	public void execute(Runnable command) {
		
		super.execute(wrap(command,clientTask(),Thread.currentThread().getName()));
	}

	private Exception clientTask() {
		return new Exception("Clinet stack trace!");
	}
	
	private Runnable wrap(final Runnable task,final Exception clientTask,String threadName) {
		return new Runnable() {

			@Override
			public void run() {
				try {
					task.run();
				} catch (Exception e) {
					clientTask.printStackTrace();
					throw e;
				}
			}
			
		};
	}
}
