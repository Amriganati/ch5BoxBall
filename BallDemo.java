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
        int top = 125;
        int left = 125;
        int right = 350;
        int bottom = 250;
        myCanvas.setVisible(true);
        
        //draw the rectangle inside the canvas
        myCanvas.drawRectangle();
        
        //draw the four lines that act as the walls for the rectangle
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(top,left,top,bottom); //left wall
        myCanvas.drawLine(top,left,right,top); // top wall
        myCanvas.drawLine(left,bottom,right,bottom); //bottom wall
        myCanvas.drawLine(right,top,right,bottom); //right wall
        
        // create the number, color, and size of the balls
        
        BoxBall testball = new BoxBall(200, 200 ,15 ,Color.BLACK, top, bottom, left,
        right,myCanvas);
        testball.draw();
        
        boolean exist = true;
        
        while(exist = true)
        {
            myCanvas.wait(50);
            
            myCanvas.setForegroundColor(Color.BLACK);
            myCanvas.drawLine(top,left,top,bottom); //left wall
            myCanvas.drawLine(top,left,right,top); // top wall
            myCanvas.drawLine(left,bottom,right,bottom); //bottom wall
            myCanvas.drawLine(right,top,right,bottom);// right wall
            
            testball.move();
        }
        
    }
    
    
}

