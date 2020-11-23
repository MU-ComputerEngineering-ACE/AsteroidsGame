import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class AsteroidGameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidGameOverWorld extends World
{
    private Counter1 scoreBoard = new Counter1(" ");
    private GreenfootSound bkgMusic;
    private int ImageWidth = 1050;
    private int ImageHeight = 600;

    /**
     * Constructor for objects of class AsteroidGameOverWorld.
     * 
     */
    public  AsteroidGameOverWorld(final int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050,600, 1); 

        GreenfootImage image = getBackground();
        image.scale(ImageWidth,ImageHeight);
        setBackground(image);

        scoreBoard.setValue(score);
        bkgMusic= new GreenfootSound("death.wav");
        bkgMusic.play();
        UserInfo myInfo = UserInfo.getMyInfo();
        
        
        addObject(new Actor() { { setImage(new GreenfootImage("Final Score    "+score, 30,Color.BLUE, new Color(0,0,0,0))); } }, getWidth()/2, getHeight()/2 + 50);
        addObject(new Actor() { { setImage(new GreenfootImage("\nS = ScoreBoard\nC=Credits", 30,Color.BLACK, new Color(0,0,0,0))); } },9*getWidth()/10, 9*getHeight()/10);
        if (UserInfo.isStorageAvailable()) {

            if(myInfo == null)
            {
                System.out.println("Not Signed in");
            }
            else if (score > myInfo.getScore()) {
                myInfo.setScore(score);
                myInfo.store();  // write back to server
            } 
        }

    }

    public void act() {
        // Restart the game if the user clicks the mouse anywhere
        if( Greenfoot.isKeyDown("c") ) {
            bkgMusic.stop();

            AsteroidCredits world = new AsteroidCredits(scoreBoard.getValue());
            Greenfoot.setWorld(world);
        }

        if( Greenfoot.isKeyDown("s") ) {
            bkgMusic.stop();
            AsteroidScoreBoard world = new AsteroidScoreBoard(scoreBoard.getValue());
            Greenfoot.setWorld(world);
        }
        if( Greenfoot.mouseClicked(this)) {
            bkgMusic.stop();
            AsteroidWorld world = new AsteroidWorld();
            Greenfoot.setWorld(world);
        }
    }
}
