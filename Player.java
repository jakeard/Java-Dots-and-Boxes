public class Player {
    int score = 0;
    char symbol = 'X';

    public Player(boolean change) {
        if (change) {
            changeSymbol();
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int num) {
        score = num;
        return;
    }

    private void changeSymbol() {
        symbol = 'O';
    }
}
