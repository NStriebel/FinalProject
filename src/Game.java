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
    private Map<Brick, Integer> bricks; //stores all the bricks with their durabilities

    /**
     * Initialize the walls, paddle, ball, bricks, and queue of powerups. Eventually, we may do this with file input for multiple board setups.
     */
    public void setup(){}

    /**
     * Loops through gameObjects and updates everything based on its velocity. It must check each projectile for a collision with each brick.
     */
    public void update() {//loop through bricks and gameObjects, move things with velocity and check for collisions
        //Update all objects' positions
        for(Drawable thisObject : gameObjects){
            thisObject.setxPosition(thisObject.getxPosition()+thisObject.getxVelocity());
            thisObject.setyPosition(thisObject.getyPosition()+thisObject.getyVelocity());

            if(thisObject instanceof Brick){//temporarily add paddle and walls to bricks Map to check them for collisions
                bricks.put((Brick)thisObject, 0);//setting their durability to zero means that they will be removed from the brick array before this method is done.
            }
        }

        for(Brick thisBrick : bricks.keySet()){
            for(Drawable thisObject : gameObjects){
                if(thisObject instanceof Projectile){
                    int collisionCode = thisBrick.detectCollision((Projectile)thisObject);
                    if(collisionCode > 0){ //if they actually collide
                        thisBrick.collide((Projectile)thisObject, collisionCode);
                        bricks.put(thisBrick, bricks.get(thisBrick)-1);//decrease the

                        if(thisObject instanceof Powerup && thisBrick instanceof Paddle){
                            applyPowerup(((Powerup)thisObject).getType()); //if a powerup collides with the paddle, apply the powerup's effect.
                        }
                    }
                }
            }

            if(bricks.get(thisBrick) <= 0){
                bricks.remove(thisBrick);
            }
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
     * This method is called when a powerup collides with the paddle. It is responsible for changing the game state to reflect the effect of the powerup.
     * @param effectName the name of the powerup to be applied. Currently supported powerups include "Extra Life"
     */
    public void applyPowerup(String effectName){
        if(effectName.equals("Extra Life")){
            lives++;
        }
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