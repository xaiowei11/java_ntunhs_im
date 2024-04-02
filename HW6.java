package aa; // Consider using a more descriptive package name like tictactoe

import java.util.Scanner;

public class HW6 {
	public static void main(String[] args) {
	    TicTacToe game = new TicTacToe();
	    game.playGame();
	}
}


class TicTacToe {

    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    public static void playGame() {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = PLAYER_X;
        boolean gameEnded = false;

        while (!gameEnded) {
            drawBoard(board);
            boolean validMove = getMove(board, currentPlayer, scanner);
            if (!validMove) {
                continue; // Skip to the next iteration if the move was invalid
            }
            gameEnded = checkWinner(board, currentPlayer);
            if (!gameEnded) {
                currentPlayer = currentPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
            }
        }

        drawBoard(board);
        System.out.println("Player " + currentPlayer + " wins!");
        scanner.close();
    }

    private static void drawBoard(char[][] board) {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-+-+-");
        }
    }

    private static boolean getMove(char[][] board, char currentPlayer, Scanner scanner) {
        System.out.println("Player " + currentPlayer + ", enter your move (row and column):");
        String inputString = scanner.nextLine();

        try {
            String[] parts = inputString.split("\\s+");
            if (parts.length != 2) {
                throw new NumberFormatException();
            }

            int row = Integer.parseInt(parts[0].trim());
            int col = Integer.parseInt(parts[1].trim());

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                return true;
            } else {
                System.out.println("This move at (" + row + "," + col + ") is not valid. Try again.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numbers only.");
            return false;
        }
    }

    private static boolean checkWinner(char[][] board, char currentPlayer) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }

        // Check for tie after all possible winning conditions are checked
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        System.out.println("It's a tie!");
        System.exit(0);
        return false;
    }
}
