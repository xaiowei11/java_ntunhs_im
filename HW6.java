package v;
import java.util.InputMismatchException;
import java.util.Scanner;

class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;

    public TicTacToeGame() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X'; // X starts the game
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean makeMove(int row, int col) {
        if (isValidMove(row, col)) {
            board[row][col] = currentPlayer;
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    public boolean hasWinner() {
        return checkWinner(currentPlayer);
    }

    private boolean checkWinner(char currentPlayer) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    
    public char[][] getGameBoard() {
        return board;
    }

}


public class HW6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Choose the game mode:");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Bot");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        TicTacToeGame game = new TicTacToeGame();

        if (choice == 1) {
            playPlayerVsPlayer(game, scanner);
        } else if (choice == 2) {
            playPlayerVsBot(game, scanner);
        } else {
            System.out.println("Invalid choice. Exiting...");
        }

        scanner.close();
    }

    private static void playPlayerVsPlayer(TicTacToeGame game, Scanner scanner) {
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard(game.getGameBoard());
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Player " + game.getCurrentPlayer() + ", enter your move (row [0-2] and column [0-2]): ");
                try {
                    int row = scanner.nextInt();
                    int col = scanner.nextInt();
                    if (game.makeMove(row, col)) {
                        validInput = true;
                    } else {
                        System.out.println("This move at (" + row + "," + col + ") is not valid. Try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.");
                    scanner.nextLine();
                }
            }

            if (game.hasWinner()) {
                gameEnded = true;
                printBoard(game.getGameBoard());
                System.out.println("Player " + game.getCurrentPlayer() + " wins!");
            } else if (game.isBoardFull()) {
                printBoard(game.getGameBoard());
                System.out.println("It's a tie!");
                break;
            } else {
                game.switchPlayer();
            }
        }
    }

    private static void playPlayerVsBot(TicTacToeGame game, Scanner scanner) {
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard(game.getGameBoard());
            boolean validInput = false;

            while (!validInput) {
                if (game.getCurrentPlayer() == 'X') {
                    System.out.println("Player X, enter your move (row [0-2] and column [0-2]): ");
                    try {
                        int row = scanner.nextInt();
                        int col = scanner.nextInt();
                        if (game.makeMove(row, col)) {
                            validInput = true;
                        } else {
                            System.out.println("This move at (" + row + "," + col + ") is not valid. Try again.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter numbers only.");
                        scanner.nextLine();
                    }
                } else {
                    // Bot's turn
                    // Implement bot move logic here
                    // For simplicity, let's just randomly choose a move
                    int row = (int) (Math.random() * 3);
                    int col = (int) (Math.random() * 3);
                    if (game.makeMove(row, col)) {
                        validInput = true;
                        System.out.println("Bot chose position (" + row + "," + col + ").");
                    }
                }
            }

            if (game.hasWinner()) {
                gameEnded = true;
                printBoard(game.getGameBoard());
                if (game.getCurrentPlayer() == 'X') {
                    System.out.println("Player X wins!");
                } else {
                    System.out.println("Bot wins!");
                }
            } else if (game.isBoardFull()) {
                printBoard(game.getGameBoard());
                System.out.println("It's a tie!");
                break;
            } else {
                game.switchPlayer();
            }
        }
    }

    private static void printBoard(char[][] board) {
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
}
