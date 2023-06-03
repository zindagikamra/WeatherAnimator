package myMasterpiece;


import java.awt.Color;
import java.util.ArrayList;

import processing.core.PGraphics;

public class Cloudy extends WeatherCondition 
{
	
	private ArrayList<Cloud> clouds = new ArrayList<Cloud>();
	private String type = "Cloudy";
	
	public Cloudy(PGraphics gU, int id)
	{
		super(gU);
		
		
		for (int i=0;i<11;i++)
		{
			clouds.add(new Cloud());
		}
		
		if(id == 771)
		{
			type = "Squall";
		}
	}
	
	
	public String getWeatherDescription()
	{
		return type;
	}
	
	public Color getBackground(String weather)
	{
		return new Color(110, 173, 181);
	}
	
	public void draw()
	{
		Cloud.animate(g, clouds);
	}

}