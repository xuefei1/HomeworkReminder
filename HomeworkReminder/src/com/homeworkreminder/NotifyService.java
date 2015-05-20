package com.homeworkreminder;

import com.homeworkreminder.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;

public class NotifyService extends Service{

	 /**
     * Class for clients to access
     */
	
	private static final String HOMEWORK = "Homework";
	private static final String LAB = "Lab";
	private static final String EXAM = "Exam";
	private static final String OTHER = "Other"; 
	CoreDatabase Database;
    public class ServiceBinder extends Binder {
        NotifyService getService() {
            return NotifyService.this;
        }
    }
 
    // Unique id to identify the notification.
    private int NOTIFICATION = 0;
    // Name of an intent extra we can use to identify if this service was started to create a notification  
    public static final String INTENT_NOTIFY = "com.homeworkreminder.service.INTENT_NOTIFY";
    // The system notification manager
    private NotificationManager mNM;
 
    @Override
    public void onCreate() {
    	super.onCreate();
        mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Database = new CoreDatabase(this);
    }
 
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = new Bundle();
        bundle = intent.getBundleExtra("info");
        //Toast.makeText(getApplicationContext(), "Notification name: "+bundle.getString("name")+", id: "+bundle.getLong("uid"), Toast.LENGTH_LONG).show();
        // If this service was started by out AlarmTask intent then we want to show our notification
        if(intent.getBooleanExtra(INTENT_NOTIFY, false))
            showNotification(bundle);
         
        // We don't care if this service is stopped as we have already delivered our notification
        return START_NOT_STICKY;
    }
 
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
 
    // This is the object that receives interactions from clients
    private final IBinder mBinder = new ServiceBinder();
 
    /**
     * Creates a notification and shows it in the OS drag-down status bar
     */
    private void showNotification(Bundle b) {
        // This is the 'title' of the notification
    	SharedPreferences getPrefs = PreferenceManager
				.getDefaultSharedPreferences(this);
    	boolean isSoundAllowed = getPrefs.getBoolean("Reminder_Sound_Enable", false);
    	CharSequence title;
    	this.NOTIFICATION = (int) b.getLong("uid");
    	switch(b.getString("type")){
    	case HOMEWORK:
    		title = b.getString("name") + " due " + genDue(Util.calculateDueDays(Database.queryById(b.getInt("task_id")).getDue()));
    		break;
    	case LAB:
    		title = "Lab: "+b.getString("name")+ " " + genDue(Util.calculateDueDays(Database.queryById(b.getInt("task_id")).getDue()));
    		break;
    	case EXAM:
    		title = "Exam: "+b.getString("name")+ " " + genDue(Util.calculateDueDays(Database.queryById(b.getInt("task_id")).getDue()));
    		break;	
    	case OTHER:
    		title = b.getString("name") + " due " + genDue(Util.calculateDueDays(Database.queryById(b.getInt("task_id")).getDue()));
    		break;
    		default:
    			title = b.getString("name") + " due " + genDue(Util.calculateDueDays(Database.queryById(b.getInt("task_id")).getDue()));
    	}
        // This is the icon to use on the notification
        int icon = R.drawable.ic_action_event;
        // This is the scrolling text of the notification
        CharSequence text = "Tap to launch homework reminder";       
        // What time to show on the notification
        long time = System.currentTimeMillis();
        
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setAutoCancel(true);
        builder.setContentTitle(title);
        builder.setContentText(text);
        builder.setSmallIcon(icon);
        builder.setWhen(time);
        Uri uri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        if(isSoundAllowed){
        	builder.setSound(uri);
        }
        Intent resultIntent = new Intent(this, Main.class);
        // Because clicking the notification opens a new ("special") activity, there's
        // no need to create an artificial back stack.
        PendingIntent resultPendingIntent =
            PendingIntent.getActivity(
            this,
            0,
            resultIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        );
        builder.setContentIntent(resultPendingIntent);
        
        Notification notification = builder.build();
        if(mNM == null){
        	mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        }
        mNM.notify(this.NOTIFICATION, notification);
        Database.deleteAlarm(this.NOTIFICATION);
        // Stop the service when we are finished
        stopSelf();
    }
    
    protected void cancelCurrentDisplayingNotifications(){
    	if(mNM == null){
        	mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        }
    	mNM.cancelAll();
	}
    
    private String genDue(int a){
    	String s = " ";
    	if(a<1){
    		s = "today";
    	}else if(a<2){
    		s = "tomorrow";
    	}else{
    		s = "in "+a+" days";
    	}
    	switch(a){
    	case -12:
    		s = "in 12 hours";
    		break;
    	case -8:
    		s = "in 8 hours";
    		break;
    	case -4:
    		s = "in 4 hours";
    		break;
    	case -2:
    		s = "in 2 hours";
    		break;
    	case -1:
    		s = "in 1 hour";
    		break;
    	case -30:
    		s = "in 30 minutes";
    		break;
    	case -10:
    		s = "in 10 minutes";
    		break;
    	}
    	return s;
    }
}
