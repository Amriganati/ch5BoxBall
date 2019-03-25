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
    private Ellipse2D.Double circle;
    private int yPosition;
    private int xPosition;
    private final int top;
    private final int bottom;
    private final int left;
    private final int right;
    private Canvas canvas;
    private int ySpeed = 1;
    private int xSpeed = 2;

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
    
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,int toppos, 
    int botpos, int leftpos, int rightpos, Canvas drawingCanvas)
    {
        // initialise instance variables
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
        top = toppos;
        bottom = botpos;
        left = leftpos;
        right = rightpos;
        
        
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

    
    public void move()
    { 
        erase();
        int top = 125;
        int left = 125;
        int right = 350;
        int bottom = 250;
       
        yPosition += ySpeed;
        xPosition += xSpeed;
        //if xPosition  +diameter > right
        // xPosition = right - diameter
        if(yPosition <= (top - diameter)) {
            yPosition = (int)(top - diameter);
             yPosition = ySpeed * 1;
        }
        
        if(yPosition >= (bottom - diameter)) {
            yPosition = (int)(bottom - diameter);
            //
             yPosition = ySpeed * -1;
        }
        
        if(xPosition <= (left - diameter)) {
            xPosition = (int)(left - diameter);
             xPosition = xSpeed * 1;
        }
        
        if(xPosition >= (right - diameter)) {
            xPosition = (int)(right - diameter);
             xPosition = xSpeed * -1;
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


