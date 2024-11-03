package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ReceiveView extends JPanel {
    private JButton backButton;

    public ReceiveView() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Receive File View", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        
        backButton = new JButton("Back to Feature View");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        
        add(label, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}

