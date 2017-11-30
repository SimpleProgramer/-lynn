package com.lynn.net.commons.test;

import java.util.concurrent.LinkedTransferQueue;

public class Test {
	private static final long count = 1000000000l;
	private static void concurrency() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread  = new Thread(new Runnable() {
			@Override
			public void run() {
				int i  = 0;
				for (int j = 0; j < count; j++) {
					i+=5;
				}
			}
		});
		thread.start();
		int b = 0;
		for (int i = 0; i < count; i++) {
			b--;
		}
		thread.join();
		long time = System.currentTimeMillis() - start;
		System.err.println(count + "次执行时间--多线程并行:" + time + "ms,b:" + b);
	}

	private static void se() throws InterruptedException {
		long start = System.currentTimeMillis();
		int a  = 0;
		for (int j = 0; j < count; j++) {
			a+=5;
		}
		int b = 0;
		for (int i = 0; i < count; i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;
		System.err.println(count + "次执行时间--单线程串行:" + time + "ms,b:" + b);
	}
	
	public static void main(String[] args) throws InterruptedException {
		concurrency();
		se();
		//测试结果:10000 / 100000000 : 业务逻辑轻量时,并发环境开销比单线程环境大,因为增加了上下文切换时长;
	}
	
	
}
