import java.io.File;
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
            String filename = "ToughPyramid.txt";
            String instructionsFileName = "Instructions.txt";

            if(args.length >= 2){
                instructionsFileName = args[1];
                filename = args[0];
            }
            else if(args.length == 1){
                filename = args[0];
            }
            else {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter the name of the board file: ");
                filename = scan.next();
                System.out.print("Enter the name of the instructions file: ");
                instructionsFileName = scan.next();
            }

            Scanner instructPrinter = new Scanner(new File(instructionsFileName));
            while(instructPrinter.hasNextLine()){
                System.out.println(instructPrinter.nextLine());
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
