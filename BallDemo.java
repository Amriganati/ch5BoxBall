import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Canvas Canvasb;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        Canvasb = new Canvas("Pong Rect" , 600 , 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    public void boxBounce()
    {
        
        
        Canvasb.setVisible(true);
        
        //draw the rectangle inside the canvas
        Canvasb.drawRectangle();
        
        //draw the four lines that act as the walls for the rectangle
        
        Canvasb.drawLine(125,125,125,250); //left wall
        Canvasb.drawLine(125,125,350,125); // top wall
        Canvasb.drawLine(125,250,350,250); //bottom wall
        Canvasb.drawLine(350,125,350,250); //right wall
        
        // create the number, color, and size of the balls
    }
    
    
}

