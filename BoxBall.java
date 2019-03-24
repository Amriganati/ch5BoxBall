import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
import java.util.HashMap;
/**
 * "This method draws a rectangle (the box) 
 * on screen and between five and thirty balls that move inside the box."
 *
 * @author Andrew Riganati
 * @version 3/22/2019
 */
public class BoxBall
{
    private static final int DIST = 2;
    
    private Color color;
    private int diameter;
    private int xspeed;
    private int yspeed;
    private int yPosition;
    private int xPosition;
    private int boxwidth;
    private int boxheight;
    private Canvas canvas;
    private Random distRandy;
    private Random distRandx;
    private boolean bounceX;
    private boolean bounceY;
    /**
     * Constructor for objects of class BoxBall
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param drawingCanvas  the canvas to draw this ball on
     * @param distRandy the random distance integer on which y-axis ball
     * movement is determined
     * @param distRandx the random distance integer on which x-axis ball 
     * movement is determined.
     */
    
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, 
    Canvas drawingCanvas)
    {
        // initialise instance variables
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
        distRandy = new Random();
        distRandx = new Random();
        bounceX = false;
        bounceY = false;
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
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    
    public void movebb()
    {
        //remove from the current position on the canvas
        erase();
        // if the balls position is at the left of the box switch x direction
        if(xPosition == 125 )
        {
            bounceX = false;
        }
        // if the balls position is at the right of the box switch x direction
        if(xPosition == 350 )
        {
            bounceX = true;
        }
        // if the ball's y position is at the top of the box switch y direction
        if(yPosition == 125)
        {
            bounceY = false;
        }
        // if the ball's y position is at the bottom of the box switch y direction
        if(yPosition == 250)
        {
            bounceY = true;
        }
        // when the right wall has been hit start moving left in increments of -7 to -1
        while(bounceX = true)
        {
            xPosition -= distRandx.nextInt((7) + 1)- 8;
        }
        // when the left wall has been hit start moving right in increments of 1 to 7
        while(bounceX = false)
        {
            xPosition += distRandx.nextInt(7) + 1;
        }
        //when the top wall has been hit start moving down in increments of -7 to -1
        while(bounceY = true)
        {
            yPosition -= distRandy.nextInt((7) + 1) - 8;
        }
        //when the bottom wall has been hit start moving up in increments of 1 to 7
        while(bounceY = false)
        {
            yPosition += distRandy.nextInt(7) + 1;
        }
        
        
        draw();
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


