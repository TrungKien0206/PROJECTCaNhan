package projectcanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Phone extends JFrame {

    public Phone() {
        setTitle("Phone Simulator");

        setSize(300, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Background backgroundPanel = new Background();

        JButton calculatorApp = new JButton("Open Calculator");
        calculatorApp.setPreferredSize(new Dimension(150, 100));
        calculatorApp.setFont(new Font("Arial", Font.BOLD, 16));
        calculatorApp.setForeground(Color.WHITE);
        calculatorApp.setBackground(Color.BLACK);

        calculatorApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Calculator();
            }
        });

        JButton libraryApp = new JButton("Open Library");
        libraryApp.setPreferredSize(new Dimension(150, 100));
        libraryApp.setFont(new Font("Arial", Font.BOLD, 16));
        libraryApp.setForeground(Color.WHITE);
        libraryApp.setBackground(Color.BLACK);

        libraryApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Library();
            }
        });

        backgroundPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 200));
        backgroundPanel.add(calculatorApp);
        backgroundPanel.add(libraryApp);

        setContentPane(backgroundPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Phone());
    }
}
