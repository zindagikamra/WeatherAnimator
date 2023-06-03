package myMasterpiece;

import processing.core.PGraphics;
import java.util.ArrayList;
import java.awt.Color;

public class Atmosphere extends WeatherCondition
{
	private String type;
	private ArrayList<Cloud> fog = new ArrayList<Cloud>();
	private ArrayList<Particle> dustOrAsh = new ArrayList<Particle>();
	private Color cloudColor = new Color(209, 209, 209);
	private Color dustColor = new Color(110, 57, 18);
	private Color ashColor = new Color(87, 87, 87);
	private Tornado tornado;
	
	public Atmosphere(PGraphics g, int id)
	{
		super(g);
		
		if(id == 701 || id == 711 || id == 721 || id == 741)
		{
			type = "Mist or Fog";
			for(int i = 0; i< 15; i++)
			{
				fog.add(new Cloud());
			}
			
		}
		else if(id == 731 || id == 751 || id == 761)
		{
			type = "Dust";
			for(int i = 0; i < 30; i++)
			{
				dustOrAsh.add(new Particle());
			}
		}
		else if(id == 762)
		{
			type = "Ash";
			for(int i = 0; i < 30; i++)
			{
				dustOrAsh.add(new Particle());
			}
		}
		else
		{
			type = "Tornado";
			tornado = new Tornado();
		}
	}
	
	public String getWeatherDescription()
	{
		return type;
	}
	
	public Color getBackground(String weather)
	{
		if(weather.equals("Mist or Fog"))
		{
			return new Color(222, 222, 222);
		}
		else if(weather.equals("Dust") || weather.equals("Tornado"))
		{
			return new Color(125, 85, 56);
		}
		
		return new Color(138, 138, 138);
	}
	
	public void draw()
	{
		g.noStroke();
		
		//back buildings
		g.fill(214, 195, 174);
		g.rect(0, 170, 140, 330);
		g.rect(145, 300, 100, 200);
		g.rect(255, 240, 170, 260);
		g.rect(430, 100, 110, 400);
		g.rect(550, 270, 130, 230);
		g.rect(685, 200, 170, 300);
		
		//back windows
		g.fill(237, 230, 171);
		g.rect(15, 190, 105, 50);
		g.rect(15, 260, 105, 50);
		g.rect(15, 330, 105, 50);
		g.rect(15, 400, 105, 50);
		g.rect(15, 470, 105, 50);
		
		g.rect(155, 320, 80, 50);
		g.rect(155, 400, 80, 50);
		g.rect(155, 480, 80, 50);
		
		g.rect(270, 260, 140, 50);
		g.rect(270, 330, 140, 50);
		g.rect(270, 400, 140, 50);
		g.rect(270, 470, 140, 50);
		
		g.rect(445, 120, 80, 50);
		g.rect(445, 200, 80, 50);
		g.rect(445, 280, 80, 50);
		g.rect(445, 360, 80, 50);
		g.rect(445, 440, 80, 50);
		
		g.rect(565, 290, 100, 50);
		g.rect(565, 360, 100, 50);
		g.rect(565, 430, 100, 50);
		
		g.rect(700, 220, 95, 50);
		g.rect(700, 290, 95, 50);
		g.rect(700, 360, 95, 50);
		g.rect(700, 430, 95, 50);
		
		
		if(type.equals("Mist or Fog"))
		{	
			Cloud.setColorAnimate(g, fog, cloudColor);
		}
		else if(type.equals("Dust"))
		{
			for(int i = 0; i < dustOrAsh.size(); i++)
			{
				Particle s = dustOrAsh.get(i);
				g.scale(s.scale);
				g.noStroke();
				g.fill(dustColor.getRGB());
				
				s.y += 3;
				s.y %= 570;
				s.x += 1;
				s.x %= 830;
				
				g.ellipse(s.x,  s.y,  50, 50);
				g.scale(1/s.scale);
			}
		}
		else if(type.equals("Ash"))
		{
			for(int i = 0; i < dustOrAsh.size(); i++)
			{
				Particle s = dustOrAsh.get(i);
				g.scale(s.scale);
				g.noStroke();
				g.fill(ashColor.getRGB());
				
				s.y += 3;
				s.y %= 570;
				s.x += 1;
				s.x %= 830;
				
				g.ellipse(s.x,  s.y,  50, 50);
				g.scale(1/s.scale);
			}
		}
		else
		{
			g.fill(tornado.torColor.getRGB());
			g.triangle(tornado.x -200, 0, tornado.x -100, 500, tornado.x, 0);
			g.fill(tornado.stripeColor.getRGB());
			g.quad(tornado.x -170, 20,tornado.x -150, 40, tornado.x -160, 55, tornado.x -180, 45);
			g.quad(tornado.x -60, 120,tornado.x -40, 140, tornado.x -50, 175, tornado.x -70, 145);
			g.quad(tornado.x -115, 270,tornado.x -95, 290, tornado.x -105, 310, tornado.x -125, 295);
			tornado.x += 3;
			tornado.x %= 1000;
		}
	}
	
}