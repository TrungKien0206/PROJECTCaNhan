package projectcanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerApp extends JFrame {
    private JLabel timeLabel;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private Timer timer;
    private int seconds = 0;

    public TimerApp() {
        setTitle("Timer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        timeLabel = new JLabel("00:00");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        add(timeLabel);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimer();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetTimer();
            }
        });

        add(startButton);
        add(stopButton);
        add(resetButton);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                int minutes = seconds / 60;
                int secs = seconds % 60;
                timeLabel.setText(String.format("%02d:%02d", minutes, secs));
            }
        });

        setVisible(true);
    }

    private void startTimer() {
        timer.start();
    }

    private void stopTimer() {
        timer.stop();
    }

    private void resetTimer() {
        timer.stop();
        seconds = 0;
        timeLabel.setText("00:00");
    }
}
