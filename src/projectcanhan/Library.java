package projectcanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class Library extends JFrame {

    public Library() {
        setTitle("Library");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setLayout(new BorderLayout());

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(0, 3)); 

        String[] imagePaths = {
            "projectcanhan/image/family.jpg",
            "projectcanhan/image/Team.jpg",
            "projectcanhan/image/Me.jpg",
            "projectcanhan/image/letrungkien.jpg" 
        };

        for (String path : imagePaths) {
            URL resourceUrl = getClass().getClassLoader().getResource(path);
            if (resourceUrl != null) { 
                ImageIcon originalIcon = new ImageIcon(resourceUrl);
                
                Image img = originalIcon.getImage(); 
                Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); 
                ImageIcon scaledIcon = new ImageIcon(scaledImg); 
                JLabel label = new JLabel(scaledIcon);
                label.setPreferredSize(new Dimension(100, 100)); 
                imagePanel.add(label); 
                
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        showImageInNewFrame(originalIcon); 
                    }
                });
            } else {
                System.err.println("Image not found: " + path); 
            }
        }

        add(new JScrollPane(imagePanel), BorderLayout.CENTER);

        setVisible(true);
    }

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
