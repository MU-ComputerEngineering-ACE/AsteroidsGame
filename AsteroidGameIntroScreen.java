import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AsteroidGameIntroScene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidGameIntroScreen extends World
{
    private int ImageWidth = 1050;
    private int ImageHeight = 600;
    /**
     * Constructor for objects of class AsteroidGameIntroScene.
     * 
     */
    public AsteroidGameIntroScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050,600, 1); 
        GreenfootImage image = getBackground();
        image.scale(ImageWidth,ImageHeight);
        setBackground(image);

        prepare();
    }

    public void act() {
        // Start the game if the user clicks the mouse anywhere
        if( Greenfoot.mouseClicked(this)  ) {
            AsteroidWorld world = new AsteroidWorld();
            Greenfoot.setWorld(world);
        }
    }

    /**
    * Prepare the world for the start of the program. That is: create the initial
    * objects and add them to the world.
    */
    private void prepare()
    {
    }
}
