package com.homeworkreminder;


import android.app.Service;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class ScheduleService extends Service{

	 /**
     * Class for clients to access
     */
	final String NOREMINDER = "NOREMINDER";
    public class ServiceBinder extends Binder {
        ScheduleService getService() {
            return ScheduleService.this;
        }
    }
 
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // We want this service to continue running until it is explicitly stopped, so return sticky.
        return START_STICKY;
    }
 
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
 
    // This is the object that receives interactions from clients. See
    private final IBinder mBinder = new ServiceBinder();
 
    /**
     * Show an alarm for a certain date when the alarm is called it will pop up a notification
     */
    public void setAlarm(ContentValues c) {
        // This starts a new thread to set the alarm
        // You want to push off your tasks onto a new thread to free up the UI to carry on responding
    	switch(Util.convertStringToArray(c.getAsString("reminders")).length){
    	case 1:
    		if(Util.convertStringToArray(c.getAsString("reminders"))[0].contentEquals(NOREMINDER)){
    			break;
    		}
    		int o = c.getAsInteger("id");
    		c.put("original_id", o);
    		String s = String.valueOf(o);
    		s = s+"0";
    		int f = Integer.parseInt(s);
    		c.put("id", f);
    		Main.getAlarmHandler().ActivateAlarm(c, Util.convertStringToArray(c.getAsString("reminders"))[0]);
    		break;
    	case 2:
    		int p = c.getAsInteger("id");
    		c.put("original_id", p);
    		String k = String.valueOf(p);
    		k = k+"0";
    		int x = Integer.parseInt(k);
    		c.put("id", x);
    		Main.getAlarmHandler().ActivateAlarm(c, Util.convertStringToArray(c.getAsString("reminders"))[0]);
    		k = String.valueOf(p);
    		k = k+"1";
    		int y = Integer.parseInt(k);
    		c.put("id", y);
    		Main.getAlarmHandler().ActivateAlarm(c, Util.convertStringToArray(c.getAsString("reminders"))[1]);
    		break;
    	case 3:
    		int q = c.getAsInteger("id");
    		c.put("original_id", q);
    		String z = String.valueOf(q);
    		z = z+"0";
    		int r = Integer.parseInt(z);
    		c.put("id", r);
    		Main.getAlarmHandler().ActivateAlarm(c, Util.convertStringToArray(c.getAsString("reminders"))[0]);
    		z = String.valueOf(q);
    		z = z+"1";
    		int d = Integer.parseInt(z);
    		c.put("id", d);
    		Main.getAlarmHandler().ActivateAlarm(c, Util.convertStringToArray(c.getAsString("reminders"))[1]);
    		String v = String.valueOf(q);
    		v = v+"2";
    		int g = Integer.parseInt(v);
    		c.put("id", g);
    		Main.getAlarmHandler().ActivateAlarm(c, Util.convertStringToArray(c.getAsString("reminders"))[2]);
    		break;
    	}
    }

	public void cancelAlarm(int id) {
		// TODO Auto-generated method stub
		Main.getAlarmHandler().CancelAlarm((long)id);
	}

}
