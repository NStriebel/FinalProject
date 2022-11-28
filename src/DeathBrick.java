import java.awt.*;

public class DeathBrick extends Brick{
    public DeathBrick(int height, int width, double xPos, double yPos, Color col){
        super(height, width, xPos, yPos, col);
    }

    @Override
    public void collide(Projectile incoming, int collisionSide){
        super.collide(incoming, collisionSide);
        Game.loseLife();
    }
}
