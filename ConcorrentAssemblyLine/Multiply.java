package oneHundred2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ����˷�
 * @author feng-hong-zhang
 *
 * 2017��9��16��
 */
public class Multiply implements Runnable {
	public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();
	
	@Override
	public void run() {
		while(true) {
			try {
				Msg msg = bq.take();
				msg.i = msg.i * msg.j;
				Div.bq.add(msg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
