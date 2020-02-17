package ie.tudublin;

// Hello from Jacob

import processing.core.PApplet;

public class Arrays extends PApplet
{	

	//float[] rainFall = new float[12]; 
	float[] rainFall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58}; // create an array for rain fall
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}; // create an array for months

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		// loop to print the amount of rainfall for each month
		for(int i = 0 ; i < rainFall.length; i ++)
		{
			println(months[i] + "\t" + rainFall[i]);
		}

		// for loop to print the values in the rainfall array
		for(float f:rainFall)
		{
			println(f);
		}

		// for loop to print the values in the months array
		for(String s:months)
		{
			println(s);
		}
 
		int minIndex = 0; // min value is currently 0
		// loop to find the month with the lowest rainfall
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			// if the rainfall in the current array variable is less than the lowest rainfall variable then make the current array value the new minIndex
			if (rainFall[i] < rainFall[minIndex])
			{
				minIndex = i;
			}
		}

		// print month with lowest rainfall
		println(months[minIndex] + " had the minimum rainfall of " + rainFall[minIndex]); 
		
		int maxIndex = 0;  // max index is currently 0

		// loop to find the month with the highest rainfall 
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			// if the rainfall in the current array variable is more than the highest rainfall variable then make the current array value the new maxIndex
			if (rainFall[i] > rainFall[maxIndex])
			{
				maxIndex = i;
			}
		}
		// print month with the max rainfall
		println(months[maxIndex] + " had the maximum rainfall of " + rainFall[maxIndex]);
	}

	// method to draw the barchart of month and rainfall
	void drawBarChart()
	{
		float w = width / (float) rainFall.length; // get width of each bar
		float cGap = 255 / (float) rainFall.length; // get the difference of colour between each bar
		noStroke(); // make bars have no outline
		colorMode(HSB);

		// loop to draw each bar of the bar chart
		for(int i = 0 ; i < rainFall.length ; i ++)
		{
			float x = i * w;
			fill(i * cGap, 255, 255); // select the colour for each bar
			rect(x, height, w, -rainFall[i]); // draw a square which is a bar
		}
	}

	void test()
	{
		
	}

	

	float offset = 0;

	
	
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	

	// method called 60 times per sec 
	public void draw()
	{	
		background(0);		
		colorMode(HSB);	

		drawBarChart();
	}
}
