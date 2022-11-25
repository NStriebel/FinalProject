import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try{
            Game myGame = new Game("TestBoard.txt");
            myGame.main();
        }
        catch (FileNotFoundException e){

        }
        catch(Exception e){

        }
    }
}
