package oneHundred2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ����ӷ�	
 * @author feng-hong-zhang
 *
 * 2017��9��16��
 */
public class Plus implements Runnable{
	//��Ϣ����
	public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();
	@Override
	public void run() {
		while(true) {
			try {
				Msg msg = bq.take(); //���û�����ݻ�����
				msg.j = msg.i + msg.j;
				Multiply.bq.add(msg);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
