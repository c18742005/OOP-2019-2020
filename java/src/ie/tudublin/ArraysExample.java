package ie.tudublin;

import java.util.Arrays; // import arrays class which is used for manipulating arrays
import java.util.Collections; // import Collections class which is used to opeerate on Collections

import processing.core.PApplet;

public class ArraysExample extends PApplet
{	

	//float[] rainFall = new float[12]; // allocates memory for 12 floats to an array
	float[] rainFall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58}; // create an array named rainfall which holds 12 floats
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}; // create an array months which holds 12 Strings

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		// loop to print the month and rainfall to standard output
		for(int i = 0 ; i < rainFall.length; i ++)
		{
			println(months[i] + "\t" + rainFall[i]);
		}

		// loop to print all rainfall values to standard output
		for(float f:rainFall)
		{
			println(f);
		}

		// loop to print all month values to standard output
		for(String s:months)
		{
			println(s);
		}

		// loop to find month with lowest rainfall 
		int minIndex = 0;
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			// if current pos in array is less than the current min value make current pos new min value
			if (rainFall[i] < rainFall[minIndex])
			{
				minIndex = i;
			}
		} 

		// print month with lowest rainfall to standard output
		println(months[minIndex] + " had the minimum rainfall of " + rainFall[minIndex]);
		
		// loop to find month with most rainfall 
		int maxIndex = 0;
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			// if current pos in array is more than the current ax value make current pos new max value
			if (rainFall[i] > rainFall[maxIndex])
			{
				maxIndex = i;
			}
		}

		// print month with highest rainfall to standard output
		println(months[maxIndex] + " had the maximum rainfall of " + rainFall[maxIndex]);

		// You can also calculate the minimum and max of an arry this way:
		// Note the array is of type Float not float
		// Float are objects float is a primitive type
		Float[] floatArray = {10.0f, 5.0f, 20.0f};
		float min = Collections.min(Arrays.asList(floatArray)); 
        float max = Collections.max(Arrays.asList(floatArray));
	}

	// method to draw a barchart which shows the amount of rainfall each month
	void drawBarChart()
	{
		float w = width / (float) rainFall.length; // variable to store the width of each bar in the barchart
		float cGap = 255 / (float) rainFall.length; // variable to decide the color of each bar in the chart

		noStroke(); // dont outline each bar in the chart
		colorMode(HSB); // decide on color mode

		// loop to create a bar for each month of the chart
		for(int i = 0 ; i < rainFall.length ; i ++)
		{
			float x = i * w; // variable to outline where each bar will begin on the x axis

			fill(i * cGap, 255, 255); // decide on the color for each bar
			rect(x, height, w, -rainFall[i]); // draw a bar 
		}
	} // end drawBarChart()

	// method to check for a key press
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	} // end keyPressed()

	// method to draw to the screen, called 60 xps
	public void draw()
	{	
		background(0);	// make background black	
		colorMode(HSB);

		// call method to draw the bar chart to screen
		drawBarChart();
	} // end draw()
} // end class ArraysExample