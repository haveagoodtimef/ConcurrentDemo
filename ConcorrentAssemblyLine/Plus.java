package oneHundred2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 计算加法	
 * @author feng-hong-zhang
 *
 * 2017年9月16日
 */
public class Plus implements Runnable{
	//消息队列
	public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();
	@Override
	public void run() {
		while(true) {
			try {
				Msg msg = bq.take(); //如果没有数据会阻塞
				msg.j = msg.i + msg.j;
				Multiply.bq.add(msg);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
