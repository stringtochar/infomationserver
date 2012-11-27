/**
 * IS
 * com.google.infomationserver.bean
 * SMSMessage.java
 * 
 * 2012-11-14-下午04:51:42
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.bean;

import java.util.Date;

/**
 * 
 * SMSMessage
 * 
 * CVRe U
 * CVRe U
 * 2012-11-14 下午04:51:42
 * 短信
 * @version 1.0.0
 * 
 */
public class SMSMessage {
	/**
	 * 电话imei
	 */
	private String phone_imei;
	/**
	 * 源地址
	 */
	private String from;
	/**
	 * 目的地址
	 */
	private String to;
	/**
	 * 短信内容
	 */
	private String message_content;
	/**
	 * 发生时间
	 */
	private String message_time;

	public String getPhone_imei() {
		return phone_imei;
	}

	public void setPhone_imei(String phone_imei) {
		this.phone_imei = phone_imei;
	}

	public String getMessage_content() {
		return message_content;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

	public String getMessage_time() {
		return message_time;
	}

	public void setMessage_time(String message_time) {
		this.message_time = message_time;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
}
