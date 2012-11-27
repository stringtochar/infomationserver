/**
 * IS
 * com.google.infomationserver
 * InfomationServerService.java
 * 
 * 2012-11-12-下午06:45:54
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

/**
 * 
 * InfomationServerService
 * 
 * CVRe U CVRe U 2012-11-12 下午06:45:54
 * 
 * @version 1.0.0
 * 
 */
public class InfomationServerService extends IntentService {

	private NotificationManager notificationManager;
	private Notification notification;
	private ServerSocket ss;

	/**
	 * Create a new instance InfomationServerService.
	 * 
	 * @param name
	 */
	public InfomationServerService() {
		super("ISService");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.IntentService#onHandleIntent(android.content.Intent)
	 */
	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.IntentService#onCreate()
	 */
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("service onCreate!");
		notificationManager = (NotificationManager) this
				.getSystemService(NOTIFICATION_SERVICE);
		notification = new Notification(R.drawable.ic_launcher, "信息",
				System.currentTimeMillis());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.IntentService#onStart(android.content.Intent, int)
	 */
	@Override
	public void onStart(final Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		System.out.println("service onStart!");
		PendingIntent pendingIntent = PendingIntent.getService(
				InfomationServerService.this, 0, intent, 0);
		notification.setLatestEventInfo(InfomationServerService.this,
				"IS服务已启动", "InfomationServerService Started!", pendingIntent);
		notificationManager.notify(1, notification);
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Socket socket;
					socket = new Socket("10.39.12.75", 10000);
					System.out.println("connectting");
					BufferedReader in;
					PrintWriter out;
					in = new BufferedReader(new InputStreamReader(socket
							.getInputStream()));
					out = new PrintWriter(socket.getOutputStream(), true);
					System.out.println("connectted");
					BufferedReader line = new BufferedReader(
							new InputStreamReader(null, new String("asfsafa")));
					out.println(line.readLine());
					out.flush();
					in.close();
					out.close();
					socket.close();
					PendingIntent pendingIntent = PendingIntent.getService(
							InfomationServerService.this, 0, intent, 0);
					notification.setLatestEventInfo(
							InfomationServerService.this, "IS已完成通讯",
							"finished!", pendingIntent);
					notificationManager.notify(2, notification);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.IntentService#onDestroy()
	 */
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("service onDestroy!");
	}
}
