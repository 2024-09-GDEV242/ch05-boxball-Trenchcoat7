import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Katie Strong
 * @version 2024.10.22
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate ten bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line
        int roof = 100; //position of the roof line
        int left = 400; //position of left wall line
        int right = 400; //position of right wall line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);
        
        //draw the roof
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, roof, 550, roof);
        
        //draw left wall
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 50, roof);
        
        //draw right wall
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(550, ground, 550, roof);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.YELLOW, ground, myCanvas);
        ball2.draw();
        BouncingBall ball3 = new BouncingBall(110, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();
        BouncingBall ball4 = new BouncingBall(70, 100, 70, Color.GREEN, ground, myCanvas);
        ball2.draw();
        BouncingBall ball5 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();
        BouncingBall ball6 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();
        BouncingBall ball7 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();
        BouncingBall ball8 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();
        BouncingBall ball9 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();
        BouncingBall ball10 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            ball3.move();
            ball4.move();
            ball5.move();
            ball6.move();
            ball7.move();
            ball8.move();
            ball9.move();
            ball10.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
