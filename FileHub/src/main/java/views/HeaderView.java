package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class HeaderView extends JPanel {

    private JLabel profileLabel;

    public HeaderView() {
        initComponents();
    }

    public void ProfileListener(MouseListener listener) {
        profileLabel.addMouseListener(listener);
    }

    private void initComponents() {
        setLayout(new GridLayout());
        setPreferredSize(new Dimension(1024, 80));
        setBackground(new Color(73, 98, 138));

        JLabel heading = new JLabel("FileHub");
        heading.setForeground(Color.white);
        heading.setFont(new Font("Consolas", Font.BOLD, 36));
        heading.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));

        JLabel logoLabel = createImageLabel("/logo.png", 50, 39);

        logoLabel.setPreferredSize(new Dimension(50, 50));
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        logoLabel.setVerticalAlignment(JLabel.CENTER);

        JPanel profilePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 0));
        profilePanel.setBackground(new Color(73, 98, 138));
        
        JPanel profileWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 12));
        profileWrapper.setBackground(new Color(73, 98, 138));
        
        profileLabel = createImageLabel("/profile.png", 55, 55);
        profileLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profileWrapper.add(profileLabel);
        
        profileWrapper.addMouseListener(new MouseAdapter() {
            private final Color originalColor = profileWrapper.getBackground();
            private final Color hoverColor = new Color(85, 113, 158);
            
            @Override
            public void mouseEntered(MouseEvent e) {
                profileWrapper.setBackground(hoverColor);
                profileWrapper.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                profileWrapper.setBackground(originalColor);
                profileWrapper.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                profileWrapper.setBackground(new Color(65, 87, 122));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                if (profileWrapper.contains(e.getPoint())) {
                    profileWrapper.setBackground(hoverColor);
                } else {
                    profileWrapper.setBackground(originalColor);
                }
            }
        });
        
        profilePanel.add(profileWrapper);
        
        // Add panels to the main header
        add(heading, BorderLayout.WEST);
        add(logoLabel, BorderLayout.CENTER);
        add(profilePanel, BorderLayout.EAST);
        
        // Add bottom border to header
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(60, 80, 115)));
    }
    
    private JLabel createImageLabel(String resourcePath, int width, int height) {
        JLabel label = new JLabel();
        URL imageUrl = getClass().getResource(resourcePath);
        if (imageUrl != null) {
            ImageIcon image = new ImageIcon(imageUrl);
            Image resizedImage = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(resizedImage));
        }
        label.setPreferredSize(new Dimension(width, height));
        return label;
    }
}