import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends SmoothMover
{
    private int speed=1;
    
    
    public Enemy()
    {
        this(100,40);
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        setLocation(getExactX()-speed, getExactY());
        checkRemove();
    }
    public int x()
    {
        int varx=(int)(getExactX());
        return(varx);
    }
    public int y()
    {
        int vary=(int)(getExactY());
        return(vary);
    }
    public Enemy(int width, int height)
    {
        GreenfootImage image = getImage();
        image.scale(width,height);
        setImage(image);
    }
    
    public void setSpeed(int s)
    {
        speed=s;
    }

    private void checkRemove() {
        World w = getWorld();
        if( getY() > (w.getHeight()-20)||getY() < 20)
        {
            w.removeObject(this);
        }
    }

    public void touching()
    {
        World w = getWorld();
        if (isTouching(Enemy.class))
        {
            w.removeObject(this);
        }
    }
}
