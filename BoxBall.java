import java.awt.*;
import java.awt.geom.*;
/**
 * "This method draws a rectangle (the box) 
 * on screen and between five and thirty balls that move inside the box."
 *
 * @author Andrew Riganati
 * @version 3/22/2019
 */
public class BoxBall
{
    // instance variables - replace the example below with your own
    private Color color;
    private int diameter;
    private int xspeed;
    private int yspeed;
    private int yPosition;
    private int xPosition;
    private Canvas canvas;
    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall()
    {
        // initialise instance variables
        
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    
     public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
        
    }


    
    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }
    
    
    
    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}


