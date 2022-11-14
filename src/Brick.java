import java.awt.*;

/**
 * This class represents any rectangular object that can interact with the ball
 */
public class Brick extends Drawable {
    private int height;
    private int width;

    /**
     * Initialize a Brick. By convention, the ordered pair (xPos, yPos) represents the center of the Brick
     * in an integer coordinate system with the origin at the top left corner of the screen
     * @param height the height of the brick
     * @param width the width of the brick
     * @param xPos the horizontal position of the Brick's center
     * @param yPos the vertical position of the Brick's center, with down being the positive y direction
     * @param color the starting color of this brick
     */
    public Brick(int height, int width, int xPos, int yPos, Color color){
        super(xPos,yPos,0,0, color);
        this.height = height;
        this.width = width;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Determines whether this Brick is colliding with a given projectile in the current time step. If it detects a collision, it determines which side of the brick the ball collided with.
     * This method only has a certain window of detection. Be wary of clipping if the ball is moving very quickly.
     * @param incoming is the projectile to check for a collision with this Brick.
     * @return 0 if there is no collision, 1 if the collision is with the top of the brick, 2 if with the right, 3 if with the bottom, 4 if with the left
     */
    public int detectCollision(Projectile incoming){
        //remember that down is the positive y direction
        int brickTop = this.getyPosition() - (this.height / 2);
        int brickBottom = this.getyPosition() + (this.height / 2);
        int brickLeft = this.getxPosition() - (this.width / 2);
        int brickRight = this.getxPosition() + (this.width / 2);

        //if the distance from any edge of the brick to the center of the ball is less than the radius, it's a collision
        if(incoming.getxPosition() >= brickLeft && incoming.getxPosition() <= brickRight){
            //if the ball is horizontally in line with the brick, check to see if it intersects the vertical sides.
            if(Math.abs(brickBottom - incoming.getyPosition()) <= incoming.getRadius()){
                return 3;
            }
            else if(Math.abs(brickTop - incoming.getyPosition()) <= incoming.getRadius()){
                return 1;
            }
        }
        if(incoming.getyPosition() >= brickTop && incoming.getyPosition() <= brickBottom) {
            if (Math.abs(brickLeft - incoming.getxPosition()) <= incoming.getRadius()) {
                return 4;
            }
            if (Math.abs(brickRight - incoming.getxPosition()) <= incoming.getRadius()) {
                return 2;
            }
        }
            return 0;
    }

    //if it's a Ball, reflect it, if it's a powerup, let it pass through
    public void collide(Projectile incoming){}
}
