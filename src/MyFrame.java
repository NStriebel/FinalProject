import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class creates the window that the game will be played in.
 */
public class MyFrame extends JFrame{

    /**
     * This constructor creates the window in which the game will be played in. Inside this constructor,
     * the size of the window is set, the layout is set, its visibility is set, and how the window closes
     * is set.
     */
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        //this.addKeyListener(this);
        this.setLayout(null);
        this.setVisible(true);
    }

//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
}
