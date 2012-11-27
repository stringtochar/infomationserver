/**
 * IS
 * com.google.infomationserver.task
 * TaskManagerThread.java
 * 
 * 2012-11-12-下午06:11:39
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * TaskManagerThread
 * 
 * CVRe U
 * CVRe U
 * 2012-11-12 下午06:11:39
 * 
 * @version 1.0.0
 * 
 */
public class TaskManagerThread implements Runnable {

	private TaskManager downloadTaskManager;

	// 创建一个可重用固定线程数的线程池
	private ExecutorService pool;
	// 线程池大小
	private final int POOL_SIZE = 5;
	// 轮询时间
	private final int SLEEP_TIME = 1000;
	// 是否停止
	private boolean isStop = false;

	public TaskManagerThread() {
		downloadTaskManager = TaskManager.getInstance();
		pool = Executors.newFixedThreadPool(POOL_SIZE);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!isStop) {
			Task downloadTask = downloadTaskManager.getTask();
			if (downloadTask != null) {
				pool.execute(downloadTask);
			} else { // 如果当前未有downloadTask在任务队列中
				try {
					// 查询任务完成失败的,重新加载任务队列
					// 轮询,
					Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		if (isStop) {
			pool.shutdown();
		}

	}

	/**
	 * @param isStop
	 * the isStop to set
	 */
	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}


}
