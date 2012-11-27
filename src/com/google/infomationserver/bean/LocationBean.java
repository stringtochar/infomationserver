/**
 * IS
 * com.google.infomationserver.bean
 * LocationBean.java
 * 
 * 2012-11-20-下午03:09:52
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * LocationBean
 * 
 * CVRe U 
 * CVRe U 
 * 2012-11-20 下午03:09:52
 * 
 * @version 1.0.0
 * 
 */
public class LocationBean {
	//时间
	private String time;
	//经度
	private String longitude;
	//纬度
	private String latitude;
	//GeoPoint
	private String geoLongitude;
	private String geoLatitude;
	private int id;
	//速度
	private float speed;
	private float bearing;
	//海拔
	private Double altitude;

	public String getTime() {
		return time;
	}

	public void setTime(long time) {
		Date date = new Date(time);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");;

		this.time = format.format(date);
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longtitude) {
		this.geoLongitude = String.valueOf((int)(longtitude* 1e6));
		this.longitude = String.valueOf(longtitude);
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.geoLatitude = String.valueOf((int)(latitude* 1e6));
		this.latitude = String.valueOf(latitude);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "<<<<<<"+id+">>>>>> \n Time:"+time+" \n Latitude:"+latitude+"\n Longitude:"+longitude+"\n Altitude:"+altitude+"\n Speed:"+speed+"\n Bearing:"+bearing+"\n GeoLatitude:"+geoLatitude+"\n GeoLongitude:"+geoLongitude+"\n";
	}

	/**
	 * setId(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param id 
	 *void
	 * @exception 
	 * @since  1.0.0
	*/
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getId(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选) 
	 *void
	 * @exception 
	 * @since  1.0.0
	*/
	public int getId() {
		return id;
	}

	public String getSpeed() {
		return String.valueOf(speed);
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public String getBearing() {
		return String.valueOf(bearing);
	}

	public void setBearing(float bearing) {
		this.bearing = bearing;
	}

	public String getAltitude() {
		return String.valueOf(altitude);
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}
	
}
