import java.awt.*;

/**
 * This class should never be instantiated. It exists so that balls and powerups can be referred to with polymorphism.
 */
public class Projectile extends Drawable {
    private int radius;

    /**
     * This constructor takes in the radius, x positon, y position, velocities in the x and y directions,
     * and the color of the Projectile object to initialize a Projectile object.
     * @param radius the radius of the Projectile
     * @param xPos the x position of the Projectile
     * @param yPos the y position of the Projectile
     * @param xVel the velocity in the x direction of the Projectile
     * @param yVel the velocity in the y direction of the Projectile
     * @param col the color of the Projectile
     */
    public Projectile(int radius, double xPos, double yPos, double xVel, double yVel, Color col){
        super(xPos,yPos,xVel,yVel,col);
        this.radius = radius;
    }

    /**
     * This method retrieves the radius of the Projectile object.
     * @return the radius of the Projectile object
     */
    public int getRadius() {
        return radius;
    }
}
