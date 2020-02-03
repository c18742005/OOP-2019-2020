package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
    float playerX = 250;
    float playerY = 490;
    float playerWidth = 20;

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
    }

    void drawPlayer(float x, float y, float w)
    {
        float playerH = w * 0.5f;
        stroke(255, 255, 255);
        line(x - (0.5f * w), y, x + (0.5f * w), y); // bottom line
        line(x - (0.5f * w), y, x - (0.5f * w), y - playerH);
        line(x + (0.5f * w), y, x + (0.5f * w), y - playerH);
        line(x - (0.5f * w), y - playerH, x + (0.5f * w), y - playerH); //top line
        line((x - (0.5f * w)) + (w * 0.5f), y - (playerH + (0.5f * playerH)), (x - (0.5f * w)) + (w * 0.5f), y - (playerH * 0.5f)); // gun line
    }

    public void keyPressed()
	{
		if (keyCode == LEFT)
		{
            if(playerX >= 10)
            {
                playerX = playerX - 5;
            }
		}
		if (keyCode == RIGHT)
		{
            if(playerX <= 490)
            {
                playerX = playerX + 5;
            }
		}
		if (key == ' ')
		{
			drawLaser(playerX, playerY, playerWidth);
		}
    }
    
    void drawBug(float x, float y, float w)
    {
        fill(0, 0, 0);
        triangle(x, y, x-10, y + 10, x + 10, y + 10);
        triangle(x + 10, y + 10, x + 5, y + 10, x + 7, y + 20);
        triangle(x - 10, y + 10, x - 5, y + 10, x - 7, y + 20);
    }

    void drawLaser(float x, float y, float w)
    {
        float playerH = w * 0.5f;
        line((x - (0.5f * w)) + (w * 0.5f), y - (playerH * 0.5f), (x - (0.5f * w)) + (w * 0.5f), 0); // gun line
    }
}