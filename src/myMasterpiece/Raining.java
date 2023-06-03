package myMasterpiece;
import java.awt.Color;
import java.util.ArrayList;

import processing.core.PGraphics;

public class Raining extends WeatherCondition
{
	private ArrayList<Rain> raining = new ArrayList<Rain>();
	private Color blue = new Color(62, 165, 230);
	
	public Raining(PGraphics g)
	{
		super(g);
		
		for(int i = 0; i < 25; i++)
		{
			raining.add(new Rain());
		}
		
	}
	
	public String getWeatherDescription()
	{
		return "Raining";
	}
	
	public Color getBackground(String weather)
	{
		return new Color(77, 114, 128);
	}
	
	
	public void draw()
	{
		
		Rain.animate(g, raining, blue);
		
		g.fill(145, 158, 163);
		g.ellipse(100, 0, 300, 100);
		g.ellipse(400, 0, 400, 150);
		g.ellipse(600, 0, 300, 80);
		g.ellipse(750, 0, 200, 120);
	}
}