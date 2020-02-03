package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{	
	// initialise settings for applet
	public void settings()
	{
		size(500, 500); // make execution box size 500w x 500h
	}

	// call once to setup with defaults
	public void setup() {
	}

	public void draw() {
		background(255, 0, 0); // rgb red
		noStroke(); // no outlines on shapes
		fill(250, 250, 0); // fill circle yellow
		ellipse(250, 300, 400, 400); // centre x, centre y, width, height
		fill(0, 255, 255); // fill triangle turquoise
		triangle(250, 50, 50, 450, 450, 450); // x1, y1, x2, y2, x3, y3, x4, y4
		fill(255, 255, 255); // fill circle white
		ellipse(250, 250, 190, 90); // circle - centre x, centre y, width, height
		fill(0, 0, 0); // fill pupil black
		ellipse(250, 250, 50, 50);
	}

	int x = 0; // 4 bytes
	
/*	public void draw()
	{	
		
		background(0);
		noStroke();
		fill(255);
		ellipse(x, mouseY, 50, 50);		
		x ++;
	}
*/
}
