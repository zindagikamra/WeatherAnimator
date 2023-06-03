package myMasterpiece;
import java.awt.Color;
import java.util.*;

import processing.core.PGraphics;

public class Snowing extends WeatherCondition
{
	private ArrayList<Particle> snowing = new ArrayList<Particle>();
	private Color color = new Color(255, 255, 255);
	
	public Snowing(PGraphics g)
	{
		super(g);
		
		for(int i = 0; i < 30; i++)
		{
			snowing.add(new Particle());
		}
	}
	
	public String getWeatherDescription()
	{
		return "Snowing";
	}
	
	public Color getBackground(String weather)
	{
		return new Color(4, 12, 43);
	}
	
	public void draw()
	{
		for(int i = 0; i < snowing.size(); i++)
		{
			Particle s = snowing.get(i);
			
			g.scale(s.scale);
			g.noStroke();
			g.fill(color.getRGB());
			
			s.y += s.speed;
			s.y %= 570;
			
			g.ellipse(s.x,  s.y,  50, 50);
			g.scale(1/s.scale);
			
			g.fill(230, 230, 230);
			g.ellipse(100, 0, 300, 100);
			g.ellipse(400, 0, 400, 150);
			g.ellipse(600, 0, 300, 80);
			g.ellipse(750, 0, 200, 120);
			
		}
	}
}