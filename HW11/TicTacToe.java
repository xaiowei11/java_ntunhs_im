package HW11;

public class TicTacToe {

    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
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
        return checkWinner('X') || checkWinner('O');
    }

    private boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true; // check rows
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true; // check columns
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true; // check diagonal
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true; // check opposite diagonal
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false; // if there's an empty cell, board is not full
            }
        }
        return true; // board is full
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char[][] getGameBoard() {
        return board;
    }
}