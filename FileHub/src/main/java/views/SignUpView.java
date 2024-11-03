package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.net.URL;


public class SignUpView extends JFrame {
    public JTextField signupNameField = new JTextField(20);
    public JTextField signupEmailField = new JTextField(20);
    public JPasswordField signupPasswordField = new JPasswordField(20);
    public JButton signupButton = new JButton("Register");
    public JButton verifyButton = new JButton("Verify");
    public JTextField verificationCodeField = new JTextField(20);
    public JLabel verificationCodeLabel = new JLabel("Verification Code:");
    public JButton toggleButton = new JButton("Login");

    private JDialog otpDialog;
    private JLabel instructionLabel2 = new JLabel("your email", SwingConstants.CENTER);

    public SignUpView() {
        initComponents();
    }

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
        
        initializeOtpDialog();
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

        JLabel title = new JLabel("Create an account", SwingConstants.CENTER);
        title.setFont(new Font("Cantarell", Font.BOLD, 36));
        title.setForeground(new Color(74, 98, 138));

        JLabel nameLabel = new JLabel("Username");
        nameLabel.setFont(new Font("Cantarell", Font.PLAIN, 20));
        nameLabel.setForeground(new Color(74, 98, 138));

        signupNameField = new JTextField(20);
        signupNameField.setFont(new Font("Cantarell", Font.PLAIN, 20));
        signupNameField.setPreferredSize(new Dimension(300, 40));

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Cantarell", Font.PLAIN, 20));
        emailLabel.setForeground(new Color(74, 98, 138));

        signupEmailField = new JTextField(20);
        signupEmailField.setFont(new Font("Cantarell", Font.PLAIN, 20));
        signupEmailField.setPreferredSize(new Dimension(300, 40));

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Cantarell", Font.PLAIN, 20));
        passwordLabel.setForeground(new Color(74, 98, 138));

        signupPasswordField = new JPasswordField(20);
        signupPasswordField.setFont(new Font("Cantarell", Font.PLAIN, 20));
        signupPasswordField.setPreferredSize(new Dimension(300, 40));

        signupButton = new JButton("Register");
        signupButton.setFont(new Font("Cantarell", Font.BOLD, 20));
        signupButton.setForeground(Color.WHITE);
        signupButton.setBackground(new Color(74, 98, 138));
        signupButton.setBorderPainted(false);

        JLabel registerPrompt = new JLabel("Already Registerd?");
        registerPrompt.setFont(new Font("Cantarell", Font.PLAIN, 16));
        registerPrompt.setForeground(Color.GRAY);

        toggleButton = new JButton("Login");
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
        rightPanel.add(nameLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        rightPanel.add(signupNameField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        rightPanel.add(emailLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        rightPanel.add(signupEmailField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        rightPanel.add(passwordLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        rightPanel.add(signupPasswordField, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(signupButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        rightPanel.add(registerPrompt, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.WEST;
        rightPanel.add(toggleButton, gbc);

        return rightPanel;
    }
    
    
    

    private void initializeOtpDialog() {
        otpDialog = new JDialog(this, "Enter OTP", true);
        otpDialog.setSize(350, 250);
        otpDialog.getContentPane().setLayout(new BorderLayout()); // Set layout here
        otpDialog.getContentPane().setBackground(Color.WHITE);
    
        verificationCodeField.setFont(new Font("Arial", Font.PLAIN, 14));
        verificationCodeField.setHorizontalAlignment(JTextField.CENTER);
        verificationCodeField.setBackground(new Color(245, 245, 245));
        verificationCodeField.setForeground(new Color(74, 98, 128));
        verificationCodeField.setBorder(BorderFactory.createLineBorder(new Color(74, 98, 128), 2));
    
        verifyButton.setFont(new Font("Arial", Font.BOLD, 14));
        verifyButton.setBackground(new Color(74, 98, 128));
        verifyButton.setForeground(Color.WHITE);
        verifyButton.setFocusPainted(false);
    
        JPanel otpPanel = new JPanel();
        otpPanel.setLayout(new GridLayout(5, 1, 10, 10)); // 5 rows and 1 column
        otpPanel.setBackground(Color.WHITE);
        otpPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        JLabel verificationCodeLabel = new JLabel("Verification Code", JLabel.CENTER);
        verificationCodeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        verificationCodeLabel.setForeground(new Color(74, 98, 128));
    
        JLabel instructionLabel1 = new JLabel("Please type the verification code sent to", JLabel.CENTER);
    
        instructionLabel1.setFont(new Font("Arial", Font.PLAIN, 14));
        instructionLabel1.setForeground(new Color(102, 102, 102));
        instructionLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
        instructionLabel2.setForeground(new Color(102, 102, 102));
    
        otpPanel.add(verificationCodeLabel);
        otpPanel.add(instructionLabel1);
        otpPanel.add(instructionLabel2);
        otpPanel.add(verificationCodeField);
        otpPanel.add(verifyButton);
    
        otpDialog.add(otpPanel, BorderLayout.CENTER); // Use the BorderLayout here
        otpDialog.pack();
        otpDialog.setLocationRelativeTo(this);
    }
    

    public void showOtpDialog(String email) {
        instructionLabel2.setText(email);
        otpDialog.setVisible(true);
    }

    public String getOtpCode() {
        return verificationCodeField.getText();
    }

    public JButton getVerifyButton() {
        return verifyButton;
    }

}
