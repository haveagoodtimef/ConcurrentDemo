package oneHundred2;

/**
 * ����������
 * �������Ҫ����(B+C)*B/2.���޷��ֿ������.��������������.
 * ���ǿ���ͨ����ˮ��˼��,����ִ���.
 * ��:
 * p1 : A = B+C;
 * p2 : D = A*B;
 * p3 : D = D/2;
 * �������߳�������ͬ�Ĳ��輴��.
 * @author feng-hong-zhang
 *
 * 2017��9��16��
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
