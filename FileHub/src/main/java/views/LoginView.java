package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.net.URL;

public class LoginView extends JFrame {

    public JTextField userField = new JTextField(20);
    public JPasswordField loginPasswordField = new JPasswordField(20);
    public JButton loginButton = new JButton("Login");
    public JButton toggleButton = new JButton("Sign Up");

    public LoginView() {
        initComponents();
    }

    //ignore this function just used for UI
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("FileHub");
        setSize(1024, 768);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        JPanel leftPanel = createLeftPanel();
        JPanel rightPanel = createRightPanel();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        mainPanel.add(leftPanel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.5;
        mainPanel.add(rightPanel, gbc);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(new Color(74, 98, 138));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("FileHub", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Noto Sans", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);

        JLabel tagline1 = new JLabel("Empowering Fast,", SwingConstants.CENTER);
        tagline1.setFont(new Font("Cantarell", Font.PLAIN, 24));
        tagline1.setForeground(Color.WHITE);

        JLabel tagline2 = new JLabel("Secure, and Intuitive File Transfers", SwingConstants.CENTER);
        tagline2.setFont(new Font("Cantarell", Font.PLAIN, 24));
        tagline2.setForeground(Color.WHITE);

        JLabel imageLabel = new JLabel();
        URL imageUrl = getClass().getResource("/app.png");
        if (imageUrl != null) {
            imageLabel.setIcon(new ImageIcon(imageUrl));
        } else {
            System.out.println("Image not found.");
        }

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        leftPanel.add(titleLabel, gbc);

        gbc.gridy++;
        leftPanel.add(imageLabel, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 5, 0); 
        leftPanel.add(tagline1, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 10, 0); 
        leftPanel.add(tagline2, gbc);


        return leftPanel;
    }

    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel title = new JLabel("Welcome back!", SwingConstants.CENTER);
        title.setFont(new Font("Cantarell", Font.BOLD, 36));
        title.setForeground(new Color(74, 98, 138));

        JLabel emailLabel = new JLabel("Username or Email");
        emailLabel.setFont(new Font("Cantarell", Font.PLAIN, 20));
        emailLabel.setForeground(new Color(74, 98, 138));

        userField = new JTextField(20);
        userField.setFont(new Font("Cantarell", Font.PLAIN, 20));
        userField.setPreferredSize(new Dimension(300, 40));

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Cantarell", Font.PLAIN, 20));
        passwordLabel.setForeground(new Color(74, 98, 138));

        loginPasswordField = new JPasswordField(20);
        loginPasswordField.setFont(new Font("Cantarell", Font.PLAIN, 20));
        loginPasswordField.setPreferredSize(new Dimension(300, 40));

        loginButton = new JButton("Log In");
        loginButton.setFont(new Font("Cantarell", Font.BOLD, 20));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(74, 98, 138));
        loginButton.setBorderPainted(false);

        JLabel registerPrompt = new JLabel("Not Registered Yet?");
        registerPrompt.setFont(new Font("Cantarell", Font.PLAIN, 16));
        registerPrompt.setForeground(Color.GRAY);

        toggleButton = new JButton("Register");
        toggleButton.setFont(new Font("Cantarell", Font.BOLD, 18));
        toggleButton.setForeground(new Color(74, 98, 138));
        toggleButton.setBorderPainted(false);
        toggleButton.setContentAreaFilled(false);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(title, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        rightPanel.add(emailLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        rightPanel.add(userField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        rightPanel.add(passwordLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        rightPanel.add(loginPasswordField, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(loginButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        rightPanel.add(registerPrompt, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        rightPanel.add(toggleButton, gbc);

        return rightPanel;
    }
}
