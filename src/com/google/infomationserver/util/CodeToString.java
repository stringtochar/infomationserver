/**
 * IS
 * com.google.infomationserver.util
 * CodeToString.java
 * 
 * 2012-11-14-下午03:31:59
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.util;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * CodeToString
 * 
 * CVRe U CVRe U 2012-11-14 下午03:31:59
 * 
 * @version 1.0.0
 * 
 */
@SuppressLint({ "UseSparseArrays"})
public class CodeToString {
	private static final Map<Integer,String> PHONE_TYPE_MAP = new HashMap<Integer,String>();
	private static final Map<Integer,String> NETWORK_TYPE_MAP = new HashMap<Integer,String>();
	private static final Map<Integer,String> SYSTEM_VERSION_MAP = new HashMap<Integer,String>();
	
	static{
		PHONE_TYPE_MAP.put(0, "NONE");
		PHONE_TYPE_MAP.put(1, "GSM");
		PHONE_TYPE_MAP.put(2, "CDMA");
		PHONE_TYPE_MAP.put(3, "SIP");
		
		NETWORK_TYPE_MAP.put(0, "unknown");
		NETWORK_TYPE_MAP.put(1, "GPRS");
		NETWORK_TYPE_MAP.put(2, "EDGE");
		NETWORK_TYPE_MAP.put(3, "UMTS");
		NETWORK_TYPE_MAP.put(4, "CDMA");
		NETWORK_TYPE_MAP.put(5, "EVDO-0");
		NETWORK_TYPE_MAP.put(6, "EVDO-A");
		NETWORK_TYPE_MAP.put(7, "1xRTT");
		NETWORK_TYPE_MAP.put(8, "HSDPA");
		NETWORK_TYPE_MAP.put(9, "HSUPA");
		NETWORK_TYPE_MAP.put(10, "HSPA");
		NETWORK_TYPE_MAP.put(11, "iDen");
		NETWORK_TYPE_MAP.put(12, "EVDO-B");
		NETWORK_TYPE_MAP.put(13, "LTE");
		NETWORK_TYPE_MAP.put(14, "eHRPD");
		NETWORK_TYPE_MAP.put(15, "HSPA+");
		
		SYSTEM_VERSION_MAP.put(3, "Android 1.5");
		SYSTEM_VERSION_MAP.put(4, "Android 1.6");
		SYSTEM_VERSION_MAP.put(7, "Android 2.1");
		SYSTEM_VERSION_MAP.put(8, "Android 2.2");
		SYSTEM_VERSION_MAP.put(10, "Android 2.3.3");
		SYSTEM_VERSION_MAP.put(11, "Android 3.0");
		SYSTEM_VERSION_MAP.put(12, "Android 3.1");
		SYSTEM_VERSION_MAP.put(13, "Android 3.2");
		SYSTEM_VERSION_MAP.put(14, "Android 4.0");
		SYSTEM_VERSION_MAP.put(15, "Android 4.0.3");
		SYSTEM_VERSION_MAP.put(16, "Android 4.1");
	}
	
	public static String getStringFromCodeAtPhoneType(int id) {
		return PHONE_TYPE_MAP.get(id);
	}
	
	public static String getStringFromCodeAtNetWorkType(int id) {
		return NETWORK_TYPE_MAP.get(id);
	}
	
	public static String getStringFromCodeAtSystemVersion(int id){
		return SYSTEM_VERSION_MAP.get(id);
	}

}
