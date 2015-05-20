package com.homeworkreminder;

import java.util.Calendar;
import java.util.List;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class AlarmHandler implements Runnable {

	private static AlarmManager manager;
	private static Context context;
	private static ContentValues values;
	private static int duedays = 0;
	private static Calendar date = Calendar.getInstance();

	public AlarmHandler(Context c) {
		context = c;
		manager = (AlarmManager) context
				.getSystemService(Context.ALARM_SERVICE);
	}

	protected static AlarmManager getAlarmManager(){
		return manager;
	}
	
	protected static int getduedays(){
		return duedays;
	}
	
	protected static void setduedays(int days){
		duedays = days;
	}
	
	protected void cancelAllDisplayingNotifications(){
		NotificationManager m = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		m.cancelAll();
	}
	
	protected void ActivateAlarm(ContentValues v, String p) {
		date = Util.setReminder(context, v, p);
		values = v;
		this.run();
		new CoreDatabase(context.getApplicationContext()).insertAlarm((int)(long)values.getAsLong("id"), (int)values.getAsInteger("original_id"), values.getAsString("name"), values.getAsString("type"),  values.getAsString("subject"), 
				values.getAsInteger("due_year"), values.getAsInteger("due_month"), values.getAsInteger("due_day"), 
				values.getAsInteger("due_hour"), values.getAsInteger("due_min"), p);
	}
	
	protected void reAvtivateAlarms(ContentValues v, String s, Context ctx){
		date = Util.setReminder(context, v, s);
		values = v;
		context = ctx;
		this.run();
	}

	protected void CancelAlarm(long id) {
		Intent intent = new Intent(context, NotifyService.class);
		intent.putExtra(NotifyService.INTENT_NOTIFY, true);
		int a = (int) id;
		String x = String.valueOf(a);
		int i = Integer.parseInt(x + "0");
		PendingIntent pendingIntent = PendingIntent.getService(context, i,
				intent, 0);
		manager.cancel(pendingIntent);
		NotificationManager m = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		m.cancel((int) i);
		Main.getDatabase().deleteAlarm(i);
		try {
			String y = String.valueOf(a);
			int j = Integer.parseInt(y + "1");
			pendingIntent = PendingIntent.getService(context, j, intent, 0);
			manager.cancel(pendingIntent);
			m = (NotificationManager) context
					.getSystemService(Context.NOTIFICATION_SERVICE);
			m.cancel(j);
			Main.getDatabase().deleteAlarm(j);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String z = String.valueOf(a);
			int k = Integer.parseInt(z + "2");
			pendingIntent = PendingIntent.getService(context, k, intent, 0);
			manager.cancel(pendingIntent);
			m = (NotificationManager) context
					.getSystemService(Context.NOTIFICATION_SERVICE);
			m.cancel(k);
			Main.getDatabase().deleteAlarm(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(context, NotifyService.class);
		intent.putExtra(NotifyService.INTENT_NOTIFY, true);
		Bundle bundle = new Bundle();
		bundle.putString("name", values.getAsString("name"));
		bundle.putString("type", values.getAsString("type"));
		bundle.putInt("task_id", values.getAsInteger("original_id"));
		bundle.putInt("duedays", duedays);
		bundle.putLong("uid", values.getAsLong("id"));
		intent.putExtra("info", bundle);
		PendingIntent pendingIntent = PendingIntent.getService(context,
				(int) (long) values.getAsLong("id"), intent,
				PendingIntent.FLAG_UPDATE_CURRENT);
		if(manager == null){
			manager = (AlarmManager) context
					.getSystemService(Context.ALARM_SERVICE);
		}
		manager.set(AlarmManager.RTC_WAKEUP, date.getTimeInMillis(),
				pendingIntent);
	}

}
