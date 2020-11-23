import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidWorld extends World
{

    private GreenfootImage MouseImage;
    private Counter scoreBoard;
    private Counter level=new Counter("Level: ");
    private Counter day=new Counter("Day: ");
    private int enemySpawnRate = 30;
    private int enemySpeed =2;
    private int nextLevel = 1000;
    public  int score = 0;
    public int dayscore = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public AsteroidWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050,600, 1,false);
        level.setValue(1);
        
        
        
        prepare();
    }

    public int getScore()
    {
        return score;
    }

    private void increaseLevel() 
    {
        
        score=scoreBoard.getValue();
        if( score > nextLevel )
        {
            level.setValue(level.getValue() + 1);
            enemySpawnRate += 2;
            enemySpeed++;
            nextLevel += 1000;

        }

    }

    public void endGame()
    {
        BgMusic.stop();
        AsteroidGameOverWorld go = new AsteroidGameOverWorld(score);

        Greenfoot.setWorld(go);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        BgMusic.newsong();
        Avatar avatar = new Avatar();
        addObject(avatar,189,95);
        scoreBoard = new Counter("Score: ");

        addObject(scoreBoard, getWidth()/10 - 25, 20);
        addObject(level,9*getWidth()/10 + 25, 20);
        
        MouseImage=new GreenfootImage(32,32);
        MouseImage.setColor(new Color(0,0,0,0));

    }
    
    public void act()
    {
        // Randomly add enemies to the world
        Mouse.setImage(MouseImage,0,0);
        BgMusic.play();
        BgMusic.setVolume();
        if( Greenfoot.getRandomNumber(1000) < enemySpawnRate )
        {

            Enemy e = new Enemy();
            e.setSpeed(enemySpeed);
            addObject(e, getWidth()+100, Greenfoot.getRandomNumber(getWidth()-10)+10);
            e.touching();

            scoreBoard.setValue(scoreBoard.getValue() + 10);
        }

        increaseLevel();

    }

}
