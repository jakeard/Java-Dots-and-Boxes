import java.util.Scanner;
import java.util.ArrayList;

public class Director {

    Scanner input = new Scanner(System.in);
    Board board = new Board();

    private void displayBoard() {
        // ArrayList<Character> x = board.getBoard();
        System.out.println(board.getBoard().toString().replace("[", "").replace("]", "").replace(",", ""));
    }

    public void run() {
        boolean end = false;
        int turn = 1;
        while (!end) {
            displayBoard();
            if (turn % 2 == 1) {
                System.out.println("Player 1 enter coordinates: ");
            } else {
                System.out.println("Player 2 enter coordinates: ");
            }
            String coords = input.nextLine();
            boolean result = board.addLine(coords, turn % 2);
            if (!result) {
                turn += 1;
            }
        }
    }
}
