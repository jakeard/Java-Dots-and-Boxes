import java.util.Scanner;
// for user input

public class Director {
    // class to direct the movement of the game

    // user input
    Scanner input = new Scanner(System.in);
    // the game board and functions
    Board board = new Board();
    // instances of player, player1 and player2
    Player p1 = new Player(false); 
    Player p2 = new Player(true);

    private void displayBoard() {
        // displays the board in user friendly format
        System.out.println(board.getBoard().toString().replace("[", "").replace("]", "").replace(",", ""));
    }

    private static void wait(int ms) {
        // makes function sleep for given amount of time
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void run() {
        // starts the game by initializing needed variables and entering the game loop
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
                    // if it is p1's turn, display p1 turn
                    System.out.println("Player 1 enter coordinates: ");
                } else {
                    // otherwise, display p2 turn
                    System.out.println("Player 2 enter coordinates: ");
                }
                coords = input.nextLine(); // get user input for location
                available = board.checkAvailable(coords); // check if the user's input is a valid location on the board
                if (!available) {
                    // if it is not valid, say so and sleep for a little so the message can be seen easier
                    System.out.println("\nNot a valid location!");
                    wait(800);
                } else {
                    // otherwise, add the line to the board in accordance with who's turn it is
                    if (turn % 2 == 1) {
                        result = board.addLine(coords, p1);
                    } else {
                        result = board.addLine(coords, p2);
                    }
                    if (p1.getScore() + p2.getScore() == 16) {
                        // if the board has been filled entirely, end the game
                        end = true;
                    } else if (!result) {
                        // otherwise, if the player's line did not make a box it is the other player's turn
                        turn += 1;
                    }
                }  
            }
        }
        // after the board is full, display the board
        displayBoard();
        if (p1.getScore() > p2.getScore()) {
            // if player 1 wins, say so and display scores
            System.out.println("Player 1 Wins!\n\nPlayer 1 Score: " + p1.getScore() + "\nPlayer 2 Score: " + p2.getScore());
        } else {
            // otherwise display player 2 wins and scores
            System.out.println("Player 2 Wins!\n\nPlayer 2 Score: " + p2.getScore() + "\nPlayer 1 Score: " + p1.getScore());
        }
    }
}