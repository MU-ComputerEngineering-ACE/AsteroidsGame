import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class AsteroidScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidScoreBoard extends World
{
    private GreenfootSound bkgMusic;
    private int ScoreWidth = 1050;
    private int ScoreHeight = 600;
    private Counter2 scoreBoard = new Counter2(" ");

    /**
     * Constructor for objects of class AsteroidScoreBoard.
     * 
     */
    public AsteroidScoreBoard(final int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050,600, 1); 
        GreenfootImage image = getBackground();
        image.scale(ScoreWidth,ScoreHeight);
        setBackground(image);
        scoreBoard.setValue(score);
        addObject(new ScoreBoard(ScoreWidth, ScoreHeight), getWidth() / 2, getHeight() / 2);
        addObject(new Actor() { { setImage(new GreenfootImage("Press Enter To Play Again", 30,Color.BLACK, new Color(0,0,0,0))); } },9*getWidth()/10 - 100, 9*getHeight()/10);
        addObject(new Actor() { { setImage(new GreenfootImage("Press Backspace to go back", 30,Color.BLACK, new Color(0,0,0,0))); } },9*getWidth()/10 - 100, 9*getHeight()/10+30);
        bkgMusic= new GreenfootSound("Matrix & Futurebound - Control (ft. Max Marshall).mp3");
        bkgMusic.playLoop();
    }

    public void act()
    {

        if( Greenfoot.isKeyDown("enter"))
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
