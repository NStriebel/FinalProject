import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

/**
 * Represents a game of breakout.
 */
public class Game implements KeyListener {
    private final int FRAMERATE = 60; //the number of frames to draw per second
    private final int FRAMETIME = (1/FRAMERATE) * 1000; //the number of milliseconds to draw a single frame
    private final int TICKRATE = 5;
    private final int TICKTIME = (1/TICKRATE) * 1000;

    private int lives;
    private List<Drawable> gameObjects; //the walls are just giant bricks that get put in this List
    private Queue<Powerup> powerups; //the powerups in the queue are not drawn or updated. Every once in a while, the update method removes them from the queue and adds them to gameObjects
    private Map<Brick, Integer> bricks; //stores all the bricks with their durabilities

    private MyFrame board;
    private JLabel paddleLabel;

    /**
     * Initialize the walls, paddle, ball, bricks, and queue of powerups based on input from a file.
     * Every line begins with a string of letters for human readability.
     * The first four lines of the file contain the space-separated information needed to initialize the walls, int height, int width, double xPosition, double yPosition.
     * The fifth line contains the same information for the paddle, with the addition of two additional integers for the left and right boundaries of the play area.
     * The sixth line that contains only an integer, which we will call n, which represents the number of bricks to be initialized.
     * After the sixth line are n lines, one for each brick. They contain the same parameters as the walls and paddle, with the addition of the brick's starting durability as an int.
     * After those is another line with only a number, m, to represent the number of different types of powerups to be generated.
     * For the next m lines, the line contains only the name of the powerup to be included. If an invalid name is entered, powerups with no effect will be generated.
     * Then is another line with the number of balls to be initialized, p.
     * This is followed by p lines, one for each ball with int radius, double xPosition, double yPosition, double xVelocity, double yVelocity.
     */
    public Game(String filename) throws FileNotFoundException {
        lives = 3;
        gameObjects = new ArrayList<>();
        powerups = new LinkedList<>();
        bricks = new HashMap<>();

        board = new MyFrame();
        board.addKeyListener(this);

        File boardFile = new File(filename);
        Scanner fileIn = new Scanner(boardFile);
        Scanner lineReader;

        //read in the walls
        for(int x=0; x<4;x++){
            lineReader = new Scanner(fileIn.nextLine());
            lineReader.next();//skip the name at the beginning of the line
            gameObjects.add(new Brick(lineReader.nextInt(), lineReader.nextInt(), lineReader.nextDouble(), lineReader.nextDouble(), new Color(1, 21, 241, 255)));
        }

        //read in the paddle
        lineReader = new Scanner(fileIn.nextLine());
        lineReader.next(); //skip the name
        gameObjects.add(new Paddle(lineReader.nextInt(), lineReader.nextInt(), lineReader.nextDouble(), lineReader.nextDouble(), new Color(28, 0, 150, 255), lineReader.nextInt(), lineReader.nextInt()));

        int numBricks = Integer.parseInt(fileIn.nextLine());
        for(int i=0; i<numBricks; i++){
            lineReader = new Scanner(fileIn.nextLine());
            lineReader.next(); //skip the name
            bricks.put(new Brick(lineReader.nextInt(), lineReader.nextInt(), lineReader.nextDouble(), lineReader.nextDouble(), new Color(25, 72, 1, 255)), lineReader.nextInt());
        }

        //TODO add a more sophisticated implementation with more randomness
        int numPowers = Integer.parseInt(fileIn.nextLine());
        for(int i=0; i<numPowers; i++){
            String type = fileIn.nextLine();
            powerups.add(new Powerup(type, 0, 25, 5));
        }

        int numBalls = Integer.parseInt(fileIn.nextLine());
        for(int i=0; i<numBalls; i++){
            lineReader = new Scanner(fileIn.nextLine());
            lineReader.next(); //skip the name
            gameObjects.add(new Ball(lineReader.nextInt(), lineReader.nextDouble(), lineReader.nextDouble(), lineReader.nextDouble(),lineReader.nextDouble()));
        }
    }

    /**
     * Loops through gameObjects and updates everything based on its velocity. It must check each projectile for a collision with each brick.
     */
    public void update() {
        //Update all objects' positions
        for(Drawable thisObject : gameObjects){
            thisObject.setxPosition(thisObject.getxPosition()+thisObject.getxVelocity());
            thisObject.setyPosition(thisObject.getyPosition()+thisObject.getyVelocity());

            if(thisObject instanceof Brick){//temporarily add paddle and walls to "bricks" so as to check them for collisions
                bricks.put((Brick)thisObject, 0);//setting their durability to zero means that they will be removed from the brick array before this method is done.
            }
        }

        //loop through all the bricks looking for collisions.
        //take note of which bricks need to be removed
        List<Brick> toRemove = new LinkedList<>();
        for(Brick thisBrick : bricks.keySet()){//TODO figure out the ConcurrentModificationException
            for(Drawable thisObject : gameObjects){
                if(thisObject instanceof Projectile){
                    int collisionCode = thisBrick.detectCollision((Projectile)thisObject);
                    if(collisionCode > 0){ //if they actually collide
                        thisBrick.collide((Projectile)thisObject, collisionCode);// TODO make sure this calls the paddle collide method if the Brick is a paddle
                        bricks.put(thisBrick, bricks.get(thisBrick)-1);//decrease the durability

                        if(thisObject instanceof Powerup && thisBrick instanceof Paddle){
                            applyPowerup(((Powerup)thisObject).getType()); //if a powerup collides with the paddle, apply the powerup's effect.
                        }
                    }
                }
            }

            //Note the bricks whose durability is gone in order to remove them once this loop is done
            if(bricks.get(thisBrick) <= 0){
                toRemove.add(thisBrick);
            }
        }
        //Java doesn't like it when you modify a collection while looping through it
        //here's the workaround for removing bricks
        for(Brick thisBrick : toRemove){
            bricks.remove(thisBrick);
        }
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
        //loop through gameObjects and bricks and draw everything
        //board.addKeyListener(this);//moved this line to the constructor

        //paddleLabel = new JLabel();
        JPanel contentPane = new JPanel(new BorderLayout());

        for (int i = 0;i < gameObjects.size();i++){
            if (gameObjects.get(i) instanceof Brick){
                JLabel brickLabel = new JLabel();
                brickLabel.setBackground(gameObjects.get(i).getColor());
                brickLabel.setOpaque(true);

                Brick thisBrick = (Brick)gameObjects.get(i);
                int topLeftX = (int)(thisBrick.getxPosition() - thisBrick.getWidth()/2);
                int topLeftY = (int)(thisBrick.getyPosition() - thisBrick.getHeight()/2);
                brickLabel.setBounds(topLeftX, topLeftY, ((Brick) gameObjects.get(i)).getWidth(), ((Brick) gameObjects.get(i)).getHeight());
                contentPane.add(brickLabel);
            }
            /*if (gameObjects.get(i) instanceof Paddle){
                paddleLabel.setBackground(gameObjects.get(i).getColor());
                paddleLabel.setOpaque(true);
                paddleLabel.setBounds((int) gameObjects.get(i).getxPosition(), (int) gameObjects.get(i).getyPosition(), ((Paddle) gameObjects.get(i)).getWidth(), ((Paddle) gameObjects.get(i)).getHeight());
                contentPane.add(paddleLabel);
            }*/ //Paddles are instances of Bricks, so this case should be covered by the previous if
            if (gameObjects.get(i) instanceof Ball){
                JLabel ballLabel = new JLabel();
                ballLabel.setBackground(gameObjects.get(i).getColor());
                ballLabel.setOpaque(true);
                ballLabel.setBounds((int) gameObjects.get(i).getxPosition(), (int) gameObjects.get(i).getyPosition(), (((Ball) gameObjects.get(i)).getRadius()), ((Ball) gameObjects.get(i)).getRadius());
                contentPane.add(ballLabel);
            }
            if (gameObjects.get(i) instanceof Powerup){
                JLabel powerLabel = new JLabel();
                powerLabel.setBackground(gameObjects.get(i).getColor());
                powerLabel.setOpaque(true);
                powerLabel.setBounds((int)gameObjects.get(i).getxPosition(), (int)gameObjects.get(i).getyPosition(), 2, 2);
                contentPane.add(powerLabel);
            }

        }

        for (Brick key : bricks.keySet()){
            JLabel brickLabel = new JLabel();
            brickLabel.setBackground(key.getColor());
            brickLabel.setOpaque(true);

            int topLeftX = (int)(key.getxPosition() - key.getWidth()/2);
            int topLeftY = (int)(key.getyPosition() - key.getHeight()/2);
            brickLabel.setBounds(topLeftX, topLeftY, key.getWidth(), key.getHeight());
            contentPane.add(brickLabel);
        }
        board.setContentPane(contentPane);
        board.show();
    }

    /**
     * Repeatedly draws the board, updates the game state while listening for keyboard input and adjusting the paddle's velocity accordingly. This will require using threads, and it may require additional helper methods.
     */
    public void main(){
        //board = new MyFrame(); //this line already exists in the constructor for Game
        long lastFrame = System.currentTimeMillis();
        long lastTick = System.currentTimeMillis();

        while (!bricks.isEmpty() && lives > 0){
            if(System.currentTimeMillis() - lastFrame > FRAMETIME) {
                lastFrame = System.currentTimeMillis();
                drawFrame();
            }
            if(System.currentTimeMillis() - lastTick > TICKTIME){
                lastTick = System.currentTimeMillis();
                update();
            }
        }

        JPanel contentPane = new JPanel(new BorderLayout());
        if(lives > 0){
            contentPane.add(new JTextField("You win!"));

        }
        else{
            contentPane.add(new JTextField("You lose :("));
        }
        board.setContentPane(contentPane);
        board.show();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'a':
                for (int i = 0;i < gameObjects.size(); i++){
                    if (gameObjects.get(i) instanceof Paddle){
                        gameObjects.get(i).setxPosition(gameObjects.get(i).getxPosition() - 1);
                        break;
                    }
                }
                break;
            case 'd':
                for (int i = 0;i < gameObjects.size(); i++){
                    if (gameObjects.get(i) instanceof Paddle){
                        gameObjects.get(i).setxPosition(gameObjects.get(i).getxPosition() + 1);
                        break;
                    }
                }
               break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}