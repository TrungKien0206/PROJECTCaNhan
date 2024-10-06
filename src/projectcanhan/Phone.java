package projectcanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Phone extends JFrame {

    public Phone() {
        setTitle("iphone 16Promax ");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Background backgroundPanel = new Background();

        JButton calculatorApp = new JButton("Calculator");
        calculatorApp.setPreferredSize(new Dimension(150, 100));
        calculatorApp.setFont(new Font("Arial", Font.BOLD, 16));
        calculatorApp.setForeground(Color.WHITE);
        calculatorApp.setBackground(Color.BLACK);

        JButton libraryApp = new JButton("Library");
        libraryApp.setPreferredSize(new Dimension(150, 100));
        libraryApp.setFont(new Font("Arial", Font.BOLD, 16));
        libraryApp.setForeground(Color.BLACK);
        libraryApp.setBackground(Color.WHITE);

        JButton caroGameApp = new JButton("Caro Game");
        caroGameApp.setPreferredSize(new Dimension(150, 100));
        caroGameApp.setFont(new Font("Arial", Font.BOLD, 16));
        caroGameApp.setForeground(Color.BLACK);
        caroGameApp.setBackground(Color.WHITE);

        JButton facebookButton = new JButton("FaceBook");
        facebookButton.setPreferredSize(new Dimension(150, 100));
        facebookButton.setFont(new Font("Arial", Font.BOLD, 16));
        facebookButton.setForeground(Color.WHITE);
        facebookButton.setBackground(Color.BLUE);

        JButton youtubeButton = new JButton("YouTube");
        youtubeButton.setPreferredSize(new Dimension(150, 100));
        youtubeButton.setFont(new Font("Arial", Font.BOLD, 16));
        youtubeButton.setForeground(Color.WHITE);
        youtubeButton.setBackground(Color.RED);

        JButton timerButton = new JButton("TimerApp");
        timerButton.setPreferredSize(new Dimension(150, 100));
        timerButton.setFont(new Font("Arial", Font.BOLD, 16));
        timerButton.setForeground(Color.BLACK);
        timerButton.setBackground(Color.LIGHT_GRAY);

        calculatorApp.addActionListener(e -> new Calculator());
        libraryApp.addActionListener(e -> new Library());
        caroGameApp.addActionListener(e -> new CaroGame());
        facebookButton.addActionListener(e -> new FaceBook());
        youtubeButton.addActionListener(e -> new Youtube());
        timerButton.addActionListener(e -> new TimerApp());

        backgroundPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));
        backgroundPanel.add(calculatorApp);
        backgroundPanel.add(libraryApp);
        backgroundPanel.add(caroGameApp);
        backgroundPanel.add(facebookButton);
        backgroundPanel.add(youtubeButton);
        backgroundPanel.add(timerButton);
        setContentPane(backgroundPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Phone());
    }
}
