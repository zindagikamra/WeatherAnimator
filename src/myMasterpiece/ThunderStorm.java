package myMasterpiece;
import java.awt.Color;
import java.util.ArrayList;

import processing.core.*;

public class ThunderStorm extends WeatherCondition
{
	private ArrayList<Rain> storm = new ArrayList<Rain>();
	private Color blue = new Color(62, 165, 230);
	
	public ThunderStorm(PGraphics g)
	{
		super(g);
		
		for(int i = 0; i < 35; i++)
		{
			storm.add(new Rain());
		}
	}
	
	public String getWeatherDescription()
	{
		return "Thunderstorm";
	}
	
	public Color getBackground(String weather)
	{
		return new Color(8, 33, 77);
	}
	
	public void draw()
	{
		g.fill(252, 226, 5);
		g.quad(0, 0, 120, 200,  240, 200, 200, 0);
		g.triangle(200, 200, 50, 200, 260, 400);
		
		g.quad(800, 0, 680, 200, 560, 200, 600, 0);
		g.triangle(600, 200, 750, 200, 540, 400);
		
		Rain.animate(g, storm, blue);
		
		
	}


}