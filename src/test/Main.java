package test;

import method.Spider;

public class Main {
	public static void main(String[] args) throws Exception {
		String url = "http://www.pcauto.com.cn/drivers/817/8177723.html";
		Spider.getTopUserInfo(url);
	}
}
