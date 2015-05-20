package com.homeworkreminder.Theme;

import com.homeworkreminder.Main;
import com.homeworkreminder.R;
import com.homeworkreminder.R.color;
import com.homeworkreminder.R.string;

public enum ColorScheme {

	DEFAULT(Main.getContext().getResources().getString(R.string.color_default),
			Main.getContext().getResources()
					.getColor(R.color.mat_indigo_ultralight), Main.getContext()
					.getResources().getColor(R.color.mat_indigo_superlight),
			Main.getContext().getResources()
					.getColor(R.color.mat_indigo_lighter), Main.getContext()
					.getResources().getColor(R.color.mat_indigo_light), Main
					.getContext().getResources()
					.getColor(R.color.mat_indigo_normal), Main.getContext()
					.getResources().getColor(R.color.mat_indigo_dark), Main
					.getContext().getResources()
					.getColor(R.color.mat_indigo_darker), Main.getContext()
					.getResources().getColor(R.color.mat_indigo_superdark),
			Main.getContext().getResources()
					.getColor(R.color.mat_indigo_ultradark), Main.getContext()
					.getResources().getColor(R.color.mat_indigo_crystal_light),
			Main.getContext().getResources()
					.getColor(R.color.mat_indigo_crystal), Main.getContext()
					.getResources().getColor(R.color.mat_indigo_crystal_dark)), 
	GREEN(
			Main.getContext().getResources().getString(R.string.color_green),
			Main.getContext().getResources()
					.getColor(R.color.mat_green_ultralight), Main.getContext()
					.getResources().getColor(R.color.mat_green_superlight),
			Main.getContext().getResources()
					.getColor(R.color.mat_green_lighter), Main.getContext()
					.getResources().getColor(R.color.mat_green_light), Main
					.getContext().getResources()
					.getColor(R.color.mat_green_normal), Main.getContext()
					.getResources().getColor(R.color.mat_green_dark), Main
					.getContext().getResources()
					.getColor(R.color.mat_green_darker), Main.getContext()
					.getResources().getColor(R.color.mat_green_superdark), Main
					.getContext().getResources()
					.getColor(R.color.mat_green_ultradark), Main.getContext()
					.getResources().getColor(R.color.mat_green_crystal_light),
			Main.getContext().getResources()
					.getColor(R.color.mat_green_crystal), Main.getContext()
					.getResources().getColor(R.color.mat_green_crystal_dark)), 
	BLUE(
			Main.getContext().getResources().getString(R.string.color_blue),
			Main.getContext().getResources()
					.getColor(R.color.mat_blue_ultralight),
			Main.getContext().getResources()
					.getColor(R.color.mat_blue_superlight),
			Main.getContext().getResources().getColor(R.color.mat_blue_lighter),
			Main.getContext().getResources().getColor(R.color.mat_blue_light),
			Main.getContext().getResources().getColor(R.color.mat_blue_normal),
			Main.getContext().getResources().getColor(R.color.mat_blue_dark),
			Main.getContext().getResources().getColor(R.color.mat_blue_darker),
			Main.getContext().getResources()
					.getColor(R.color.mat_blue_superdark),
			Main.getContext().getResources()
					.getColor(R.color.mat_blue_ultradark),
			Main.getContext().getResources()
					.getColor(R.color.mat_blue_crystal_light),
			Main.getContext().getResources().getColor(R.color.mat_blue_crystal),
			Main.getContext().getResources()
					.getColor(R.color.mat_blue_crystal_dark)), 
	ORANGE(
			Main.getContext().getResources().getString(R.string.color_orange),
			Main.getContext().getResources()
					.getColor(R.color.mat_orange_ultralight),
			Main.getContext().getResources()
					.getColor(R.color.mat_orange_superlight),
			Main.getContext().getResources()
					.getColor(R.color.mat_orange_lighter),
			Main.getContext().getResources().getColor(R.color.mat_orange_light),
			Main.getContext().getResources()
					.getColor(R.color.mat_orange_normal), Main.getContext()
					.getResources().getColor(R.color.mat_orange_dark), Main
					.getContext().getResources()
					.getColor(R.color.mat_orange_darker), Main.getContext()
					.getResources().getColor(R.color.mat_orange_superdark),
			Main.getContext().getResources()
					.getColor(R.color.mat_orange_ultradark), Main.getContext()
					.getResources().getColor(R.color.mat_orange_crystal_light),
			Main.getContext().getResources()
					.getColor(R.color.mat_orange_crystal), Main.getContext()
					.getResources().getColor(R.color.mat_orange_crystal_dark)), 
	YELLOW(
			Main.getContext().getResources().getString(R.string.color_yellow),
			Main.getContext().getResources()
					.getColor(R.color.mat_yellow_ultralight), Main.getContext()
					.getResources().getColor(R.color.mat_yellow_superlight),
			Main.getContext().getResources()
					.getColor(R.color.mat_yellow_lighter), Main.getContext()
					.getResources().getColor(R.color.mat_yellow_light), Main
					.getContext().getResources()
					.getColor(R.color.mat_yellow_light), Main.getContext()
					.getResources().getColor(R.color.mat_yellow_light), Main
					.getContext().getResources()
					.getColor(R.color.mat_yellow_normal), Main.getContext()
					.getResources().getColor(R.color.mat_yellow_normal), Main
					.getContext().getResources()
					.getColor(R.color.mat_yellow_dark), Main.getContext()
					.getResources().getColor(R.color.mat_yellow_crystal_light),
			Main.getContext().getResources()
					.getColor(R.color.mat_yellow_crystal), Main.getContext()
					.getResources().getColor(R.color.mat_yellow_crystal_dark)), 
	PURPLE(
			Main.getContext().getResources().getString(R.string.color_purple),
			Main.getContext().getResources()
					.getColor(R.color.mat_purple_ultralight), Main.getContext()
					.getResources().getColor(R.color.mat_purple_superlight),
			Main.getContext().getResources()
					.getColor(R.color.mat_purple_lighter), Main.getContext()
					.getResources().getColor(R.color.mat_purple_light), Main
					.getContext().getResources()
					.getColor(R.color.mat_purple_light), Main.getContext()
					.getResources().getColor(R.color.mat_purple_normal), Main
					.getContext().getResources()
					.getColor(R.color.mat_purple_dark), Main.getContext()
					.getResources().getColor(R.color.mat_purple_darker), Main
					.getContext().getResources()
					.getColor(R.color.mat_purple_darker), Main.getContext()
					.getResources().getColor(R.color.mat_purple_crystal_light),
			Main.getContext().getResources()
					.getColor(R.color.mat_purple_crystal), Main.getContext()
					.getResources().getColor(R.color.mat_purple_crystal_dark)), 
	PINK(
			Main.getContext().getResources().getString(R.string.color_pink),
			Main.getContext().getResources()
					.getColor(R.color.mat_pink_ultralight),
			Main.getContext().getResources()
					.getColor(R.color.mat_pink_superlight),
			Main.getContext().getResources().getColor(R.color.mat_pink_lighter),
			Main.getContext().getResources().getColor(R.color.mat_pink_lighter),
			Main.getContext().getResources().getColor(R.color.mat_pink_light),
			Main.getContext().getResources().getColor(R.color.mat_pink_light),
			Main.getContext().getResources().getColor(R.color.mat_pink_light),
			Main.getContext().getResources().getColor(R.color.mat_pink_normal),
			Main.getContext().getResources().getColor(R.color.mat_pink_dark),
			Main.getContext().getResources()
					.getColor(R.color.mat_pink_crystal_light),
			Main.getContext().getResources().getColor(R.color.mat_pink_crystal),
			Main.getContext().getResources()
					.getColor(R.color.mat_pink_crystal_dark)), 
	NAVY(Main
			.getContext().getResources().getString(R.string.color_teal), Main
			.getContext().getResources().getColor(R.color.mat_teal_ultralight),
			Main.getContext().getResources()
					.getColor(R.color.mat_teal_superlight), Main.getContext()
					.getResources().getColor(R.color.mat_teal_lighter), Main
					.getContext().getResources()
					.getColor(R.color.mat_teal_light), Main.getContext()
					.getResources().getColor(R.color.mat_teal_normal), Main
					.getContext().getResources()
					.getColor(R.color.mat_teal_dark), Main.getContext()
					.getResources().getColor(R.color.mat_teal_darker), Main
					.getContext().getResources()
					.getColor(R.color.mat_teal_superdark), Main.getContext()
					.getResources().getColor(R.color.mat_teal_ultradark), Main
					.getContext().getResources()
					.getColor(R.color.mat_teal_crystal_light), Main
					.getContext().getResources()
					.getColor(R.color.mat_teal_crystal), Main.getContext()
					.getResources().getColor(R.color.mat_teal_crystal_dark)), 
	LIME(
			Main.getContext().getResources().getString(R.string.color_lime),
			Main.getContext().getResources()
					.getColor(R.color.mat_light_green_ultralight), Main.getContext()
					.getResources()
					.getColor(R.color.mat_light_green_superlight), Main
					.getContext().getResources()
					.getColor(R.color.mat_light_green_lighter), Main
					.getContext().getResources()
					.getColor(R.color.mat_light_green_light), Main.getContext()
					.getResources().getColor(R.color.mat_light_green_normal),
			Main.getContext().getResources()
					.getColor(R.color.mat_light_green_dark), Main.getContext()
					.getResources().getColor(R.color.mat_light_green_darker),
			Main.getContext().getResources()
					.getColor(R.color.mat_light_green_superdark), Main
					.getContext().getResources()
					.getColor(R.color.mat_light_green_ultradark), Main
					.getContext().getResources()
					.getColor(R.color.mat_light_green_crystal_light), Main
					.getContext().getResources()
					.getColor(R.color.mat_light_green_crystal), Main
					.getContext().getResources()
					.getColor(R.color.mat_light_green_crystal_dark)), 
	GREY(Main
			.getContext().getResources().getString(R.string.color_grey), Main
			.getContext().getResources().getColor(R.color.mat_grey_ultralight),
			Main.getContext().getResources()
					.getColor(R.color.mat_grey_superlight), Main.getContext()
					.getResources().getColor(R.color.mat_grey_lighter), Main
					.getContext().getResources()
					.getColor(R.color.mat_grey_light), Main.getContext()
					.getResources().getColor(R.color.mat_grey_normal), Main
					.getContext().getResources()
					.getColor(R.color.mat_grey_dark), Main.getContext()
					.getResources().getColor(R.color.mat_grey_darker), Main
					.getContext().getResources()
					.getColor(R.color.mat_grey_superdark), Main.getContext()
					.getResources().getColor(R.color.mat_grey_ultradark), Main
					.getContext().getResources()
					.getColor(R.color.mat_grey_crystal_light), Main
					.getContext().getResources()
					.getColor(R.color.mat_grey_crystal), Main.getContext()
					.getResources().getColor(R.color.mat_grey_crystal_dark));

	private String name;
	private int ultra_light;
	private int super_light;
	private int lighter;
	private int light;
	private int normal;
	private int dark;
	private int darker;
	private int super_dark;
	private int ultra_dark;
	private int crystal_light;
	private int crystal;
	private int crystal_dark;

	ColorScheme(String name, int ultra_light, int super_light, int lighter,
			int light, int normal, int dark, int darker, int super_dark,
			int ultra_dark, int crystal_light, int crystal, int crystal_dark) {
		this.name = name;
		this.ultra_light = ultra_light;
		this.super_light = super_light;
		this.lighter = lighter;
		this.light = light;
		this.normal = normal;
		this.dark = dark;
		this.darker = darker;
		this.super_dark = super_dark;
		this.ultra_dark = ultra_dark;
		this.crystal_light = crystal_light;
		this.crystal = crystal;
		this.crystal_dark = crystal_dark;
	}

	public String getColorName() {
		return this.name;
	}

	public int getUltraLightColor() {
		return this.ultra_light;
	}

	public int getSuperLightColor() {
		return this.super_light;
	}

	public int getLighterColor() {
		return this.lighter;
	}

	public int getLightColor() {
		return this.light;
	}

	public int getNormalColor() {
		return this.normal;
	}

	public int getDarkColor() {
		return this.dark;
	}

	public int getDarkerColor() {
		return this.darker;
	}

	public int getSuperDarkColor() {
		return this.super_dark;
	}

	public int getUltraDarkColor() {
		return this.ultra_dark;
	}

	public int getLightCrystalColor() {
		return this.crystal_light;
	}

	public int getCrystalColor() {
		return this.crystal;
	}

	public int getDarkCrystalColor() {
		return this.crystal_dark;
	}

}
