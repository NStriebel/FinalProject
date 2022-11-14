import java.awt.*;

public class Paddle extends Brick{

    public Paddle(int height, int width, int xPos, int yPos, Color col){
        super(height,width,xPos,yPos,col);
    }
    //add functionality to catch powerups
    public void collide(Projectile incoming){

    }

    //check to see which keys are pressed and set velocity as appropriate.
    public void move(){}
}
