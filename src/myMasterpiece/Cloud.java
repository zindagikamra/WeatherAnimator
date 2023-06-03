package myMasterpiece;


import java.awt.Color;
import java.util.ArrayList;
import processing.core.PGraphics;


public class Cloud {
	
	public int x;
	public int y;
	public int speed;
	public float scale;
	public int colorNum = (int)(Math.random() * 151 + 100);
	public Color color = new Color(colorNum, colorNum, colorNum);
	
	public Cloud()
	{
		x = (int) (Math.random() * 500);
		y = (int) (Math.random() * 501);
		speed = (int) (Math.random() * 3 + 1);

		if(speed == 1)
		{
			scale = .75f;
		}
		else if(speed == 2)
		{
			scale = 1;
		}
		else
		{
			scale =  1.3f;
		}
	}
	
	public static void animate(PGraphics g, ArrayList<Cloud> clouds)
	{
		for (int i=0; i<clouds.size();i++)
		{
			Cloud c = clouds.get(i);
			
			g.scale(c.scale);
			g.noStroke();
			g.fill(c.color.getRGB());
			c.x += c.speed;
			c.x %= 900;
			
			g.ellipse(c.x, c.y,50, 50);
			g.ellipse(c.x + 25, c.y + 25, 60, 60);
			g.ellipse(c.x + 20, c.y - 25, 50, 50);
			g.ellipse(c.x + 60, c.y, 150, 55);
			g.ellipse(c.x + 60, c.y + 30, 60, 55);
			g.ellipse(c.x + 60, c.y - 25, 80, 80);
			g.ellipse(c.x + 100, c.y - 20, 50, 50);
			g.ellipse(c.x + 100, c.y + 10, 70, 60);
			g.ellipse(c.x + 125, c.y, 50, 50);
			g.scale(1.0f/c.scale);
		}
	}
		
	public static void setColorAnimate(PGraphics g, ArrayList<Cloud> clouds, Color color)
	{
		for (int i=0; i<clouds.size();i++)
		{
			Cloud c = clouds.get(i);
				
			g.scale(c.scale);
			g.noStroke();
			g.fill(color.getRGB());
			c.x += c.speed;
			c.x %= 900;
				
			g.ellipse(c.x, c.y,50, 50);
			g.ellipse(c.x + 25, c.y + 25, 60, 60);
			g.ellipse(c.x + 20, c.y - 25, 50, 50);
			g.ellipse(c.x + 60, c.y, 150, 55);
			g.ellipse(c.x + 60, c.y + 30, 60, 55);
			g.ellipse(c.x + 60, c.y - 25, 80, 80);
			g.ellipse(c.x + 100, c.y - 20, 50, 50);
			g.ellipse(c.x + 100, c.y + 10, 70, 60);
			g.ellipse(c.x + 125, c.y, 50, 50);
			g.scale(1.0f/c.scale);
		}
	}

}