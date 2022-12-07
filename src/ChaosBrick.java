import java.awt.*;

public class ChaosBrick extends Brick{
    public ChaosBrick(int height, int width, double xPos, double yPos, Color col){
        super(height, width, xPos, yPos, col);
    }

    @Override
    public void collide(Projectile incoming, int collisionside){
        super.collide(incoming, collisionside);

        Game.randomizeBricks();
    }

//    @Override
//    public int hashCode(){
//        return 13*this.getHeight() + 17*(int)this.getxPosition()+7*(int)this.getyPosition();
//    }

    @Override
    public boolean equals(Object other){
        return this == other;
    }
}
