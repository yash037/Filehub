package views;

import javax.swing.*;
import java.awt.*;

public class ProjectView extends JFrame {

    private JLabel displayLabel;

    public ProjectView() {
        initComponents();
    }

    // Initialize UI components
    private void initComponents() {
        setTitle("Simple Project View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setLayout(new BorderLayout()); 
        
        setLocationRelativeTo(null);

        // Create a label with the desired text
        displayLabel = new JLabel("Lokesh aur Utkarsh bhai plez 🙏🙏", SwingConstants.CENTER);
        displayLabel.setFont(new Font("Arial", Font.BOLD, 48)); 
        displayLabel.setPreferredSize(new Dimension(1024, 768));

        // Add the label to the frame
        add(displayLabel, BorderLayout.CENTER);

        // Set the frame to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProjectView::new);
    }
}
