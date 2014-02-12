package com.assignment2;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity /*implements OnClickListener*/{

	NotificationManager NM;
	static final int uniqueID = 123;
	//Button startNewActivity;
	Button notify;
	Vibrator v;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		notify = (Button)findViewById(R.id.bNotification);
		v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);	
		NM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		NM.cancel(uniqueID); //Cancels/clears the notification after clicking on it.
		
		/**
		 * Another example of how to create multiple buttons.
		Button btnStartActivity = (Button)findViewById(R.id.bVibration);
		btnStartActivity.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		 */
	}

	/**@Override
	//@SuppressWarnings("deprecation")
	//public void onClick(View v) 
	//{
		Intent intent = new Intent(this, MainActivity.class);
		PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
		String body = "You have been warned!";
		String title = "Get Warned";
		
		Notification n = new Notification(R.drawable.ic_launcher, body, System.currentTimeMillis());
		n.setLatestEventInfo(this, title, body, pi);
		n.defaults = Notification.DEFAULT_ALL;
		NM.notify(uniqueID, n);	
		finish()
			
	}*/
	
	public void startNewActivity(View v)
	{
		//setContentView(R.layout.activity_start);
		Intent intent = new Intent(this, StartNewActivity.class);
		//startNewActivity = (Button)findViewById(R.id.bActivity);
		//startNewActivity.setOnClickListener(this);
		startActivity(intent);
	}

	@SuppressWarnings("deprecation")
	public void notification(View v)
	{
		Intent intent = new Intent(this, MainActivity.class);
		PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
		String body = "You have been warned!";
		String title = "Get Warned";
		
		Notification n = new Notification(R.drawable.ic_launcher, body, System.currentTimeMillis());
		n.setLatestEventInfo(this, title, body, pi);
		n.defaults = Notification.DEFAULT_ALL;
		NM.notify(uniqueID, n);	
		finish(); //Stops/exits the program after getting notified.
	}
	
	public void startFragment(View v)
	{
		Intent intent = new Intent(this, FragActivity.class);
		startActivity(intent);
	}
	
	public void vibration(View v)
	{
		this.v.vibrate(1000);
	}
	
	public void camera(View v)
	{
		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		startActivityForResult(intent, 0);
	}

}
