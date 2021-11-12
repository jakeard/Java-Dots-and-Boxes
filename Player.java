public class Player {
    // class to keep track of player's symbol and score

    int score = 0;
    char symbol = 'X';

    public Player(boolean change) {
        // if there is already an X, change the symbol
        if (change) {
            changeSymbol();
        }
    }

    public int getScore() {
        // returns the player's current score
        return score;
    }

    public void setScore(int num) {
        // updates the player's score
        score = num;
        return;
    }

    private void changeSymbol() {
        // changes the player's symbol to O when called
        symbol = 'O';
    }
}