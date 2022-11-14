import java.awt.*;

public class Drawable {
    private int xPosition;
    private int yPosition;
    private double xVelocity;
    private double yVelocity;
    private Color color;

    public Drawable(int xPos, int yPos, double xVel, double yVel, Color col){
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.xVelocity = xVel;
        this.yVelocity = yVel;
        this.color = col;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
