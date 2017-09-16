package oneHundred2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * ������
 * @author feng-hong-zhang
 *
 * 2017��9��16��
 */
public class FutureMain {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//FutureTask����ʵ����Future�ӿ��⻹ʵ����Runnable�ӿڣ����FutureTaskҲ����ֱ���ύ��Executorִ�С�
		FutureTask<String> future = new FutureTask<>(new RealData("a"));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		//ִ��RealData��call����
		executor.submit(future);
		System.out.println("�������!");
		
		try {
			System.out.println("��������ҵ��!");
			Thread.sleep(5000); //��������ҵ��.���޸�ʱ�俴Ч��.
			System.out.println("��������ҵ�����!");
		} catch (Exception e) {
		}
		
		//ȡ��call�����ķ���ֵ.���call����û��ִ�к�,������.
		System.out.println(future.get());
		System.out.println("ִ����� !");
		
	}
}
