package projectcanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;

public class Youtube extends JFrame {

    public Youtube() {
        setTitle("YouTube");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JButton openYouTubeButton = new JButton("Open YouTube");
        openYouTubeButton.setBackground(Color.RED);
        openYouTubeButton.setForeground(Color.WHITE);
        openYouTubeButton.setFont(new Font("Arial", Font.BOLD, 16));

        openYouTubeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLink("https://www.youtube.com/");
            }
        });

        setLayout(new FlowLayout());
        add(openYouTubeButton);

        setVisible(true);
    }

    private void openLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | java.net.URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
