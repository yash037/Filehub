package filehub;

import javax.swing.*;

public class ProjectPage extends JFrame {
    public ProjectPage() {
        setTitle("Project Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel label = new JLabel("Welcome to the Project Page", SwingConstants.CENTER);
        add(label);
        
        setVisible(true);
    }
}

