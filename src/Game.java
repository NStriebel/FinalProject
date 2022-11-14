import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Game {
    private int lives;
    private List<Drawable> gameObjects; //the walls are just giant bricks that get put in this List
    private Queue<Powerup> powerups;
    private Map<Brick, Integer> brickDurabilities;

    public void setup(){}

    public void update() {//loop through bricks and objects, move things with velocity and check for collisions
        //looping through bricks
        //if thisBrick.isColliding(){
        //          thisBrick.collide()
        //          bricks.put(thisBrick, bricks.get(thisBrick)-1)
        //}


        //while looking for collisions, if the paddle hits a powerup, get its name, and do something
        //if(powerup.name.equals("ExtraLife")){
        //  lives++
        //}
    }

    public void drawFrame(){
        //loop through gameObjects and brickDurabilities and draw everything
    }

    //run a loop to update the board, then draw the update until the game ends
    public void main(){}
}