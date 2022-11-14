import java.awt.*;

public class Projectile extends Drawable {
    private int radius;

    public Projectile(int radius){
        super(0,0,0,0,new Color(0,0,0));
        this.radius = radius;
    }
}
