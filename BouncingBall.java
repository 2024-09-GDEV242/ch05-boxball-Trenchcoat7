import java.awt.*;
import java.awt.geom.*;

/**
 * Class BouncingBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Katie Strong
 *
 * @version 2024.10.22
 */

public class BouncingBall
{
    private static final int GRAVITY = 3;  // effect of gravity
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition; // y position of ground
    private final int roofPosition; //y position of roof
    private final int leftPosition; // x? position of left
    private final int rightPosition; // x? position of right
    private Canvas canvas;
    private int ySpeed = 1;
    private int xSpeed = 1;// initial horozontal speed

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BouncingBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos,int roofPos, int leftPos, int rightPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        roofPosition = roofPos;
        leftPosition = leftPos;
        rightPosition = rightPos;
        canvas = drawingCanvas;
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

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        ySpeed += GRAVITY;
        xSpeed += GRAVITY;
        yPosition += ySpeed;
        xPosition +=2;

        // check if it has hit the ground
        if (yPosition >= (groundPosition - diameter)) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed; 
        }
        
        // check if it has hit the roof
        if (yPosition <= (roofPosition - diameter)) {
            yPosition = (int)(roofPosition - diameter);
            ySpeed = -ySpeed; 
        }

        // check if it has hit the left wall
        if (xPosition >= (leftPosition - diameter) && xSpeed > 0) {
            xPosition = (int)(leftPosition - diameter);
            xSpeed = -xSpeed; 
        }
        
        // check if it has hit the right wall
        if (xPosition <= (rightPosition - diameter) && xSpeed > 0) {
            xPosition = (int)(rightPosition - diameter);
            xSpeed = -xSpeed; 
        }

        // draw again at new position
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
