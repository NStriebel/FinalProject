public class Reflective extends Drawable {
    private int height;
    private int width;

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

    public void collide(Projectile incoming){}
}
