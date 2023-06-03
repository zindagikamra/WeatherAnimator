package myMasterpiece;


import java.awt.Color;

public class Particle {
	
	public int x;
	public int y;
	public int speed;
	public float scale;
	
	
	public Particle()
	{
		x = (int) (Math.random() * 800);
		y = (int) (Math.random() * 400);
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

}