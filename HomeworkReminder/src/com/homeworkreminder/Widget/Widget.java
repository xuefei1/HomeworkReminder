package com.homeworkreminder.Widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.RemoteViews;

import com.homeworkreminder.CoreDatabase;
import com.homeworkreminder.Main;
import com.homeworkreminder.R;
import com.homeworkreminder.Theme.WidgetColorScheme;
import com.homeworkreminder.Theme.WidgetThemeManager;

public class Widget extends AppWidgetProvider{
	
	private WidgetThemeManager theme;

	@SuppressWarnings("deprecation")
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub

		// update each of the app widgets with the remote adapter
	    for (int i = 0; i < appWidgetIds.length; ++i) {
	        
	    	 SharedPreferences sharedprefer = PreferenceManager.getDefaultSharedPreferences(context);
             SharedPreferences.Editor editor=sharedprefer.edit();
             editor.putInt("widget_key", appWidgetIds[i]);
             editor.commit();
	        // Set up the intent that starts the StackViewService, which will
	        // provide the views for this collection.
	        Intent intent = new Intent(context, WidgetUpdateService.class);
	        // Add the app widget ID to the intent extras.
	        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
	        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
	        // Instantiate the RemoteViews object for the app widget layout.
	        final RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget);
	        
	        theme = new WidgetThemeManager(context){

				@Override
				public void setColor(WidgetColorScheme scheme) {
					// TODO Auto-generated method stub
					rv.setInt(R.id.widget_title_container, "setBackgroundColor", scheme.getCrystalColor());
					rv.setInt(R.id.widget_content_container, "setBackgroundColor", scheme.getCrystalColor());
					rv.setInt(R.id.widget_layout, "setBackgroundColor", scheme.getCrystalColor());
				}
	        	
	        };
	        // Set up the RemoteViews object to use a RemoteViews adapter. 
	        // This adapter connects
	        // to a RemoteViewsService  through the specified intent.
	        // This is how you populate the data.
	        rv.setRemoteAdapter(appWidgetIds[i], R.id.widget_listview, intent);
	        Intent clickIntent = new Intent(context, getClass());
	        PendingIntent clickPI=PendingIntent.getBroadcast(context, 0, clickIntent, 0);
	        rv.setPendingIntentTemplate(R.id.widget_listview, clickPI);
	        // The empty view is displayed when the collection has no items. 
	        // It should be in the same layout used to instantiate the RemoteViews
	        // object above.
	        rv.setEmptyView(R.id.widget_listview, R.id.widget_no_task_text);
	        theme.loadColorScheme(PreferenceManager.getDefaultSharedPreferences(context));
	        //
	        // Do additional processing specific to this app widget...
	        //
	        ComponentName component=new ComponentName(context,Widget.class);
			appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widget_listview);
			appWidgetManager.updateAppWidget(component, rv);
	        appWidgetManager.updateAppWidget(appWidgetIds[i], rv);   
	    }
	    super.onUpdate(context, appWidgetManager, appWidgetIds);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
		if(intent.getAction().contentEquals("complete")){
			Log.d("BUTTON", "finish button clicked");
			CoreDatabase db = new CoreDatabase(context);
			db.completeTask(intent.getIntExtra("id", 0));
			int[] appid=new int[1];
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            appid[0]=prefs.getInt("widget_key",0);
			this.onUpdate(context, AppWidgetManager.getInstance(context),appid);
			if(Main.active){
				Main.completeTaskById(intent.getIntExtra("id", -1));
			}
		}
	}

}
