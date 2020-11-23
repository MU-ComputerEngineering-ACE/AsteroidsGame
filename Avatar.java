import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Avatar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Avatar extends Actor
{
    private int userX,userY;
    
    public Avatar()
    {
        this(100,50);
        
    }

    /**
     * Act - do whatever the Avatar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        followMouse();
        checkForCollisions();
    }

    public Avatar(int width, int height)
    {
        GreenfootImage image = getImage();
        image.scale(width,height);
        setImage(image);
    }

    private void checkForCollisions() {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        
        if(enemy != null ) {
            
            AsteroidWorld world = (AsteroidWorld) getWorld();
            world.endGame();
        }
        
        
    }

    private void followMouse()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        
        if( mi != null )
        {
            
                setLocation(mi.getX(), mi.getY());
            
        }
    }
}
