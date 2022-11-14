import java.awt.*;

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
