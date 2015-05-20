package com.homeworkreminder.Theme;

import android.content.Context;

import com.homeworkreminder.Main;
import com.homeworkreminder.R;

public enum TaskColorCombo {
	
	DEFAULT(Main.getContext().getResources().getColor(R.color.mat_indigo_normal),  
			Main.getContext().getResources().getColor(R.color.mat_green_A400),  
			Main.getContext().getResources().getColor(R.color.mat_orange_A400),  
			Main.getContext().getResources().getColor(R.color.mat_purple_A400)),
			
	GREEN(Main.getContext().getResources().getColor(R.color.mat_green_normal), 
			Main.getContext().getResources().getColor(R.color.mat_cyan_A400), 
			Main.getContext().getResources().getColor(R.color.mat_pink_A400),  
			Main.getContext().getResources().getColor(R.color.mat_deep_purple_A400)),
			
	BLUE(Main.getContext().getResources().getColor(R.color.mat_blue_A400), 
			Main.getContext().getResources().getColor(R.color.mat_light_green_A400), 
			Main.getContext().getResources().getColor(R.color.mat_orange_A400),  
			Main.getContext().getResources().getColor(R.color.mat_purple_superdark)),
			
	ORANGE(Main.getContext().getResources().getColor(R.color.mat_orange_A400), 
			Main.getContext().getResources().getColor(R.color.mat_light_green_A400), 
			Main.getContext().getResources().getColor(R.color.mat_pink_A400),  
			Main.getContext().getResources().getColor(R.color.mat_deep_purple_A400)),
			
	YELLOW(Main.getContext().getResources().getColor(R.color.mat_yellow_light), 
			Main.getContext().getResources().getColor(R.color.mat_light_green_light), 
			Main.getContext().getResources().getColor(R.color.mat_cyan_light),  
			Main.getContext().getResources().getColor(R.color.mat_pink_A400)),
			
	NAVY(Main.getContext().getResources().getColor(R.color.mat_teal_dark), 
			Main.getContext().getResources().getColor(R.color.mat_green_normal), 
			Main.getContext().getResources().getColor(R.color.mat_orange_normal),  
			Main.getContext().getResources().getColor(R.color.mat_purple_dark)),
			
	PINK(Main.getContext().getResources().getColor(R.color.mat_pink_A400), 
			Main.getContext().getResources().getColor(R.color.mat_light_green_A400), 
			Main.getContext().getResources().getColor(R.color.mat_cyan_A400),  
			Main.getContext().getResources().getColor(R.color.mat_purple_light)),
			
	LIME(Main.getContext().getResources().getColor(R.color.mat_green_normal), 
			Main.getContext().getResources().getColor(R.color.mat_cyan_A400), 
			Main.getContext().getResources().getColor(R.color.mat_yellow_light),  
			Main.getContext().getResources().getColor(R.color.mat_deep_purple_A400)),
			
	GREY(Main.getContext().getResources().getColor(R.color.mat_grey_dark), 
			Main.getContext().getResources().getColor(R.color.mat_green_dark), 
			Main.getContext().getResources().getColor(R.color.mat_orange_A400),  
			Main.getContext().getResources().getColor(R.color.mat_purple_dark)),
			
	PURPLE(Main.getContext().getResources().getColor(R.color.mat_purple_normal), 
			Main.getContext().getResources().getColor(R.color.mat_light_green_A400), 
			Main.getContext().getResources().getColor(R.color.mat_cyan_A400),  
			Main.getContext().getResources().getColor(R.color.mat_deep_purple_A400));

	private int hw_color;
	private int lab_color;
	private int exam_color;
	private int other_color;
	TaskColorCombo(int hw, int lab, int exam, int other){
		this.hw_color = hw;
		this.lab_color = lab;
		this.exam_color = exam;
		this.other_color = other;
	}
	
	public int getHWColor(){
		return this.hw_color;
	}
	
	public int getLabColor(){
		return this.lab_color;
	}
	
	public int getExamColor(){
		return this.exam_color;
	}
	
	public int getOtherColor(){
		return this.other_color;
	}

}
