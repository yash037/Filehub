package views;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.net.URL;

public class FeatureView extends JPanel {

    private JPanel transferPanel;
    private JPanel receivePanel;
    private JPanel cloudPanel;

    public FeatureView() {
        initComponents();
    }

    public JPanel getTransferPanel() {
        return transferPanel;
    }    

    public JPanel getReceivePanel() {
        return receivePanel;
    }

    public JPanel getCloudPanel() {
        return cloudPanel;
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(20, 20));
        setPreferredSize(new Dimension(1024, 688));
        setBackground(Color.WHITE);
        
        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBorder(new EmptyBorder(30, 20, 30, 20));
        headerPanel.setBackground(Color.WHITE);
        
        JLabel titleLabel = new JLabel("All FileHub Tools");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel subtitleLabel = new JLabel("<html><div style='text-align: center; width: 800px;'>" +
            "FileHub empowers you to manage your documents effortlessly, " +
            "providing the tools you need for a streamlined workflow.</div></html>");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        subtitleLabel.setForeground(new Color(70, 70, 70));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        headerPanel.add(subtitleLabel);
        
        // Tools Panel
        JPanel toolsPanel = new JPanel();
        toolsPanel.setLayout(new GridLayout(2, 2, 30, 30));
        toolsPanel.setBorder(new EmptyBorder(20, 40, 40, 40));
        toolsPanel.setBackground(Color.WHITE);
        
        // Create tool panels
        transferPanel = createToolPanel(
            "Transfer File",
            "Send files securely and quickly with just a few clicks.",
            new Color(255, 69, 69),
            getClass().getResource("/transfer.png")
        );
        
        receivePanel = createToolPanel(
            "Receive File",
            "Easily accept incoming files without any hassle.",
            new Color(255, 69, 69),
            getClass().getResource("/receive.png")
        );
    
        cloudPanel = createToolPanel(
            "Cloud Backup",
            "Automatically back up your files to the cloud for secure storage.",
            new Color(255, 69, 69),
            getClass().getResource("/cloud.png")
        );
        
        toolsPanel.add(transferPanel);
        toolsPanel.add(receivePanel);
        toolsPanel.add(cloudPanel);
        
        // Add all panels
        add(headerPanel, BorderLayout.NORTH);
        add(toolsPanel, BorderLayout.CENTER);
    }
    
    
    private JPanel createToolPanel(String title, String description, Color iconColor, URL imagePath) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(15, 15));
        panel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(230, 230, 230), 1),
            new EmptyBorder(25, 25, 25, 25)
        ));
        panel.setBackground(Color.WHITE);
        
        // Icon panel
        JPanel iconPanel = new JPanel() {
            private ImageIcon icon;
    
            {
                // Load and resize the image only once
                Image image = new ImageIcon(imagePath).getImage();
                Image resizedImage = image.getScaledInstance(53, 55, Image.SCALE_SMOOTH);
                icon = new ImageIcon(resizedImage);
            }
    
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (icon != null) {
                    // Center the image in the panel
                    int x = (getWidth() - icon.getIconWidth()) / 2;
                    int y = (getHeight() - icon.getIconHeight()) / 2;
                    g.drawImage(icon.getImage(), x, y, this);
                }
            }
        };
        iconPanel.setPreferredSize(new Dimension(53, 55));
        iconPanel.setBackground(Color.WHITE);
        
        // Text panel
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(Color.WHITE);
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        JLabel descLabel = new JLabel("<html><div style='width: 250px;'>" + description + "</div></html>");
        descLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descLabel.setForeground(new Color(70, 70, 70));
        
        textPanel.add(titleLabel);
        textPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        textPanel.add(descLabel);
        
        // Arrow label
        JLabel arrowLabel = new JLabel("→");
        arrowLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        arrowLabel.setForeground(new Color(150, 150, 150));
        
        // Add components to panel
        panel.add(iconPanel, BorderLayout.WEST);
        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(arrowLabel, BorderLayout.EAST);
        
        // Add hover effect
        panel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panel.setBackground(new Color(245, 245, 245));
                textPanel.setBackground(new Color(245, 245, 245));
                iconPanel.setBackground(new Color(245, 245, 245));
            }
            
            public void mouseExited(MouseEvent e) {
                panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                panel.setBackground(Color.WHITE);
                textPanel.setBackground(Color.WHITE);
                iconPanel.setBackground(Color.WHITE);
            }
        });
        
        return panel;
    }
    
}