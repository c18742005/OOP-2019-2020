package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
    float playerX = 250;
    float playerY = 490;
    float playerWidth = 20;

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
			playerX = playerX - 5;
		}
		if (keyCode == RIGHT)
		{
			playerX = playerX + 5;
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
		}
	}
}