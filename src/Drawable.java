import java.awt.*;

/**
 * Anything that will be drawn in the GUI is a drawable object
 */
public class Drawable {
    private double xPosition;
    private double yPosition;
    private double xVelocity;
    private double yVelocity;
    private Color color;

    public Drawable(double xPos, double yPos, double xVel, double yVel, Color col){
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.xVelocity = xVel;
        this.yVelocity = yVel;
        this.color = col;
    }

    public double getxPosition() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
