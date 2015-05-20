package Receivers;

import com.homeworkreminder.Main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DateChangeReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		 final String action = intent.getAction();
         if (action.equals(Intent.ACTION_TIME_CHANGED) ||
             action.equals(Intent.ACTION_TIMEZONE_CHANGED))
         {
             if(Main.active){
            	 Main.updateDueDaysForAll();
             }
         }
	}

}
