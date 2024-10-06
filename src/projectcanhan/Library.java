package projectcanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class Library extends JFrame {

    public Library() {
        // Thiết lập tiêu đề cho cửa sổ
        setTitle("Library");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Thiết lập layout cho Library
        setLayout(new BorderLayout());

        // Tạo panel để chứa hình ảnh
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(0, 3)); // Sắp xếp hình ảnh theo hàng và cột

        // Thêm các hình ảnh vào thư viện
        String[] imagePaths = {
            "projectcanhan/image/family.jpg",
            "projectcanhan/image/Team.jpg",
            "projectcanhan/image/Me.jpg",
            "projectcanhan/image/letrungkien.jpg" // Đảm bảo tên tệp chính xác
        };

        for (String path : imagePaths) {
            // Tìm URL của hình ảnh
            URL resourceUrl = getClass().getClassLoader().getResource(path);
            if (resourceUrl != null) { // Kiểm tra nếu tài nguyên tồn tại
                ImageIcon originalIcon = new ImageIcon(resourceUrl);
                
                // Chỉnh kích thước hình ảnh
                Image img = originalIcon.getImage(); // Lấy hình ảnh từ ImageIcon
                Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Kích thước mới
                ImageIcon scaledIcon = new ImageIcon(scaledImg); // Tạo ImageIcon mới với hình đã chỉnh kích thước

                JLabel label = new JLabel(scaledIcon);
                label.setPreferredSize(new Dimension(100, 100)); // Thiết lập kích thước ưu tiên cho JLabel
                imagePanel.add(label); // Thêm hình ảnh vào panel
                
                // Thêm MouseListener để xử lý sự kiện nhấp chuột
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        showImageInNewFrame(originalIcon); // Gọi phương thức để hiển thị hình ảnh
                    }
                });
            } else {
                System.err.println("Image not found: " + path); // Thông báo lỗi nếu hình ảnh không tìm thấy
            }
        }

        // Thêm panel hình ảnh vào cửa sổ
        add(new JScrollPane(imagePanel), BorderLayout.CENTER);

        // Hiển thị khung
        setVisible(true);
    }

    // Phương thức để hiển thị hình ảnh trong một cửa sổ mới
    private void showImageInNewFrame(ImageIcon imageIcon) {
        JFrame imageFrame = new JFrame("Image Viewer");
        imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        imageFrame.setSize(600, 600);
        
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageFrame.add(imageLabel);
        
        imageFrame.setVisible(true);
    }
}
