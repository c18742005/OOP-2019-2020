package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		colorMode(HSB);
	}

	
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	

	public void drawPattern()
	{
		for(int x = 0; x <= 500; x+= 25)
		{
			line(250, 250, x, 0);
			line(250, 250, x, 500);
		}
		for(int y = 0; y <= 500; y+= 25)
		{
			line(250, 250, 0, y);
			line(250, 250, 500, y);
		}
	}

	public void circlePattern()
	{
		float diameter = 50;
		float radius = diameter / 2;

		for(float x = 0 + radius; x <= 500 - radius; x += diameter)
		{
			ellipse(x, 250, diameter, diameter);
		}
	}

	public void rectanglePattern()
	{
		float height = 500;
		float width = height / 10;
		int color = 0;

		for(float x = 0; x <= 500 - width; x += width)
		{
			noStroke();
			fill(color, 255, 255);
			color += 18;
			rect(x, 0, width, height);
		}
	}

	public void draw()
	{	
		background(200);
		stroke(0);
		rectanglePattern();
		/*
		line(10, 10, 100, 10);
		line(10, 20, 100, 20);
		line(10, 30, 100, 30);
		line(10, 40, 100, 40);

		for(int y = 10 ; y <= 40 ; y += 10)
		{
			line(200, y, 300, y);
		}

		int yy = 10;
		while(yy <= 40)
		{
			line(300, yy, 400, yy);
			yy += 10;
		}
		*/
	}
}
