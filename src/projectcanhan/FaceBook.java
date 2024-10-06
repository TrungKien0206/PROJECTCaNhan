package projectcanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;

public class FaceBook extends JFrame {

    public FaceBook() {
        setTitle("Facebook");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton openFacebookButton = new JButton("Open Facebook");
        openFacebookButton.setBackground(Color.BLUE);
        openFacebookButton.setForeground(Color.WHITE);
        openFacebookButton.setFont(new Font("Arial", Font.BOLD, 16));

        openFacebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLink("https://www.facebook.com/koda.kien");
            }
        });

        setLayout(new FlowLayout());
        add(openFacebookButton);

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
