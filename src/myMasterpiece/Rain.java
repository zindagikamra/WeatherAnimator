package myMasterpiece;
import java.awt.Color;
import java.util.ArrayList;

import processing.core.*;

public class Rain {
	
	public int x = (int) (Math.random() * 800);
	public int y  = (int) (Math.random() * 401);
	public float scale;
	public int speed = (int) (Math.random()* 2 + 3);
	
	
	public Rain()
	{
		
		if(speed == 3)
		{
			scale = 1f;
		}
		else if(speed == 4)
		{
			scale = 1.2f;
		}
		else
		{
			scale = 2.5f;
		}
	}
	
	public static void animate(PGraphics g, ArrayList<Rain> rainUse, Color blue)
	{
		for(int i = 0; i < rainUse.size(); i++)
		{
			Rain r = rainUse.get(i);
			
			g.scale(r.scale);
			g.noStroke();
			g.fill(blue.getRGB());
			r.y += r.speed;
			r.y %= 600;
			
			g.ellipse(r.x, r.y, 50, 50);
			g.triangle(r.x - 25, r.y - 4,r.x +25, r.y-4, r.x, r.y - 60);
			g.scale(1.0f/r.scale);
		}
	}
	
		
}