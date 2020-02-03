package ie.tudublin;

public class Main
{

    public void helloProcessing()
	{
        String[] a = {"MAIN"};
        // create new sketch called HelloProcessing
        processing.core.PApplet.runSketch( a, new HelloProcessing());
	}
    public static void main(String[] arg)
    {
        System.out.println("Hello world!");

        Animal misty = new Dog(); // Polymorphism
        misty.setName("Misty");
        System.out.println(misty.getName());  
        misty.speak();  
        Cat topcat = new Cat();
        topcat.speak();

        Main main = new Main();
		main.helloProcessing();
        
        for(int i = topcat.getNumLives(); i >= 0; i-- )
        {
            topcat.kill();
        }
    }
}