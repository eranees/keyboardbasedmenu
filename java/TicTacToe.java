import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {

  private JButton[][] board;
  private boolean player1Turn = true;
  private JLabel status;

  public TicTacToe() {
    setTitle("Tic Tac Toe");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 3));

    board = new JButton[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = new JButton("");
        board[i][j].setFont(new Font("Arial", Font.PLAIN, 80));
        board[i][j].addActionListener(this);
        panel.add(board[i][j]);
      }
    }

    status = new JLabel("Player 1's turn");
    status.setFont(new Font("Arial", Font.PLAIN, 24));
    add(status, BorderLayout.NORTH);
    add(panel, BorderLayout.CENTER);

    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    JButton button = (JButton) e.getSource();
    if (button.getText().equals("")) {
      if (player1Turn) {
        button.setText("X");
        status.setText("Player 2's turn");
      } else {
        button.setText("O");
        status.setText("Player 1's turn");
      }
      player1Turn = !player1Turn;
    }
  }

  public static void main(String[] args) {
    new TicTacToe();
  }
}

/*
 * 
 * 
 * import javax.swing.*;
 * import java.awt.*;
 * import java.awt.event.*;
 * 
 * public class TicTacToe extends JFrame implements ActionListener {
 * private JButton[][] buttons;
 * private JLabel statusLabel;
 * private boolean xTurn;
 * 
 * public TicTacToe() {
 * setTitle("Tic Tac Toe");
 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 * 
 * buttons = new JButton[3][3];
 * JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
 * for (int i = 0; i < 3; i++) {
 * for (int j = 0; j < 3; j++) {
 * JButton button = new JButton();
 * button.setFont(new Font("Arial", Font.BOLD, 48));
 * button.addActionListener(this);
 * buttonPanel.add(button);
 * buttons[i][j] = button;
 * }
 * }
 * 
 * statusLabel = new JLabel("X's turn");
 * statusLabel.setFont(new Font("Arial", Font.PLAIN, 24));
 * statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
 * 
 * add(buttonPanel, BorderLayout.CENTER);
 * add(statusLabel, BorderLayout.SOUTH);
 * 
 * setSize(400, 400);
 * setVisible(true);
 * 
 * xTurn = true;
 * }
 * 
 * @Override
 * public void actionPerformed(ActionEvent e) {
 * JButton button = (JButton) e.getSource();
 * if (button.getText().equals("")) {
 * if (xTurn) {
 * button.setText("X");
 * statusLabel.setText("O's turn");
 * } else {
 * button.setText("O");
 * statusLabel.setText("X's turn");
 * }
 * xTurn = !xTurn;
 * 
 * if (checkWin()) {
 * String winner = xTurn ? "O" : "X";
 * JOptionPane.showMessageDialog(this, winner + " wins!");
 * resetGame();
 * } else if (checkTie()) {
 * JOptionPane.showMessageDialog(this, "Tie game!");
 * resetGame();
 * }
 * }
 * }
 * 
 * private boolean checkWin() {
 * // check rows
 * for (int i = 0; i < 3; i++) {
 * if (!buttons[i][0].getText().equals("") &&
 * buttons[i][0].getText().equals(buttons[i][1].getText()) &&
 * buttons[i][0].getText().equals(buttons[i][2].getText())) {
 * return true;
 * }
 * }
 * 
 * // check columns
 * for (int i = 0; i < 3; i++) {
 * if (!buttons[0][i].getText().equals("") &&
 * buttons[0][i].getText().equals(buttons[1][i].getText()) &&
 * buttons[0][i].getText().equals(buttons[2][i].getText())) {
 * return true;
 * }
 * }
 * 
 * // check diagonals
 * if (!buttons[0][0].getText().equals("") &&
 * buttons[0][0].getText().equals(buttons[1][1].getText()) &&
 * buttons[0][0].getText().equals(buttons[2][2].getText())) {
 * return true;
 * }
 * 
 * if (!buttons[0][2].getText().equals("") &&
 * buttons[0][2].getText().equals(buttons[1][1].getText()) &&
 * buttons[0][2].getText().equals(buttons[2][0].getText())) {
 * return true;
 * }
 * 
 * return false;
 * }
 * 
 * private boolean checkTie() {
 * for (int i = 0; i < 3; i++) {
 * for (int j = 0; j < 3; j++) {
 * if (buttons[i][j].getText().equals("")) {
 * return false;
 * 
 * 
 */