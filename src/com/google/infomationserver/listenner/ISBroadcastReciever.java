/**
 * IS
 * com.google.infomationserver.listenner
 * ISBroadcastReciever.java
 * 
 * 2012-11-12-下午06:07:27
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.listenner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 
 * ISBroadcastReciever
 * 
 * CVRe U CVRe U 2012-11-12 下午06:07:27
 * 
 * @version 1.0.0
 * 
 */
public class ISBroadcastReciever extends BroadcastReceiver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context,
	 * android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		Intent intentToStartService = new Intent();
		intentToStartService.setAction("com.google.infomationserver.InfomationServerService");
		context.startService(intentToStartService);
	}

	
}
