package projectcanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerApp extends JFrame {
    private JLabel timerLabel;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JButton cutTimeButton; // Nút để cắt thời gian
    private Timer timer;
    private long startTime;
    private long elapsedTime; // Thời gian đã chạy
    private boolean running;
    private ArrayList<Double> cutTimes; // Danh sách để lưu thời gian cắt
    private JTextArea cutTimeArea; // Khu vực hiển thị thời gian cắt

    public TimerApp() {
        setTitle("Timer App");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        timerLabel = new JLabel("Time: 0.00 seconds");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(timerLabel);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        cutTimeButton = new JButton("Cut Time"); // Khởi tạo nút cắt thời gian

        add(startButton);
        add(stopButton);
        add(resetButton);
        add(cutTimeButton); // Thêm nút vào giao diện

        // Tạo khu vực hiển thị thời gian cắt
        cutTimeArea = new JTextArea(10, 20);
        cutTimeArea.setEditable(false);
        cutTimeArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(cutTimeArea);
        add(scrollPane);

        cutTimes = new ArrayList<>(); // Khởi tạo danh sách thời gian cắt

        // Timer để cập nhật mỗi 10ms (0.01 giây)
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long currentTime = System.currentTimeMillis();
                long totalElapsedTime = elapsedTime + (currentTime - startTime); // Cập nhật thời gian đã chạy
                double seconds = totalElapsedTime / 1000.0; // Chuyển đổi thành giây
                timerLabel.setText(String.format("Time: %.2f seconds", seconds)); // Cập nhật nhãn
            }
        });

        // Thêm sự kiện cho các nút
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!running) {
                    startTime = System.currentTimeMillis(); // Ghi lại thời điểm bắt đầu
                    timer.start(); // Bắt đầu hẹn giờ
                    running = true;
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    timer.stop(); // Dừng hẹn giờ
                    elapsedTime += System.currentTimeMillis() - startTime; // Cập nhật thời gian đã chạy
                    running = false;
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop(); // Dừng hẹn giờ
                elapsedTime = 0; // Reset thời gian đã chạy
                running = false;
                timerLabel.setText("Time: 0.00 seconds"); // Reset nhãn thời gian
                cutTimes.clear(); // Xóa danh sách thời gian cắt
                cutTimeArea.setText(""); // Xóa khu vực hiển thị thời gian cắt
            }
        });

        cutTimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    long currentTime = System.currentTimeMillis();
                    long totalElapsedTime = elapsedTime + (currentTime - startTime);
                    double cutTimeInSeconds = totalElapsedTime / 1000.0; // Thời gian cắt
                    cutTimes.add(cutTimeInSeconds); // Lưu vào danh sách
                    
                    // Hiển thị thời gian cắt theo thứ tự
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < cutTimes.size(); i++) {
                        sb.append("Cut Time " + (i + 1) + ": " + String.format("%.2f seconds\n", cutTimes.get(i)));
                    }
                    cutTimeArea.setText(sb.toString()); // Cập nhật khu vực hiển thị
                } else {
                    JOptionPane.showMessageDialog(null, "Timer is not running.");
                }
            }
        });

        setVisible(true);
    }
}
