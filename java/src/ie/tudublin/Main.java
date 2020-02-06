package ie.tudublin;

public class Main
{
    // run new bugZap game
    public void bugZap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
	} // end bugZap()
    public static void main(String[] arg)
    {
        Main main = new Main();
		main.bugZap();   
    } // end main()
} // end Main class