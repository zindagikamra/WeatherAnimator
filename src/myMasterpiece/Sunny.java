package myMasterpiece;
import java.awt.Color;

import processing.core.PGraphics;

public class Sunny extends WeatherCondition
{
	private Color sunBody = new Color(252, 226, 5);
	private Color rayColor = new Color(253, 165, 15);
	public Sunny(PGraphics g)
	{
		super(g);
	}
	
	public String getWeatherDescription()
	{
		return "Clear";
	}
	
	public Color getBackground(String weather)
	{
		return new Color(99, 219, 235);
	}
	
	public void draw()
	{
		g.noStroke();
		g.fill(sunBody.getRGB());
		g.ellipse(710, 50, 200, 200);
		
		g.strokeWeight(5);
		g.stroke(rayColor.getRGB());
		g.line(100, 25, 600, 25);
		g.line(300, 125, 600, 75);
		g.line(150, 300, 615, 115);
		g.line(425, 330, 640, 140);
		g.line(500, 475, 680, 160);
		g.line(675, 400, 720, 170);
		g.line(760, 510, 760, 160);
		
		
	}
}