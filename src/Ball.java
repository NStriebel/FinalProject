import java.awt.*;

/**
 * This class represents a ball that bounces around the screen and decrements bricks' durabilites when it collides with them.
 */
public class Ball extends Projectile{
    public Ball(int rad, double xPos, double yPos, int xVel, int yVel){
        super(rad, xPos, yPos, xVel, yVel, new Color(224, 210, 160));
    }
}
