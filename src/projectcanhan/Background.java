package projectcanhan;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

class Background extends JPanel {
    private Image backgroundImage;

    public Background() {
        try {
            // Sử dụng ClassLoader để tải ảnh từ package projectcanhan.image
            backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("projectcanhan/image/letrungkien.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Vẽ hình nền nếu ảnh được tải thành công
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
