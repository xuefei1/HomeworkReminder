package com.homeworkreminder.Theme;

public class WidgetColorScheme {
	
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

	WidgetColorScheme(String name, int ultra_light, int super_light, int lighter,
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
