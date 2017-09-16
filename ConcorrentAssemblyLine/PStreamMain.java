package oneHundred2;

/**
 * 并行流行线
 * 如果我们要计算(B+C)*B/2.是无法分开计算的.这是数据依赖性.
 * 但是可以通过流水线思想,来拆分处理.
 * 如:
 * p1 : A = B+C;
 * p2 : D = A*B;
 * p3 : D = D/2;
 * 分三个线程来处理不同的步骤即可.
 * @author feng-hong-zhang
 *
 * 2017年9月16日
 */
public class PStreamMain {
	public static void main(String[] args) {
		new Thread(new Plus()).start();
		new Thread(new Multiply()).start();
		new Thread(new Div()).start();
		
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				Msg msg = new Msg();
				msg.i = i;
				msg.j = j;
				msg.orgStr = "(("+i+"+"+j+")*"+i+"/2)";
				Plus.bq.add(msg);
			}
		}
		
	}
}
