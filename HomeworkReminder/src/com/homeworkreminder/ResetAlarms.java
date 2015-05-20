package com.homeworkreminder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class ResetAlarms extends BroadcastReceiver {

	CoreDatabase Database;
	List<ContentValues> alarmsToStart = new ArrayList<ContentValues>();
	ContentValues a = new ContentValues();

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Database = new CoreDatabase(context);
		AlarmHandler ah = new AlarmHandler(context);
		if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
			this.alarmsToStart = Database.queryAlarmList();
			Iterator<ContentValues> it = alarmsToStart.iterator();
			while (it.hasNext()) {
				a = it.next();
				ah.reAvtivateAlarms(a, a.getAsString("reminder"), context);
			}

		}
	}

}
