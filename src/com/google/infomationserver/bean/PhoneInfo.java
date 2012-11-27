/**
 * IS
 * com.google.infomationserver.bean
 * PhoneInfo.java
 * 
 * 2012-11-14-下午02:20:57
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.bean;

import com.google.infomationserver.util.CodeToString;
import com.google.infomationserver.util.PhoneUtils;

import android.content.Context;

/**
 * 
 * PhoneInfo
 * 
 * CVRe U CVRe U 2012-11-14 下午02:20:57
 * 
 * @version 1.0.0
 * 
 */
public class PhoneInfo {
	public String mIMEI;
	public int mPhoneType;
	public int mSysVersion;
	public String mNetWorkCountryIso;
	public String mNetWorkOperator;
	public String mNetWorkOperatorName;
	public int mNetWorkType;
	public boolean mIsOnLine;
	public String mConnectTypeName;
	public long mTotalMem;
	public String mCupInfo;
	public String mProductName;
	public String mModelName;
	public String mManufacturerName;
	public String mPhoneNumber;
	public String mIMSI;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IMEI : " + mIMEI + "\n");
		builder.append("IMSI : " + mIMSI + "\n");
		builder.append("PhoneType : " + CodeToString.getStringFromCodeAtPhoneType(mPhoneType) + "\n");
		builder.append("PhoneNumber : " + mPhoneNumber + "\n");
		builder.append("SysVersion : " + CodeToString.getStringFromCodeAtSystemVersion(mSysVersion) + "\n");
		builder.append("NetWorkCountryIso : " + mNetWorkCountryIso + "\n");
		builder.append("NetWorkOperator : " + mNetWorkOperator + "\n");
		builder.append("NetWorkOperatorName : " + mNetWorkOperatorName + "\n");
		builder.append("NetWorkType : " + CodeToString.getStringFromCodeAtNetWorkType(mNetWorkType) + "\n");
		builder.append("IsOnLine : " + mIsOnLine + "\n");
		builder.append("ConnectTypeName : " + mConnectTypeName + "\n");
		builder.append("TotalMem : " + mTotalMem + "M\n");
		builder.append("CupInfo : " + mCupInfo + "\n");
		builder.append("ProductName : " + mProductName + "\n");
		builder.append("ModelName : " + mModelName + "\n");
		builder.append("ManufacturerName : " + mManufacturerName + "\n");
		
		return builder.toString();
	}

	public static PhoneInfo getPhoneInfo(Context context) {
		PhoneInfo result = new PhoneInfo();
		result.mIMEI = PhoneUtils.getIMEI(context);
		result.mPhoneType = PhoneUtils.getPhoneType(context);
		result.mSysVersion = PhoneUtils.getSysVersion();
		result.mNetWorkCountryIso = PhoneUtils.getNetWorkCountryIso(context);
		result.mNetWorkOperator = PhoneUtils.getNetWorkOperator(context);
		result.mNetWorkOperatorName = PhoneUtils
				.getNetWorkOperatorName(context);
		result.mNetWorkType = PhoneUtils.getNetworkType(context);
		result.mIsOnLine = PhoneUtils.isOnline(context);
		result.mConnectTypeName = PhoneUtils.getConnectTypeName(context);
		result.mTotalMem = PhoneUtils.getTotalMem(context);
		result.mCupInfo = PhoneUtils.getCpuInfo();
		result.mProductName = PhoneUtils.getProductName();
		result.mModelName = PhoneUtils.getModelName();
		result.mManufacturerName = PhoneUtils.getManufacturerName();
		result.mPhoneNumber = PhoneUtils.getPhoneNumber(context);
		result.mIMSI = PhoneUtils.getIMSI(context);
		
		return result;
	}

}
