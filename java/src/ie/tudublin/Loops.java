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
		
	}

	public void loops1()
	{
		stroke(255); // make lines white
		int numLines = (int) (30 * (mouseX / (float) width)) ; // number of lines is equal to 30 times the mouse X position divided by widht of the screen
		float gap = width / (float) numLines; // distancce between lines is width of screen divided by the number of lines

		// loop to draw the lines
		for(int i = 0 ; i <= numLines ; i ++)
		{
			float x = i * gap;
			line(x, 0, width - x, height);
			line(0, x, width, height -x);
		} // end for loop
	}

	float offset = 0;

	public void loops2()
	{
		int numCircles  = (int) (20 * (mouseX / (float) width)) ; // make num of circles equal to 20 times the mouse X position divided by the width of the screen
		
		float w = width / (float) numCircles; //width of each circle is width of screen divided by num of circles
		float radius = w / 2.0f; // radius of circle is half widht of circle

		colorMode(HSB);
		float cGap = 255 / (float) (numCircles * numCircles); 
		noStroke();

		// loop to draw circles and change colours
		for(int j = 0 ; j < numCircles ; j ++)
		{		
			for(int i = 0 ; i < numCircles ; i ++)
			{
				float x = radius + (i * w);
				float y = radius + (j * w);
				float c = (cGap * i * j + offset) % 255; 
				fill(c, 255, 255);
				ellipse(x, y, w, w);
			}
		}
		offset += mouseY / 250.0f;
	}

	public void loops3()
	{
		float gap = width * 0.1f; 
		float halfGap = gap / 2.0f;
		colorMode(RGB);
		stroke(0, 255, 0); // make lines green
		textAlign(CENTER, CENTER); // align text

		// loop to draw grid
		for(int i = -5 ; i <=5 ; i ++)
		{
			float x = map(i, -5, 5, gap, width -gap); // remaps a number from one range to another			
			line(x, gap, x, height - gap); // draw vertical line
			line(gap, x, width - gap, x); // draw horizontal line
			fill(255); // make text white
			text(i, x, halfGap); // write text hoizontally across the screen
			text(i, halfGap, x); // write text vertically down the screen
		}
	}

	
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	


	public void draw()
	{	
		background(0);		
		colorMode(HSB);
		//loops1();

		loops2();

		//loops3();
	}
}