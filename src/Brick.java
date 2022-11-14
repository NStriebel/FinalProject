import java.awt.*;

public class Brick extends Drawable {
    private int height;
    private int width;

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

    public boolean isColliding(Projectile incoming){
        return false;
    }

    //if it's a Ball, reflect it, if it's a powerup, let it pass through
    public void collide(Projectile incoming){}
}
