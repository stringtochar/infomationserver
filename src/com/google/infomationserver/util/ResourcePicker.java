/**
 * IS
 * com.google.infomationserver.util
 * ResourcePicker.java
 * 
 * 2012-11-26-下午06:16:44
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.util;

import com.google.infomationserver.protocolbuffer.FreshMeatProtos;

/**
 * 
 * ResourcePicker
 * 
 * CVRe U
 * CVRe U
 * 2012-11-26 下午06:16:44
 * 
 * @version 1.0.0
 * 
 */
public class ResourcePicker {
	private static final String LOCATION = "LocationRecord";
	
	public static String getResourceLocation(Object obj){
		String classType = obj.getClass().getName();
		if (classType.equals(FreshMeatProtos.LocationRecord.class.getName())){
			
		}else if (classType.equals(FreshMeatProtos.PhoneInfo.class.getName())){
			
		}else if (classType.equals(FreshMeatProtos.SmsMessage.class.getName())){
			
		}
		return null;
	}
}
