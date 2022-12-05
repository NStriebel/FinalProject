import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class that contains only a main method for running a game of breakout
 */
public class Main {
    /**
     * Uses console input to have the user enter a filename, then initialize a new game from that file and call its main method.
     */
    public static void main(String[] args) {
        try{
            String filename;

            if(args.length > 0){
                filename = args[0];
            }
            else {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter the name of the board file: ");
                filename = scan.next();
            }

            Game myGame = new Game(filename);
            myGame.main();
        }
        catch (FileNotFoundException e){
            System.out.println("That file was not found.");
            return;
        }
        catch(Exception e){

        }
    }
}
