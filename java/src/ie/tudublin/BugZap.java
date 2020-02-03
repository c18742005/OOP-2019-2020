package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
    // Player Variables
    float playerX = 250;
    float playerY = 490;
    float playerWidth = 20;

    // Bug Variables
    float bugX = 250;
    float bugY = 10;
    float bugWidth = 20;

    public void settings()
    {
        size(500, 500);
    }

    public void setup(){
    }

    public void draw()
    {
        background(0, 0, 0);
        drawPlayer(playerX, playerY, playerWidth);
        drawBug(bugX, bugY, bugWidth);

        // randomly change the x coordinates of the bug
        if ((frameCount % 60) == 0)
        {
            bugX = bugX + (random(-20, 20));
        }
    }

    // method to draw the player character
    void drawPlayer(float x, float y, float w)
    {
        float playerH = w * 0.5f;
        stroke(255, 255, 255);
        line(x - (0.5f * w), y, x + (0.5f * w), y); // bottom line
        line(x - (0.5f * w), y, x - (0.5f * w), y - playerH); // left side line
        line(x + (0.5f * w), y, x + (0.5f * w), y - playerH); // right side line
        line(x - (0.5f * w), y - playerH, x + (0.5f * w), y - playerH); //top line
        line((x - (0.5f * w)) + (w * 0.5f), y - (playerH + (0.5f * playerH)), (x - (0.5f * w)) + (w * 0.5f), y - (playerH * 0.5f)); // gun line
    }

    // check if a key was pressed and do something
    public void keyPressed()
	{
        // if left key pressed move player 10 steps to left
		if (keyCode == LEFT)
		{
            if(playerX >= 10)
            {
                playerX = playerX - 5;
            }
        }
        // if right key pressed move player 10 steps to right
		if (keyCode == RIGHT)
		{
            if(playerX <= 490)
            {
                playerX = playerX + 5;
            }
        }
        // if space key pressed fire laser
		if (key == ' ')
		{
			drawLaser(playerX, playerY, playerWidth);
		}
    }
    
    // method to draw a bug character to screen 
    void drawBug(float x, float y, float w)
    {
        fill(0, 0, 0);
        triangle(x, y, x-10, y + 10, x + 10, y + 10);
        triangle(x + 10, y + 10, x + 5, y + 10, x + 7, y + 20);
        triangle(x - 10, y + 10, x - 5, y + 10, x - 7, y + 20);
    }

    // method to fire a laser on screen 
    void drawLaser(float x, float y, float w)
    {
        float playerH = w * 0.5f;

        // laser line starting at top of laser gun and extending to top of screen
        line((x - (0.5f * w)) + (w * 0.5f), y - (playerH * 0.5f), (x - (0.5f * w)) + (w * 0.5f), 0);
    }
}