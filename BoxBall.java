import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
/**
 * "This method draws a rectangle (the box) 
 * on screen and between five and thirty balls that move inside the box."
 *
 * @author Andrew Riganati with signifigant credit to Claire Iroudayassamy and several others for providing much needed
 * fixes and troubleshooting
 * @version 3/26/2019
 */
public class BoxBall
{
    private static final int DIST = 2;
    
    private Color color;
    private int diameter;
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
    private Random rand = new Random();

    /**
     * Constructor for objects of class BoxBall
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param distRandy the random distance integer on which y-axis ball
     * movement is determined
     * @param distRandx the random distance integer on which x-axis ball 
     * movement is determined.
     * @param toppos the y position of the top wall
     * @param botpos the y position of the bottom wall
     * @param leftpos the x position of the left wall
     * @param rightpos the x position of the right wall
     * @param drawingCanvas  the canvas to draw this ball on
     */
    
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,int toppos, 
    int botpos, int leftpos, int rightpos, Canvas drawingCanvas)
    {
        // initialise instance variables
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        top = toppos;
        bottom = botpos;
        left = leftpos;
        right = rightpos;
        canvas = drawingCanvas;
        
        while(ySpeed == 0)
        {
            ySpeed = rand.nextInt(6) + 1;
        }
        
        while(xSpeed == 0)
        {
            xSpeed = rand.nextInt(6) + 1;
        }
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
        if(yPosition <= (top)) {
            yPosition = (int)(top - diameter);
             ySpeed = -ySpeed;
        }
        
        if(yPosition >= (bottom - diameter)) {
            yPosition = (int)(bottom - diameter);
             ySpeed = -ySpeed;
        }
        
        if(xPosition <= (left)) {
            xPosition = (int)(left);
             xSpeed = -xSpeed;
        }
        
        if(xPosition >= (right - diameter)) {
            xPosition = (int)(right - diameter);
             xSpeed = -xSpeed;
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


