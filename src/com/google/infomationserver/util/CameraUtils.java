/**
 * IS
 * com.google.infomationserver.util
 * CameraUtils.java
 * 
 * 2012-11-15-上午09:59:31
 *  2012 © CVRe U - Copyright Reserved
 * 
 */
package com.google.infomationserver.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.format.DateFormat;

/**
 * 
 * CameraUtils
 * 
 * CVRe U
 * CVRe U
 * 2012-11-15 上午09:59:31
 * 
 * @version 1.0.0
 * 
 */
public class CameraUtils implements Runnable{
	private Context context;
	private File picture;
	private static Camera camera;
	public CameraUtils(Context context){
		this.context = context;
	}

	public static String takePicture(){
		String imagePath = "";
		Camera.open();
		Camera.PictureCallback pictureCallback = new Camera.PictureCallback() {  
	        @Override  
	        public void onPictureTaken(byte[] data, Camera camera) {
//	        	SavePictureTask task = new SavePictureTask();
//	        	task.execute(data);
	        }  
	    };
		camera.takePicture(null, null, pictureCallback);
		
		return imagePath;
	}
	
	 // save pic  
    class SavePictureTask extends AsyncTask<byte[], String, String> {  
    	public SavePictureTask(){}
        @Override  
        protected String doInBackground(byte[]... params) {  
            String fname = DateFormat.format("yyyyMMddhhmmss", new Date()).toString()+".jpg";  
              
            System.out.println( "fname="+fname+";dir="+Environment.getExternalStorageDirectory());  
            //picture = new File(Environment.getExternalStorageDirectory(),fname);// create file  
              
            picture = new File(Environment.getExternalStorageDirectory()+"/"+fname);  
              
            try {  
                FileOutputStream fos = new FileOutputStream(picture.getPath()); // Get file output stream  
                fos.write(params[0]); // Written to the file  
                fos.close();   
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
            return null;  
        }  
    }  
	
	public static String takeVideo(){
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		takePicture();
	}
}
