import java.awt.*;

/**
 * This class represents the paddle that moves back and forth to keep the ball in play.
 */
public class Paddle extends Brick{

    public Paddle(int height, int width, int xPos, int yPos, Color col){
        super(height,width,xPos,yPos,col);
    }

    /**
     * If a collision is detected between the paddle and a projectile, call this method on the paddle and send it the projectile. If it is the ball, reflect the ball at an angle based on where it contacted the paddle. Functionality may later be added for certain powerups that apply to the paddle. Currently, all powerups are applied in the Game class.
     * @param incoming the projectile that contacted the paddle.
     * @param collisionSide 1 for top, 2 for right, 3 for bottom, 4 for left
     */
    public void collide(Projectile incoming, int collisionSide){

    }

    //This method is not needed in this class. Paddle veloctiy adjustments can be done in the update function using Drawable's getter and setter methods for velocity.
    //check to see which keys are pressed and set velocity as appropriate.
    //public void move(){}
}
