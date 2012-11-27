/**
 * IS
 * com.google.infomationserver.listenner
 * NetworkListenner.java
 * 
 * 2012-11-13-上午09:43:09
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.listenner;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;

/**
 * 
 * NetworkListenner
 * 
 * CVRe U CVRe U 2012-11-13 上午09:43:09
 * 
 * @version 1.0.0
 * 
 */
public class NetworkListenner extends PhoneStateListener {
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.telephony.PhoneStateListener#onCallStateChanged(int,
	 * java.lang.String)
	 */
	@Override
	public void onCallStateChanged(int state, String incomingNumber) {
		// TODO Auto-generated method stub
		super.onCallStateChanged(state, incomingNumber);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.telephony.PhoneStateListener#onCellLocationChanged(android.telephony
	 * .CellLocation)
	 */
	@Override
	public void onCellLocationChanged(CellLocation location) {
		// TODO Auto-generated method stub
		super.onCellLocationChanged(location);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.telephony.PhoneStateListener#onDataConnectionStateChanged(int)
	 */
	@Override
	public void onDataConnectionStateChanged(int state) {
		// TODO Auto-generated method stub
		super.onDataConnectionStateChanged(state);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.telephony.PhoneStateListener#onDataConnectionStateChanged(int,
	 * int)
	 */
	@Override
	public void onDataConnectionStateChanged(int state, int networkType) {
		// TODO Auto-generated method stub
		super.onDataConnectionStateChanged(state, networkType);
	}

}
