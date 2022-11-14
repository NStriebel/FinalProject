import java.awt.*;

/**
 * This class should never be instantiated. It exists so that balls and powerups can be referred to with polymorphism.
 */
public class Projectile extends Drawable {
    private int radius;

    public Projectile(int radius, int xPos, int yPos, double xVel, double yVel, Color col){
        super(xPos,yPos,xVel,yVel,col);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
