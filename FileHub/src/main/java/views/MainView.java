package views;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private FeatureView featureView;
    private JPanel contentPanel; 
    private HeaderView header;

    public MainView() {
        initComponents();
    }

    public FeatureView getFeatureView() {
        return featureView;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public HeaderView getHeaderView() {
        return header;
    }

    private void initComponents() {
        setTitle("FileHub");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        header = new HeaderView();
        featureView = new FeatureView();

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(featureView, BorderLayout.CENTER); // Set FeatureView as initial content

        add(header, BorderLayout.NORTH); 
        add(contentPanel, BorderLayout.CENTER); // Add content panel in center
    }
}
