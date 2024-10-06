package projectcanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaroGame extends JFrame {

    private final int SIZE = 15;
    private final JButton[][] buttons = new JButton[SIZE][SIZE];
    private boolean currentPlayer = true;

    public CaroGame() {
        setTitle("Caro Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(SIZE, SIZE));

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBackground(Color.LIGHT_GRAY);
                buttons[i][j].setPreferredSize(new Dimension(40, 40));

                final int x = i;
                final int y = j;

                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (buttons[x][y].getText().equals("")) {
                            buttons[x][y].setText(currentPlayer ? "X" : "O");
                            buttons[x][y].setForeground(currentPlayer ? Color.RED : Color.BLUE);

                            if (checkWin(x, y)) {
                                JOptionPane.showMessageDialog(CaroGame.this,
                                        (currentPlayer ? "X" : "O") + " Victory!",
                                        "Game Over",
                                        JOptionPane.INFORMATION_MESSAGE);
                                resetGame();
                            }

                            currentPlayer = !currentPlayer;
                        }
                    }
                });

                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    private boolean checkWin(int row, int col) {
        String currentSymbol = buttons[row][col].getText();
        return (checkDirection(row, col, 1, 0, currentSymbol)
                || checkDirection(row, col, 0, 1, currentSymbol)
                || checkDirection(row, col, 1, 1, currentSymbol)
                || checkDirection(row, col, 1, -1, currentSymbol));
    }

    private boolean checkDirection(int row, int col, int rowIncrement, int colIncrement, String symbol) {
        int count = 1;

        count += countSymbols(row, col, rowIncrement, colIncrement, symbol);

        count += countSymbols(row, col, -rowIncrement, -colIncrement, symbol);

        return count >= 5;
    }

    private int countSymbols(int row, int col, int rowIncrement, int colIncrement, String symbol) {
        int count = 0;
        int newRow = row + rowIncrement;
        int newCol = col + colIncrement;

        while (isInBounds(newRow, newCol) && buttons[newRow][newCol].getText().equals(symbol)) {
            count++;
            newRow += rowIncrement;
            newCol += colIncrement;
        }

        return count;
    }

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    private void resetGame() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setBackground(Color.LIGHT_GRAY);
            }
        }
        currentPlayer = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CaroGame());
    }
}
