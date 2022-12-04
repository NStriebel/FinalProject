import java.awt.*;

/**
 * This class represents a ball that bounces around the screen and decrements bricks' durabilites when it collides with them.
 */
public class Ball extends Projectile{
    /**
     * This constructor takes in the radius of the ball, the x and y positions of the ball, and the
     * x and y velocities of the ball to initialize the ball that will be used in the game.
     * @param rad the radius of the ball.
     * @param xPos the x position of the ball.
     * @param yPos the y position of the ball.
     * @param xVel the x velocity of the ball.
     * @param yVel the y velocity of the ball.
     */
    public Ball(int rad, double xPos, double yPos, double xVel, double yVel){
        super(rad, xPos, yPos, xVel, yVel, new Color(224, 210, 160));
    }
}
