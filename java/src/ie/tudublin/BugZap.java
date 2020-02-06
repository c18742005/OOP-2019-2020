package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{	
	// edit the settings of the applet
	public void settings()
	{
		size(500, 500); // make screensize 500w x 500h
	} // end settings()

	// sets up any options or variables of the applet
	public void setup() {
		reset(); // call reset when setting up applet
	} // end setup()

	// Player Variables
	float playerX, playerY; 	// used to control players pos on x and y axis
	float playerSpeed = 5; 		// used to control players speed
	float playerWidth = 40; 	// tells us the width of the player character
	float halfPlayerWidth = playerWidth / 2;	// gives us half the players width
	int playerScore;
	
	// Bug Variables
	float bugX, bugY;			// used to control bugs pos on x and y axis
	float bugWidth = 30;		// tells us the width of the bug character
	float halfBugWidth = bugWidth / 2;	// gives us half the bugs width

	// resets the player and bugs variables at the beginning of the game
	void reset()
	{
		resetBug(); 			// reset bug variables
		playerX = width / 2;	// place player in center of screen
		playerY = height - 50;	// place player 50 pixels from the bottom of the screen
		playerScore = 0; 				// set player score equal to 0
	} // end reset()

	// reset bug variables at start of game
	void resetBug()
	{
		bugX = random(halfBugWidth, width - halfBugWidth); // place bug at random x position without it being offscreen
		bugY = 50; // place bug 50 pixels from top of screen
	} // end resetBug()

	// draw the bug character
	void drawBug(float x, float y)
	{
		stroke(255); // set colour of bug
		float saucerHeight = bugWidth * 0.7f; // set height og bug to be 70% of the width

		// Draw the bug
		line(x, y - saucerHeight, x - halfBugWidth, y);
		line(x, y - saucerHeight, x +  halfBugWidth, y);		
		line(x - halfBugWidth, y, x - halfBugWidth, y);
		line(x - halfBugWidth, y, x + halfBugWidth, y);

		// draw bugs feet
		float feet = bugWidth * 0.1f;
		line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
		line(x  + feet, y, x + halfBugWidth, y + halfBugWidth);

		feet = bugWidth * 0.3f;
		line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
		line(x  + feet, y, x + halfBugWidth, y + halfBugWidth);

		// draw bugs eyes
		float eyes  = bugWidth * 0.1f;
		line(x - eyes, y - eyes, x - eyes, y - eyes * 2f);
		line(x + eyes, y - eyes, x + eyes, y - eyes * 2f);
	} // end drawBug()

	// draw a player character to the screen
	void drawPlayer(float x, float y, float w)
	{
		stroke(255); // choose the colour of the player
		float playerHeight = w / 2; // make player height half the width
		
		// Draw player character
		line(x - halfPlayerWidth, y + playerHeight, x + halfPlayerWidth, y + playerHeight);
		line(x - halfPlayerWidth, y + playerHeight, x - halfPlayerWidth, y + playerHeight * 0.5f);
		line(x + halfPlayerWidth, y + playerHeight, x + halfPlayerWidth, y + playerHeight * 0.5f);
		line(x - halfPlayerWidth, y + playerHeight * 0.5f, x - (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f);
		line(x + halfPlayerWidth, y + playerHeight * 0.5f, x + (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f);
		line(x - (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f, x + (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f);
		line(x, y, x, y + playerHeight * 0.3f); 
	} //end drawPlayer

	// what happens when a key is pressed
	public void keyPressed()
	{
		// if left key is pressed move player left
		if (keyCode == LEFT)
		{
			// ensure player icon does not go off screen
			if (playerX > halfPlayerWidth)
			{
				playerX -= playerSpeed;
			} // end if
		} //end if

		// if right key is pressed move player right
		if (keyCode == RIGHT)
		{
			// ensure player icon does not go off screen
			if (playerX < width - halfPlayerWidth)
			{
				playerX += playerSpeed;
			} // end if
		} // end if

		// if space key is pressed then fire a laser
		if (key == ' ')
		{
			stroke(255, 0, 0); // make laser red
			line(playerX, playerY, playerX, bugY); // laser begins at players gun and finishes at height of bug
			checkBugHit(playerX, bugX, bugWidth);	// check if the bug was hit
		} // end if
	} // end keyPressed()

	// check if the bug was hit
	void checkBugHit(float pX, float bX, float bW)
	{
		// check if bug is hit by comparing player x axis pos to total bug x axis pos
		if(pX > bX - bW && pX < bX + bW)
		{
			playerScore += 1; // increase player score by 1
			resetBug(); // reset the bug to new position
		}
	}

	// move the bug character
	void moveBug()
	{
		// as draw() called 60 times a second ensure bug moves every second
		if ((frameCount % 60) == 0)
		{
			bugX += random(-10, +10); // move bug randomly 10 pixels right or left

			// ensure bug does not go offscreen
			if (bugX < halfBugWidth )
			{
				bugX = halfBugWidth;
			} // end if
			if (bugX + halfBugWidth > width)
			{
				bugX = width - halfBugWidth;
			} // end if

			bugY += 20; // move bug 10 pixels down the screen
		} // end if
	} // end moveBug()

	// draw the enemy and player on screen
	public void draw()
	{	
		background(0);	// make background black	
		text("Score: " + playerScore, 20, 20); // keep the players score
		drawPlayer(playerX, playerY, playerWidth);	// draw player to screen
		drawBug(bugX, bugY);	// draw bug to screen
		moveBug();	// move the bug further down the screen
	} // end draw()
} // end bugZap class