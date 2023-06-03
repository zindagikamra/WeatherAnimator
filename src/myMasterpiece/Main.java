package myMasterpiece;


import java.util.*;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.data.JSONObject;

import java.awt.Color;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

// Simplified docs: https://processing.org/reference/
// JavaDocs: http://processing.github.io/processing-javadocs/core/

public class Main extends PApplet
{
	// Declare any private fields you need to help keep track of
	// stuff while your masterpiece animates itself
	private WeatherCondition weatherCondition = null;
	private String weather;
	private int currentWeather;
	private Color textColor = new Color(255,255,255);
	private String location;

	public static void main(String[] args) 
	{
		// This string MUST match your package and class name
		PApplet.main("myMasterpiece.Main");

		// DO NOT ADD ANYTHING ELSE TO THIS MAIN METHOD
		//
		// Instead, the following methods are called, in this order:
		//
		// settings -- this determines the size of the window
		//
		// setup -- any initialization should be put here
		//
		// draw (repeatedly) -- this is called over and over again
		//						in a loop.  Each call is a like a single
		//						frame in the animation.
	}

	// This method determines the size of the window and does nothing else 
	public void settings() 
	{
		// These numbers decide how big the window is.
		// You can change these if you don't like the size!
		size(800, 500);
	}
	
	// Do any one-time initialization here, like initializing fields
	public void setup()
	{
		
		Scanner console = new Scanner(System.in);
		System.out.print("Enter a location to find out about the weather: ");
		location = console.nextLine();
		// Read line
		currentWeather	= weather(location);
		// For demo or tests
		//currentWeather = 701; 
		System.out.println(currentWeather);
		
		
		if(currentWeather == 800)
		{
			weatherCondition = new Sunny(g);			
		}
		else if(currentWeather / 100 == 8 || currentWeather == 771)
		{
			weatherCondition = new Cloudy(g, currentWeather);
		}
		else if(currentWeather / 100 == 2)
		{
			weatherCondition = new ThunderStorm(g);
		}		
		else if(currentWeather / 100 == 3)
		{
			weatherCondition = new Drizzle(g);
		}
		else if(currentWeather / 100 == 5)
		{
			weatherCondition = new Raining(g);
		}
		else if(currentWeather / 100 == 6)
		{
			weatherCondition = new Snowing(g);
		}
		else
		{
			weatherCondition = new Atmosphere(g, currentWeather);
			textColor = new Color(0, 0, 0);
		}
		
		weather = weatherCondition.getWeatherDescription();
		//System.out.println(weather);
	
	}
		//Setup of stuff for the weather
		

	// This gets called over and over again, once for each animation frame
	public void draw() 
	{
		// Typically, you'll do something like this to clear the
		// screen before drawing your frame.  Feel free to change
		// the color.
		g.background(weatherCondition.getBackground(weather).getRGB());
		
		// Then call methods on g to draw stuff.  This is just an example,
		// feel free to remove.  See the links at the top of this file
		// for documentation on the drawing methods  can call on g
		weatherCondition.draw();
		
		
		g.textSize(30);
		g.fill(textColor.getRGB());
		g.text("Location: " + location, 10, 450);
		g.text("Current Weather: " + weather, 10, 480);
		
	}
	
	
	public int weather(String loc)
	{
		int weatherCondition = 0;
		try {
			URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+loc+",us&appid=f9272da5153d6239144a7645e99a96b1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			JSONObject json = new JSONObject(new InputStreamReader(conn.getInputStream()));
			JSONObject returnedWeather = (JSONObject) json.getJSONArray("weather").get(0);
			int condition = returnedWeather.getInt("id");
			weatherCondition += condition;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return weatherCondition;
	}
}