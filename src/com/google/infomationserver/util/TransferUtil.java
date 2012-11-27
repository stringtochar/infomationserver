/**
 * IS
 * com.google.infomationserver.util
 * TransferUtil.java
 * 
 * 2012-11-26-下午05:13:05
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * 
 * TransferUtil
 * 
 * CVRe U CVRe U 2012-11-26 下午05:13:05
 * 
 * @version 1.0.0
 * 
 */
public class TransferUtil {

	/**
	 * Create a new instance TransferUtil.
	 * 
	 */
	public TransferUtil() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("rawtypes")
	public boolean postMap(String remoteUrl, HashMap map){
		
		
		return true;
	}

	public static boolean postByte(String remoteUrl, byte[] param) {
		URL url = null;
		HttpURLConnection httpURLConnection = null;
		StringBuffer sb = new StringBuffer();
		try {
			// 建立链接
			url = new URL(remoteUrl);
			httpURLConnection = (HttpURLConnection) url.openConnection();

			// 设置连接属性
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			httpURLConnection.setUseCaches(false);

			// 设置请求属性
			httpURLConnection.setRequestProperty("Content-length", ""
					+ param.length);
			httpURLConnection.setRequestProperty("Content-Type",
					"application/octet-stream");

			// 建立输出流，并写入数据
			OutputStream outputStream = httpURLConnection.getOutputStream();
			outputStream.write(param);
			outputStream.close();

			InputStream in = httpURLConnection.getInputStream();
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = in.read(b)) != -1) {
				sb.append(new String(b, 0, i, "UTF-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (httpURLConnection != null)
				httpURLConnection.disconnect();

		}
		return true;
	}
	
}
