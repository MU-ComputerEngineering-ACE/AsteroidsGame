import greenfoot.*;
import greenfoot.core.WorldHandler;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;
/**
 * This class is for all special settings of the mouse. (Changing image, scrolling)
 * 
 * @author (Moritz L. (alias Busch2207))
 * @version (2.0.1)
 */
public abstract class Mouse
{
    private static GreenfootImage MouseImage=new GreenfootImage(1,1);
    private static Point MouseClick=new Point(0,0);
    private static ScrollingListener scroll=new ScrollingListener();  
    private static int Scroll = 0;

    private Mouse()
    {}

    /** sets the scroll Count to 0 */
    public static void resetScroll()
    {
        scroll.resetScroll();
    }

    /** set the Mouse Image (the given Image will be scaled to 32, 32.) */
    public static void setImage(GreenfootImage image, int XClick, int yClick)
    {
        MouseImage = image;
        MouseClick = new Point(XClick,yClick);
        newImage(MouseImage,MouseClick);
    }

    /** Updates the MouseImage (usually done automatically) */
    public static void updateImage()
    {
        newImage(MouseImage,MouseClick);
    }

    /** sets the mouseimage to the given 'standard' image */
    public static void setStandardImage(int WhichOne)
    {
        JPanel Panel = WorldHandler.getInstance().getWorldCanvas();
        Cursor Cursor;
        Cursor = new Cursor(WhichOne);
        Panel.setCursor(Cursor);
    }

    /** sets the mouseimage to the 'normal' image */
    public static void setStandardImage()
    {
        setStandardImage(0);
    }

    /** returns the scroll count since the last Time, it was set to 0 */
    public static int getScroll()
    {
        return scroll.getScroll();
    }

    private static void newImage(GreenfootImage image,Point CursorPoint)
    {
        JPanel Panel = WorldHandler.getInstance().getWorldCanvas();
        Cursor Cursor;
        Toolkit Tk = Toolkit.getDefaultToolkit();
        Cursor = Tk.createCustomCursor(image.getAwtImage(),CursorPoint,"Somehow");
        Panel.setCursor(Cursor);
    }
}

class ScrollingListener implements MouseWheelListener
{
    int scroll = 0;
    boolean Called = false;

    public ScrollingListener()
    {
        WorldHandler.getInstance().getWorldCanvas().addMouseWheelListener(this);
    }

    public synchronized void mouseWheelMoved(MouseWheelEvent MWE)
    {
        scroll += MWE.getWheelRotation();
        MWE.consume();
    }

    public void resetScroll()
    {
        scroll=0;
    }

    public synchronized int getScroll()
    {
        return scroll;
    }
}