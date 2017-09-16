package oneHundred2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 主函数
 * @author feng-hong-zhang
 *
 * 2017年9月16日
 */
public class FutureMain {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//FutureTask除了实现了Future接口外还实现了Runnable接口，因此FutureTask也可以直接提交给Executor执行。
		FutureTask<String> future = new FutureTask<>(new RealData("a"));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		//执行RealData的call方法
		executor.submit(future);
		System.out.println("请求完毕!");
		
		try {
			System.out.println("处理其他业务!");
			Thread.sleep(5000); //其他具体业务.可修改时间看效果.
			System.out.println("处理其他业务完毕!");
		} catch (Exception e) {
		}
		
		//取得call方法的返回值.如果call方法没有执行后,会阻塞.
		System.out.println(future.get());
		System.out.println("执行完毕 !");
		
	}
}
