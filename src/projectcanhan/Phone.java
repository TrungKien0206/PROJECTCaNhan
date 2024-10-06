package projectcanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Phone extends JFrame {

    public Phone() {
        // Thiết lập tiêu đề cho cửa sổ
        setTitle("Phone Simulator");

        // Thiết lập kích thước khung giống như điện thoại
        setSize(300, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo một panel với hình nền
        Background backgroundPanel = new Background();

        // Tạo nút Open Calculator
        JButton calculatorApp = new JButton("Open Calculator");
        calculatorApp.setPreferredSize(new Dimension(150, 100));
        calculatorApp.setFont(new Font("Arial", Font.BOLD, 16));
        calculatorApp.setForeground(Color.WHITE);
        calculatorApp.setBackground(Color.BLACK);

        // Thêm sự kiện cho nút Calculator
        calculatorApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Calculator(); // Đảm bảo rằng lớp Calculator đã được định nghĩa
            }
        });

        // Tạo nút Library
        JButton libraryApp = new JButton("Open Library");
        libraryApp.setPreferredSize(new Dimension(150, 100));
        libraryApp.setFont(new Font("Arial", Font.BOLD, 16));
        libraryApp.setForeground(Color.WHITE);
        libraryApp.setBackground(Color.BLACK);

        // Thêm sự kiện cho nút Library
        libraryApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Library(); // Mở cửa sổ thư viện khi nhấn nút
            }
        });

        // Thiết lập layout cho khung điện thoại
        backgroundPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 200));
        backgroundPanel.add(calculatorApp);
        backgroundPanel.add(libraryApp); // Thêm nút Library vào panel

        // Thêm backgroundPanel vào khung chính
        setContentPane(backgroundPanel);

        // Hiển thị khung
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Phone());
    }
}
