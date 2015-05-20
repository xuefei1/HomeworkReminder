package com.homeworkreminder.Theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public abstract class WidgetThemeManager implements WidgetColorProfileHandler{
	
	Context context;
	WidgetColorFactory factory;
	
	public WidgetThemeManager(Context ctx){
		this.context = ctx;
		this.factory = new WidgetColorFactory(ctx);
	}

	public Context getContext(){
		return this.context;
	}
	
	public void loadColorScheme(SharedPreferences prefs){
		Log.d("PREFS", prefs.getString("Color_scheme", "not found"));
		setColor(this.factory.getColorScheme(prefs.getString("Color_scheme", "Default")));
	}

}
