package myMasterpiece;

import processing.core.PGraphics;

import java.awt.Color;

public abstract class WeatherCondition {
	
	PGraphics g;
	
	public WeatherCondition(PGraphics gU)
	{
		g = gU;
	}
	
	public abstract void draw();
	public abstract String getWeatherDescription();
	public abstract Color getBackground(String weather);
	
	
}