/**
 * IS
 * com.google.infomationserver.task
 * TaskManager.java
 * 
 * 2012-11-12-下午06:10:54
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.task;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 
 * TaskManager
 * 
 * CVRe U CVRe U 2012-11-12 下午06:10:54
 * 
 * @version 1.0.0
 * 
 */
public class TaskManager {
	private static final String TAG = "DownloadTaskManager";
	// UI请求队列
	private LinkedList<Task> tasks;
	// 任务不能重复
	private Set<String> taskIdSet;

	private static TaskManager taskMananger;

	private TaskManager() {

		tasks = new LinkedList<Task>();
		taskIdSet = new HashSet<String>();

	}

	/**
	 * getInstance(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @return TaskManager
	 * @exception
	 * @since 1.0.0
	 */
	public static synchronized TaskManager getInstance() {
		if (taskMananger == null) {
			taskMananger = new TaskManager();
		}
		return taskMananger;
	}

	// 1.先执行
	public void addTask(Task task) {
		synchronized (tasks) {
			if (!isTaskRepeat(task.getFileId())) {
				// 增加下载任务
				tasks.addLast(task);
			}
		}

	}

	public boolean isTaskRepeat(String fileId) {
		synchronized (taskIdSet) {
			if (taskIdSet.contains(fileId)) {
				return true;
			} else {
				System.out.println("下载管理器增加下载任务：" + fileId);
				taskIdSet.add(fileId);
				return false;
			}
		}
	}

	/**
	 * getTask(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @return Task
	 * @exception
	 * @since 1.0.0
	 */
	public Task getTask() {
		synchronized (tasks) {
			if (tasks.size() > 0) {
				System.out.println("下载管理器增加下载任务：" + "取出任务");
				Task downloadTask = tasks.removeFirst();
				return downloadTask;
			}
		}
		return null;
	}
}
