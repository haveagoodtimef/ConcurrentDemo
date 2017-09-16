package oneHundred2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * �������
 * @author feng-hong-zhang
 *
 * 2017��9��16��
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
