/**
 * IS
 * com.google.infomationserver.listenner
 * LocationListenner.java
 * 
 * 2012-11-20-下午02:26:10
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.listenner;

import java.util.List;

import com.google.infomationserver.MainActivity;
import com.google.infomationserver.util.LocationUtil;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * 
 * LocationListenner
 * 
 * CVRe U
 * CVRe U
 * 2012-11-20 下午02:26:10
 * 
 * @version 1.0.0
 * 
 */
public class LocationListenner{
	private LocationManager locationManager;
	private final static int SECOND = 1000;
	
	//test---------start
	private MainActivity.MyHandler uiHandler;
	public LocationListenner(Context context,MainActivity.MyHandler uiHandler){
		this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		this.uiHandler = uiHandler;
		doProgressTest();
	}
	private void doProgressTest() {
		Criteria criteria = new Criteria();
		//显示精度
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		//获取海拔高度
		criteria.setAltitudeRequired(true);
		//获得方向数据
		criteria.setBearingRequired(true);
		//是否允许运营商计费
		criteria.setCostAllowed(true);
		//设置耗电程度
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		//获得速度
		criteria.setSpeedRequired(true);
		
		String provider = locationManager.getBestProvider(criteria, true);
//		//获取上一个定位点
//		Location location = locationManager.getLastKnownLocation(provider);
		Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location == null) {
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
		LocationUtil.addLocation(location);
		 
		LocationListener locationListener = new LocationListener() {
			/* (non-Javadoc)
			 * @see android.location.LocationListener#onLocationChanged(android.location.Location)
			 */
			@Override
			public void onLocationChanged(Location location) {
				LocationUtil.addLocation(location);
				uiHandler.sendEmptyMessage(MainActivity.REFRESH);
			}

			/* (non-Javadoc)
			 * @see android.location.LocationListener#onStatusChanged(java.lang.String, int, android.os.Bundle)
			 */
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub

			}

			/* (non-Javadoc)
			 * @see android.location.LocationListener#onProviderEnabled(java.lang.String)
			 */
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub

			}

			/* (non-Javadoc)
			 * @see android.location.LocationListener#onProviderDisabled(java.lang.String)
			 */
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub

			}
		};
		
		locationManager.requestLocationUpdates(provider, 1*SECOND, 0, locationListener);
	}

	//test---------end
	
	public LocationListenner(Context context){
		this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		doProgress();
	}

	/**
	 * init(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选) 
	 *void
	 * @exception 
	 * @since  1.0.0
	*/
	private void doProgress() {
		Criteria criteria = new Criteria();
		//显示精度
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		//获取海拔高度
		criteria.setAltitudeRequired(true);
		//获得方向数据
		criteria.setBearingRequired(true);
		//是否允许运营商计费
		criteria.setCostAllowed(true);
		//设置耗电程度
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		//获得速度
		criteria.setSpeedRequired(true);
		
		String provider = locationManager.getBestProvider(criteria, true);
//		List <String> allProvider = locationManager.getAllProviders();
//		//获取上一个定位点
//		Location location = locationManager.getLastKnownLocation(provider);
		Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location == null) {
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
		LocationUtil.addLocation(location);
		 
		LocationListener locationListener = new LocationListener() {
			/* (non-Javadoc)
			 * @see android.location.LocationListener#onLocationChanged(android.location.Location)
			 */
			@Override
			public void onLocationChanged(Location location) {
				LocationUtil.addLocation(location);
			}

			/* (non-Javadoc)
			 * @see android.location.LocationListener#onStatusChanged(java.lang.String, int, android.os.Bundle)
			 */
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub

			}

			/* (non-Javadoc)
			 * @see android.location.LocationListener#onProviderEnabled(java.lang.String)
			 */
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub

			}

			/* (non-Javadoc)
			 * @see android.location.LocationListener#onProviderDisabled(java.lang.String)
			 */
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub

			}
		};
//		
//		for (String provideX : allProvider){
//			System.out.println(provideX);
//			locationManager.requestLocationUpdates(provideX, 60*SECOND, 0, locationListener);
//		}
		locationManager.requestLocationUpdates(provider, 600*SECOND, 0, locationListener);
	}

}
