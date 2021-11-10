import java.util.ArrayList;
// to create and store the board

public class Board {
    // class to create and update the board

    // what the board is stored in and as
    ArrayList<Character> board = new ArrayList<Character>();
    

    public Board() {
        // constructor, builds the starting board
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
                board.add('\u2022'); // code to use bullet points so the dots are centered
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

    private int getIndex(String coords) {
        // returns the index in the array given the user input of a letter and an integer
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

    private void addBox(int index, Player player) {
        // claims a box for the current player
        if (board.get(index) == ' ') {
            board.set(index, player.symbol);
            addScore(player);
        }
        return;
    }

    private void addScore(Player player) {
        // if a box is claimed, add 1 to the player's score
        player.setScore(player.getScore() + 1);
    }

    private boolean canAddBox(int index, char symbol, Player player) {
        // determines if a box is able to be claimed. If yes, it calls the addBox function. 
        boolean found = false;
        //Loops through again in case the player got two boxes at once
        for (int i = 0; i < 2; i++) {
            if (symbol == '-') {
                try {
                    if (board.get(index + 11) == '|' && board.get(index + 13) == '|' && board.get(index + 24) == '-') {
                        addBox(index + 12, player);
                        index -= 12;
                        found = true;
                    } else if (board.get(index - 11) == '|' && board.get(index - 13) == '|' && board.get(index - 24) == '-') {
                        addBox(index - 12, player);
                        index += 12;
                        found = true;
                    } else {
                        break;
                    }
                } catch (IndexOutOfBoundsException e) {
                    if (board.get(index - 11) == '|' && board.get(index - 13) == '|' && board.get(index - 24) == '-') {
                        addBox(index - 12, player);
                        index += 12;
                        found = true;
                    } else {
                        break;
                    }   
                }
            } else {
                if (board.get(index + 2) == '|' && board.get(index - 11) == '-' && board.get(index + 13) == '-') {
                    addBox(index + 1, player);
                    index -= 2;
                    found = true;
                } else if (board.get(index - 2) == '|' && board.get(index - 13) == '-' && board.get(index + 11) == '-') {
                    addBox(index - 1, player);
                    index += 2;
                    found = true;
                } else {
                    break;
                }
            }
        }
        return found;
    }
        
    public boolean addLine(String coords, Player player) {
        // adds a line at the given coordinates
        int index = getIndex(coords);
        int num = Character.getNumericValue(coords.charAt(1));
        char symbol;
        if (num % 2 == 0) {
            symbol = '|';
        } else {
            symbol = '-';
        }
        board.set(index, symbol);
        boolean result = canAddBox(index, symbol, player);
        return result;
    }

    public ArrayList<Character> getBoard() {
        // returns the current state of the board
        return board;
    }

    public boolean checkAvailable(String coords) {
        // check if user's coordinates are available to add a line to
        int index = getIndex(coords);
        if (board.get(index - 1) != '\u2022' && index % 2 == 0) {
            return false;
        } else if (board.get(index) == ' ') {
            return true;
        } else {
            return false;
        }
    }
    
}