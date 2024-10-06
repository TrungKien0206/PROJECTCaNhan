package projectcanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Phone extends JFrame {

    public Phone() {
        setTitle("iPad Simulator");

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Background backgroundPanel = new Background();

        JButton calculatorApp = new JButton("Calculator");
        calculatorApp.setPreferredSize(new Dimension(200, 100));
        calculatorApp.setFont(new Font("Arial", Font.BOLD, 36));
        calculatorApp.setForeground(Color.WHITE);
        calculatorApp.setBackground(Color.BLACK);

        calculatorApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Calculator();
            }
        });

        JButton libraryButton = new JButton("Library");
        libraryButton.setPreferredSize(new Dimension(200, 100));
        libraryButton.setFont(new Font("Arial", Font.BOLD, 36));
        libraryButton.setForeground(Color.BLACK);
        libraryButton.setBackground(Color.WHITE);

        libraryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Library();
            }
        });

        JButton caroButton = new JButton("Caro Game");
        caroButton.setPreferredSize(new Dimension(200, 100));
        caroButton.setFont(new Font("Arial", Font.BOLD, 36));
        caroButton.setForeground(Color.WHITE);
        caroButton.setBackground(Color.BLUE);

        caroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CaroGame();
            }
        });

        backgroundPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        buttonPanel.add(calculatorApp);
        buttonPanel.add(libraryButton);
        buttonPanel.add(caroButton);

        backgroundPanel.add(buttonPanel);

        setContentPane(backgroundPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Phone());
    }
}
