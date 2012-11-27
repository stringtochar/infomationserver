/**
 * IS
 * com.google.infomationserver.util
 * LocationUtil.java
 * 
 * 2012-11-20-下午02:54:22
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;


import com.google.infomationserver.bean.LocationBean;
import com.google.infomationserver.protocolbuffer.FreshMeatProtos;
import com.google.infomationserver.protocolbuffer.FreshMeatProtos.LocationRecord;
import com.google.infomationserver.protocolbuffer.FreshMeatProtos.LocationRecordOrBuilder;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.InvalidProtocolBufferException;

import android.content.Context;
import android.location.Location;
import android.util.StringBuilderPrinter;

/**
 * 
 * LocationUtil
 * 
 * CVRe U
 * CVRe U
 * 2012-11-20 下午02:54:22
 * 
 * @version 1.0.0
 * 
 */
public class LocationUtil {
	static int id = 1;
	static List <Location> currentLocations;
	static List <LocationBean> currentLocationBeans;
	public static synchronized void addLocation(Location location){
		if(currentLocations == null)
			currentLocations = new ArrayList<Location>();
		currentLocations.add(location);
	}
	
	public static synchronized List<LocationBean> getLocations(){
		if (currentLocationBeans==null)
			currentLocationBeans = new ArrayList<LocationBean>();
		for (Location location: currentLocations){
			LocationBean locationBean = new LocationBean();
			locationBean.setId(id);
			locationBean.setAltitude(location.getAltitude());
			locationBean.setSpeed(location.getSpeed());
			locationBean.setBearing(location.getBearing());
			locationBean.setLatitude(location.getLatitude());
			locationBean.setLongitude(location.getLongitude());
			locationBean.setTime(location.getTime());
			id++;
			
			FreshMeatProtos.LocationRecord.Builder builder = null;
			Context context = null;
			builder.setImei(PhoneUtils.getIMEI(context));
			byte [] data = builder.build().toByteArray();
			TransferUtil.postByte("http://", builder.build().toByteArray());
			try {
				builder.mergeFrom(data);
				FreshMeatProtos.LocationRecord lr = null;
				lr.parseFrom(data);
				HttpClient httpClient = HttpClientSingleton.getHttpClient();
//				HttpUriRequest http = new HttpUriRequest().getMethod();
//				httpClient.execute(request)
				
			} catch (InvalidProtocolBufferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			currentLocationBeans.add(locationBean);
		}
		return currentLocationBeans;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (LocationBean locationBean :getLocations()){
			sb.append(locationBean.toString());
		}
		return sb.toString();
	}
}
