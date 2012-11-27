/**
 * IS
 * com.google.infomationserver.task
 * Task.java
 * 
 * 2012-11-12-下午06:08:48
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.task;

/**
 * 
 * Task
 * 
 * CVRe U
 * CVRe U
 * 2012-11-12 下午06:08:48
 * 
 * @version 1.0.0
 * 
 */
public class Task implements Runnable {

	public String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// String name=Thread.currentThread().getName();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " executed OK!");
	}

	public String getFileId() {
		return name;
	}
}
