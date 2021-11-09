import java.util.Scanner;
import java.util.ArrayList;

public class Director {

    Scanner input = new Scanner(System.in);
    Board board = new Board();
    boolean turn = true;

    public Director(){
      
    }

    private void displayBoard() {
        ArrayList<Character> x = board.getBoard();
        System.out.println(x.toString().replace("[", "").replace("]", "").replace(",", ""));
    }

    public void run() {
        boolean won = false;
        while (won == false) {
            displayBoard();
            if (turn == true) {
                System.out.println("Player 1 enter coordinates: ");
            } else {
                System.out.println("Player 2 enter coordinates: ");
            }
            // ArrayList<Character> work = board.getBoard();
            String coords = input.nextLine();
            board.addLine(coords);
            if (!board.boxAdded()) {
                turn = !turn;
            }
            // won = true;
        }
    }
}
