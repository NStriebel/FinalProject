import java.awt.*;

/**
 * DeathBricks differ from regular bricks in that the player loses a life whenever the ball collides with a DeathBrick
 */
public class DeathBrick extends Brick{
    /**
     * Instantiates a deathbrick object
     * @param height
     * @param width
     * @param xPos
     * @param yPos
     * @param col the brick's color. By convention, this is black.
     */
    public DeathBrick(int height, int width, double xPos, double yPos, Color col){
        super(height, width, xPos, yPos, col);
    }

    /**
     * Calls the collide method from the parent class, then decrements the number of lives in the Game class.
     * @param incoming the projectile that has collided with this brick
     * @param collisionSide 1 for top, 2 for right, 3 for bottom, 4 for left
     */
    @Override
    public void collide(Projectile incoming, int collisionSide){
        super.collide(incoming, collisionSide);
        if(incoming instanceof Ball) {
            Game.loseLife();
        }
    }
}
