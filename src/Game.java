import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Calls
 */
public class Game {
    //These will definitely change.
    private final int BOARDWIDTH = 100;
    private final int BOARDHEIGHT = 100;

    private int lives;
    private List<Drawable> gameObjects; //the walls are just giant bricks that get put in this List
    private Queue<Powerup> powerups; //the powerups in the queue are not drawn or updated. Every once in a while, the update method removes them from the queue and adds them to gameObjects
    private Map<Brick, Integer> bricks;

    /**
     * Initialize the walls, paddle, ball, bricks, and queue of powerups. Eventually, we may do this with file input for multiple board setups.
     */
    public void setup(){}

    /**
     * Loops through gameObjects and updates everything based on its velocity. It must check each projectile for a collision with each brick.
     */
    public void update() {//loop through bricks and gameObjects, move things with velocity and check for collisions
        for(Drawable thisObject : gameObjects){
            thisObject.setxPosition(thisObject.getxPosition()+thisObject.getxVelocity());
        }

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

    /**
     * Draws all of the components of the game on the GUI. This may require additional helper methods or classes.
     */
    public void drawFrame(){
        //loop through gameObjects and brickDurabilities and draw everything
    }

    /**
     * Repeatedly draws the board, updates the game state while listening for keyboard input and adjusting the paddle's velocity accordingly. This will require using threads, and it may require additional helper methods.
     */
    public void main(){}
}