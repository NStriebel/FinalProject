import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the name of the board file: ");
            String filename = scan.next();

            Game myGame = new Game(filename);
            myGame.main();
        }
        catch (FileNotFoundException e){
            System.out.println("That file was not found.");
            return;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
