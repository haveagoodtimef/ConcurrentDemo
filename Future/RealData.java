package oneHundred2;

import java.util.concurrent.Callable;

/**
 * ģ����ʵ����
 * @author feng-hong-zhang
 *
 * 2017��9��16��
 */
public class RealData implements Callable<String> {

	private String para;
	
	public RealData(String para) {
		this.para = para;
	}

	@Override
	public String call() throws Exception {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(para);
			Thread.sleep(100);
		}
		return sb.toString();
	}

}
