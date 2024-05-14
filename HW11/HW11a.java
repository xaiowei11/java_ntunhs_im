package HW11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HW11a {

    static TicTacToe game = new TicTacToe();
    static JButton[][] buttons = new JButton[3][3];
    static JLabel statusLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        frame.add(panel, BorderLayout.CENTER);
        statusLabel = new JLabel("Player X's turn");
        frame.add(statusLabel, BorderLayout.SOUTH);
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                final int row = i;
                final int col = j;

                panel.add(buttons[i][j]);

                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (game.makeMove(row, col)) {
                            buttons[row][col].setText(String.valueOf(game.getCurrentPlayer()));
                            if (game.hasWinner()) {
                                //statusLabel.setText("Player " + game.getCurrentPlayer() + " wins!");
                                JOptionPane.showMessageDialog(frame,"Player"+game.getCurrentPlayer()+"wins!");
                                //resetGame();
                            } else if (game.isBoardFull()) {
                                statusLabel.setText("It's a draw!");
                                JOptionPane.showMessageDialog(frame,"It's draw");
                            } else {
                                game.switchPlayer();
                                statusLabel.setText("Player " + game.getCurrentPlayer() + "'s turn");
                            }
                        }
                    }
                });
                panel.add(buttons[i][j]);
            }
        }

        frame.setVisible(true);
    }
}
