package com.homeworkreminder.Theme;

import java.util.Random;

import android.content.Context;
import android.content.SharedPreferences;

import com.homeworkreminder.R;

public abstract class ThemeManager implements ColorProfileHandler{
	
	private Context context;

	public ThemeManager(Context ctx){
		this.context = ctx;
	}
	
	public Context getContext(){
		return this.context;
	}
	
	public void loadColorScheme(SharedPreferences prefs){
		setColor(this.getColorSchemeFromName(prefs.getString("Color_scheme", "Default")));
	}
	
	public void loadColorScheme(ColorScheme scheme){
		setColor(scheme);
	}
	
	public ColorScheme getColorSchemeFromName(String name){
		if(name.contentEquals(context.getResources().getString(R.string.color_default))){
			return ColorScheme.DEFAULT;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_blue))){
			return ColorScheme.BLUE;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_orange))){
			return ColorScheme.ORANGE;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_yellow))){
			return ColorScheme.YELLOW;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_green))){
			return ColorScheme.GREEN;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_grey))){
			return ColorScheme.GREY;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_teal))){
			return ColorScheme.NAVY;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_lime))){
			return ColorScheme.LIME;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_pink))){
			return ColorScheme.PINK;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_purple))){
			return ColorScheme.PURPLE;
		}else{
			return ColorScheme.DEFAULT;
		}
	}


	public TaskColorCombo getComboFromName(String name){
		if(name.contentEquals(context.getResources().getString(R.string.color_default))){
			return TaskColorCombo.DEFAULT;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_blue))){
			return TaskColorCombo.BLUE;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_orange))){
			return TaskColorCombo.ORANGE;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_yellow))){
			return TaskColorCombo.YELLOW;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_green))){
			return TaskColorCombo.GREEN;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_grey))){
			return TaskColorCombo.GREY;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_teal))){
			return TaskColorCombo.NAVY;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_lime))){
			return TaskColorCombo.LIME;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_pink))){
			return TaskColorCombo.PINK;
		}else if(name.contentEquals(context.getResources().getString(R.string.color_purple))){
			return TaskColorCombo.PURPLE;
		}else{
			return TaskColorCombo.DEFAULT;
		}
	}
}
