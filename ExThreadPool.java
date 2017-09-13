package oneHundred;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ���̳߳ص���չ
 * @author feng-hong-zhang
 *
 * 2017��9��13��
 */
public class ExThreadPool {
	public static class MyTask implements Runnable {

		public  String name ;
		
		public MyTask(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println("����ִ���߳�id"+Thread.currentThread().getId()+"name:"+name);
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
	 * �����������ֱ��¼һ������Ŀ�ʼ,�����������̳߳ص��˳�.
	 * shutdown����ִ�к�,�����̳߳ز������µ�����,������������ɺ�,�ر��̳߳�.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es =
				new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()) {
				
					@Override
					protected void beforeExecute(Thread t, Runnable r) {
						System.out.println("׼��ִ��:"+  ((MyTask) r).name);
					
					}

					@Override
					protected void afterExecute(Runnable r, Throwable t) {
						System.out.println("ִ�����:"+((MyTask)r ).name);
					}

					//�ս�
					@Override
					protected void terminated() {
						System.out.println("�̳߳��˳�");
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
