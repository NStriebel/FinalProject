import java.awt.*;

/**
 * The Powerup class represents buffs and debuffs that fall from the top of the screen and must be caught by the paddle to take effect. They pass through bricks.
 */
public class Powerup extends Projectile{
    String type;

    /**
     * Powerups will appear at the top of the screen with a random x-position within given bounds.
     * @param type a string that denotes the effect of this powerup when it collides with the paddle
     * @param xMin the left bound of the powerup's starting location
     * @param xMax the right bound of the powerup's starting location
     * @param speed the speed at which the powerup falls. This has no horizontal component.
     */
    public Powerup(String type, int xMin, int xMax, double speed){
        super(0, xMin + (xMax-xMin) * Math.random(), 0, 0, speed, new Color(0,0,0));

        this.type = type;

        if(type.equals("ExtraLife")){
            this.setColor(Color.RED);
        }
        else if(type.equals("FastPaddle")){
            this.setColor(Color.YELLOW);
        }
        else if(type.equals("SlowPaddle")){
            this.setColor(Color.BLUE);
        }
    }

    /**
     * This method retrieves the type of Powerup.
     * @return the type of Powerup
     */
    public String getType(){
        return type;
    }
}
