package oneHundred2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 计算除法
 * @author feng-hong-zhang
 *
 * 2017年9月16日
 */
public class Div implements Runnable{
	public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();
	
	@Override
	public void run() {
		while(true) {
			try {
				Msg msg = bq.take();
				msg.i = msg.i / 2;
				System.out.println(msg.orgStr + "=" + msg.i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
