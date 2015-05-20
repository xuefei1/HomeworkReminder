package com.homeworkreminder.Theme;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import com.homeworkreminder.R;

public class WidgetColorFactory {
	
	private HashMap<String, WidgetColorScheme> factoryMap = new HashMap<String, WidgetColorScheme>();
	private Context context;
	
	public WidgetColorFactory(Context ctx){
		
		this.context = ctx;
		
		this.factoryMap.put(this.context.getResources().getString(R.string.color_default), new WidgetColorScheme(this.context.getResources().getString(R.string.color_default),
				this.context.getResources()
					.getColor(R.color.mat_indigo_ultralight),this.context.getResources().getColor(R.color.mat_indigo_superlight),
					this.context.getResources()
					.getColor(R.color.mat_indigo_lighter), this.context.getResources().getColor(R.color.mat_indigo_light), this
					.getContext().getResources()
					.getColor(R.color.mat_indigo_normal),this.context.getResources().getColor(R.color.mat_indigo_dark), this
					.getContext().getResources()
					.getColor(R.color.mat_indigo_darker),this.context.getResources().getColor(R.color.mat_indigo_superdark),
					this.context.getResources()
					.getColor(R.color.mat_indigo_ultradark), this.context.getResources().getColor(R.color.mat_indigo_crystal_light),
					this.context.getResources().getColor(R.color.mat_indigo_crystal),this.context.getResources().getColor(R.color.mat_indigo_crystal_dark)));
		
		this.factoryMap.put(this.context.getResources().getString(R.string.color_blue), new WidgetColorScheme(this.context.getResources().getString(R.string.color_blue),
				this.context.getResources()
					.getColor(R.color.mat_blue_ultralight),this.context.getResources().getColor(R.color.mat_blue_superlight),
					this.context.getResources()
					.getColor(R.color.mat_blue_lighter), this.context.getResources().getColor(R.color.mat_blue_light), this
					.getContext().getResources()
					.getColor(R.color.mat_blue_normal),this.context.getResources().getColor(R.color.mat_blue_dark), this
					.getContext().getResources()
					.getColor(R.color.mat_blue_darker),this.context.getResources().getColor(R.color.mat_blue_superdark),
					this.context.getResources()
					.getColor(R.color.mat_blue_ultradark), this.context.getResources().getColor(R.color.mat_blue_crystal_light),
					this.context.getResources().getColor(R.color.mat_blue_crystal),this.context.getResources().getColor(R.color.mat_blue_crystal_dark)));
	
		this.factoryMap.put(this.context.getResources().getString(R.string.color_green), new WidgetColorScheme(this.context.getResources().getString(R.string.color_green),
				this.context.getResources()
					.getColor(R.color.mat_green_ultralight),this.context.getResources().getColor(R.color.mat_green_superlight),
					this.context.getResources()
					.getColor(R.color.mat_green_lighter), this.context.getResources().getColor(R.color.mat_green_light), this
					.getContext().getResources()
					.getColor(R.color.mat_green_normal),this.context.getResources().getColor(R.color.mat_green_dark), this
					.getContext().getResources()
					.getColor(R.color.mat_green_darker),this.context.getResources().getColor(R.color.mat_green_superdark),
					this.context.getResources()
					.getColor(R.color.mat_green_ultradark), this.context.getResources().getColor(R.color.mat_green_crystal_light),
					this.context.getResources().getColor(R.color.mat_green_crystal),this.context.getResources().getColor(R.color.mat_green_crystal_dark)));
		
		this.factoryMap.put(this.context.getResources().getString(R.string.color_orange), new WidgetColorScheme(this.context.getResources().getString(R.string.color_orange),
				this.context.getResources()
					.getColor(R.color.mat_orange_ultralight),this.context.getResources().getColor(R.color.mat_orange_superlight),
					this.context.getResources()
					.getColor(R.color.mat_orange_lighter), this.context.getResources().getColor(R.color.mat_orange_light), this
					.getContext().getResources()
					.getColor(R.color.mat_orange_normal),this.context.getResources().getColor(R.color.mat_orange_dark), this
					.getContext().getResources()
					.getColor(R.color.mat_orange_darker),this.context.getResources().getColor(R.color.mat_orange_superdark),
					this.context.getResources()
					.getColor(R.color.mat_orange_ultradark), this.context.getResources().getColor(R.color.mat_orange_crystal_light),
					this.context.getResources().getColor(R.color.mat_orange_crystal),this.context.getResources().getColor(R.color.mat_orange_crystal_dark)));
		
		this.factoryMap.put(this.context.getResources().getString(R.string.color_yellow), new WidgetColorScheme(this.context.getResources().getString(R.string.color_yellow),
				this.context.getResources()
					.getColor(R.color.mat_yellow_ultralight),this.context.getResources().getColor(R.color.mat_yellow_superlight),
					this.context.getResources()
					.getColor(R.color.mat_yellow_lighter), this.context.getResources().getColor(R.color.mat_yellow_light), this
					.getContext().getResources()
					.getColor(R.color.mat_yellow_normal),this.context.getResources().getColor(R.color.mat_yellow_dark), this
					.getContext().getResources()
					.getColor(R.color.mat_yellow_darker),this.context.getResources().getColor(R.color.mat_yellow_superdark),
					this.context.getResources()
					.getColor(R.color.mat_yellow_ultradark), this.context.getResources().getColor(R.color.mat_yellow_crystal_light),
					this.context.getResources().getColor(R.color.mat_yellow_crystal),this.context.getResources().getColor(R.color.mat_yellow_crystal_dark)));
		
		this.factoryMap.put(this.context.getResources().getString(R.string.color_lime), new WidgetColorScheme(this.context.getResources().getString(R.string.color_lime),
				this.context.getResources()
					.getColor(R.color.mat_light_green_ultralight),this.context.getResources().getColor(R.color.mat_light_green_superlight),
					this.context.getResources()
					.getColor(R.color.mat_light_green_lighter), this.context.getResources().getColor(R.color.mat_light_green_light), this
					.getContext().getResources()
					.getColor(R.color.mat_light_green_normal),this.context.getResources().getColor(R.color.mat_light_green_dark), this
					.getContext().getResources()
					.getColor(R.color.mat_light_green_darker),this.context.getResources().getColor(R.color.mat_light_green_superdark),
					this.context.getResources()
					.getColor(R.color.mat_light_green_ultradark), this.context.getResources().getColor(R.color.mat_light_green_crystal_light),
					this.context.getResources().getColor(R.color.mat_light_green_crystal),this.context.getResources().getColor(R.color.mat_light_green_crystal_dark)));
		
		this.factoryMap.put(this.context.getResources().getString(R.string.color_grey), new WidgetColorScheme(this.context.getResources().getString(R.string.color_grey),
				this.context.getResources()
					.getColor(R.color.mat_grey_ultralight),this.context.getResources().getColor(R.color.mat_grey_superlight),
					this.context.getResources()
					.getColor(R.color.mat_grey_lighter), this.context.getResources().getColor(R.color.mat_grey_light), this
					.getContext().getResources()
					.getColor(R.color.mat_grey_normal),this.context.getResources().getColor(R.color.mat_grey_dark), this
					.getContext().getResources()
					.getColor(R.color.mat_grey_darker),this.context.getResources().getColor(R.color.mat_grey_superdark),
					this.context.getResources()
					.getColor(R.color.mat_grey_ultradark), this.context.getResources().getColor(R.color.mat_grey_crystal_light),
					this.context.getResources().getColor(R.color.mat_grey_crystal),this.context.getResources().getColor(R.color.mat_grey_crystal_dark)));
		
		this.factoryMap.put(this.context.getResources().getString(R.string.color_teal), new WidgetColorScheme(this.context.getResources().getString(R.string.color_teal),
				this.context.getResources()
					.getColor(R.color.mat_teal_ultralight),this.context.getResources().getColor(R.color.mat_teal_superlight),
					this.context.getResources()
					.getColor(R.color.mat_teal_lighter), this.context.getResources().getColor(R.color.mat_teal_light), this
					.getContext().getResources()
					.getColor(R.color.mat_teal_normal),this.context.getResources().getColor(R.color.mat_teal_dark), this
					.getContext().getResources()
					.getColor(R.color.mat_teal_darker),this.context.getResources().getColor(R.color.mat_teal_superdark),
					this.context.getResources()
					.getColor(R.color.mat_teal_ultradark), this.context.getResources().getColor(R.color.mat_teal_crystal_light),
					this.context.getResources().getColor(R.color.mat_teal_crystal),this.context.getResources().getColor(R.color.mat_teal_crystal_dark)));
		
		this.factoryMap.put(this.context.getResources().getString(R.string.color_pink), new WidgetColorScheme(this.context.getResources().getString(R.string.color_pink),
				this.context.getResources()
					.getColor(R.color.mat_pink_ultralight),this.context.getResources().getColor(R.color.mat_pink_superlight),
					this.context.getResources()
					.getColor(R.color.mat_pink_lighter), this.context.getResources().getColor(R.color.mat_pink_light), this
					.getContext().getResources()
					.getColor(R.color.mat_pink_normal),this.context.getResources().getColor(R.color.mat_pink_dark), this
					.getContext().getResources()
					.getColor(R.color.mat_pink_darker),this.context.getResources().getColor(R.color.mat_pink_superdark),
					this.context.getResources()
					.getColor(R.color.mat_pink_ultradark), this.context.getResources().getColor(R.color.mat_pink_crystal_light),
					this.context.getResources().getColor(R.color.mat_pink_crystal),this.context.getResources().getColor(R.color.mat_pink_crystal_dark)));
		
		this.factoryMap.put(this.context.getResources().getString(R.string.color_purple), new WidgetColorScheme(this.context.getResources().getString(R.string.color_purple),
				this.context.getResources()
					.getColor(R.color.mat_purple_ultralight),this.context.getResources().getColor(R.color.mat_purple_superlight),
					this.context.getResources()
					.getColor(R.color.mat_purple_lighter), this.context.getResources().getColor(R.color.mat_purple_light), this
					.getContext().getResources()
					.getColor(R.color.mat_purple_normal),this.context.getResources().getColor(R.color.mat_purple_dark), this
					.getContext().getResources()
					.getColor(R.color.mat_purple_darker),this.context.getResources().getColor(R.color.mat_purple_superdark),
					this.context.getResources()
					.getColor(R.color.mat_purple_ultradark), this.context.getResources().getColor(R.color.mat_purple_crystal_light),
					this.context.getResources().getColor(R.color.mat_purple_crystal),this.context.getResources().getColor(R.color.mat_purple_crystal_dark)));
		
	}
	
	public WidgetColorScheme getColorScheme(String color){
		return this.factoryMap.get(color);
	}
	
	public Context getContext(){
		return this.context;
	}

}
