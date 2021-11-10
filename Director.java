import java.util.Scanner;

public class Director {

    Scanner input = new Scanner(System.in);
    Board board = new Board();
    Player p1 = new Player(false); 
    Player p2 = new Player(true);

    private void displayBoard() {
        System.out.println(board.getBoard().toString().replace("[", "").replace("]", "").replace(",", ""));
    }

    private static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void run() {
        boolean end = false;
        boolean result;
        boolean available;
        String coords;
        int turn = 1;
        while (!end) {
            available = false;
            while (!available) {
                displayBoard();
                if (turn % 2 == 1) {
                    System.out.println("Player 1 enter coordinates: ");
                } else {
                    System.out.println("Player 2 enter coordinates: ");
                }
                coords = input.nextLine();
                available = board.checkAvailable(coords);
                if (!available) {
                    System.out.println("\nNot a valid location!");
                    wait(800);
                } else {
                    if (turn % 2 == 1) {
                        result = board.addLine(coords, p1);
                    } else {
                        result = board.addLine(coords, p2);
                    }
                    if (p1.getScore() + p2.getScore() == 16) {
                        end = true;
                    }
                    if (!result) {
                        turn += 1;
                    }
                }  
            }
        }
        displayBoard();
        if (p1.getScore() > p2.getScore()) {
            System.out.println("Player 1 Wins!\n\nPlayer 1 Score: " + p1.getScore() + "\nPlayer 2 Score: " + p2.getScore());
        } else {
            System.out.println("Player 2 Wins!\n\nPlayer 2 Score: " + p2.getScore() + "\nPlayer 1 Score: " + p1.getScore());
        }
    }
}
