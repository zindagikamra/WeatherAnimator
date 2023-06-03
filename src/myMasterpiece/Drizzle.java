package myMasterpiece;
import java.awt.Color;
import java.util.ArrayList;

import processing.core.*;

public class Drizzle extends WeatherCondition
{
	private ArrayList<Rain> drizzle = new ArrayList<Rain>();
	private Color blue = new Color(116, 234, 247);
	private Sunny sun;
	
	public Drizzle(PGraphics g)
	{
		super(g);
		
		for(int i = 0; i < 15; i++)
		{
			drizzle.add(new Rain());
		}
		
		sun = new Sunny(g);
	}
	
	public String getWeatherDescription()
	{
		return "Drizzle";
	}
	
	public Color getBackground(String weather)
	{
		return new Color(110, 173, 181);
	}
	
	
	public void draw()
	{
		sun.draw();
		Rain.animate(g, drizzle, blue);
	}
}