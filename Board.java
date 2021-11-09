import java.util.ArrayList;

public class Board {
    ArrayList<Character> board = new ArrayList<Character>();
    boolean result;

    public Board() {
        board.add('\n');
        board.add(' ');
        for (char letter = 'A'; letter <='I'; letter++) {
            board.add(letter);
        }
        board.add('\n');
        int num = 49;
        for (int i = 0; i < 5; i++) {
            board.add((char) num);
            num++;
            for (int j = 0; j < 5; j++) {
                board.add('\u2022');
                board.add(' ');
            }
            board.add('\n');
            if (num < 57) {
                board.add((char) num);
                num++;
            }
            if (i != 4) {
                board.add(' ');
                for (int k = 0; k < 9; k++) {
                    board.add(' ');
                }
                board.add('\n');
            }
        }
    }

    public ArrayList<Character> getBoard() {
        return board;
    }

    private int getIndex(String coords) {
        char letter = coords.charAt(0);
        letter = Character.toUpperCase(letter);
        int num = Character.getNumericValue(coords.charAt(1));
        int location = num * 12;
        switch (letter) {
            case 'A':
                location += 1;
                break;
            case 'B':
                location += 2;
                break;
            case 'C':
                location += 3;
                break;
            case 'D':
                location += 4;
                break;
            case 'E':
                location += 5;
                break;
            case 'F':
                location += 6;
                break;
            case 'G':
                location += 7;
                break;
            case 'H':
                location += 8;
                break;
            case 'I':
                location += 9;
                break;
        }
        return location;
    }

    public void addLine(String coords) {
        int index = getIndex(coords);
        int num = Character.getNumericValue(coords.charAt(1));
        char symbol;
        if (num % 2 == 0) {
            symbol = '|';
        } else {
            symbol = '-';
        }
        board.set(index, symbol);
        // if (box added) {
           // result == true
        //} else {
           // result == false;
        //}
        return;
    }

    public boolean boxAdded() {
        boolean x = result;
        result = false;
        return x;
    }

    private void addBox(String coords) {
        char letter = coords.charAt(0);
        int num = Character.getNumericValue(coords.charAt(1));
    }
}
