package aa;

import java.util.Scanner;



public class HW6 
	{
	
	private static final char PLAYER_X = 'X';
	private static final char PLAYER_O = 'O';
	
		public static void main(String[] args)
		{
			char[][] board = {{' ', ' ', ' '},{' ',' ', ' '},{' ', ' ', ' '}};
		    boolean gameEnded = false;
		    char currentPlayer = PLAYER_X;

		    while (!gameEnded) {
		        drawBoard(board);
		        boolean validInput = false;
		        while (!validInput) {
		            validInput = getMove(board, currentPlayer);
		        }

		        gameEnded = checkWinner(board, currentPlayer);
		        if (!gameEnded) {
		            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
		        }
		    }

		    drawBoard(board);
		    System.out.println("Player " + currentPlayer + " wins!");
		}

		private static void drawBoard(char[][] board) {	
			System.out.println("Board:");
			for (int i = 0; i<3; i++)
			{
				for (int j = 0; j<3; j++)
				{
					System.out.print(board[i][j]);
					if (j<2) System.out.print("|");
				}
				System.out.println();
				if (i < 2) System.out.println("-+-+-");
			}
		}

		private static boolean getMove(char[][] board, char currentPlayer) {
		    Scanner scanner = new Scanner(System.in);
		    System.out.println("Player " + currentPlayer + ", enter your move (row and column):");
		    String inputString = scanner.nextLine();

		    try {
		        String[] parts = inputString.split("\\s+"); // 使用空白字元作為分割字元
		        if (parts.length != 2) {
		            throw new NumberFormatException(); // 如果輸入字串不包含兩個部分，則拋出異常
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
		    // 檢查行和列是否有獲勝者
		    for (int i = 0; i < board.length; i++) {
		        if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
		            return true;
		        }
		        if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
		            return true;
		        }
		    }

		    // 檢查對角線是否有獲勝者
		    if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
		        return true;
		    }
		    if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
		        return true;
		    }

		    return false;
		}
		}