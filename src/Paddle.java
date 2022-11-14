import java.awt.*;

public class Paddle extends Brick{

    public Paddle(){
        super(0,0,0,0,new Color(0,0,0));
    }
    //add functionality to catch powerups
    public void collide(Projectile incoming){

    }

    //check to see which keys are pressed and set velocity as appropriate.
    public void move(){}
}
