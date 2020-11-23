import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class AsteroidCredits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidCredits extends World
{
    private GreenfootSound bkgMusic;
    private int ImageWidth = 1050;
    private int ImageHeight = 600;
    UserInfo myInfo1 = UserInfo.getMyInfo();
    public static int score1;
    private Counter3 scoreBoard = new Counter3(" ");
    /**
     * Constructor for objects of class AsteroidCredits.
     * 
     */
    public AsteroidCredits(final int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(1050,600, 1);
        GreenfootImage image = getBackground();
        image.scale(ImageWidth,ImageHeight);
        setBackground(image);
        scoreBoard.setValue(score);
        addObject(new Actor() { { setImage(new GreenfootImage("Press Enter To Play Again", 30,Color.BLACK, new Color(0,0,0,0))); } },9*getWidth()/10 - 100, 9*getHeight()/10);
        addObject(new Actor() { { setImage(new GreenfootImage("Press Backspace to go back", 30,Color.BLACK, new Color(0,0,0,0))); } },9*getWidth()/10 - 100, 9*getHeight()/10+30);
        bkgMusic= new GreenfootSound("The Score - Unstoppable (Audio) (192  kbps).mp3");
        bkgMusic.setVolume(75);
        bkgMusic.playLoop();
    }
    public void putScore(int score)
    {
        score1=score;
    }
    public void act()
    {
        // Start the game if the user clicks the mouse anywhere
        if( Greenfoot.isKeyDown("enter")  )
        {
            bkgMusic.stop();
            AsteroidWorld world = new AsteroidWorld();
            Greenfoot.setWorld(world);
        }
        if( Greenfoot.isKeyDown("backspace")  )
        {
            bkgMusic.stop();
            
            AsteroidGameOverWorld w = new AsteroidGameOverWorld(scoreBoard.getValue());
            
            Greenfoot.setWorld(w);
        }
    }
}
