package views;

import javax.swing.*;
import java.awt.*;

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

    public SignUpView() {
        initComponents();
    }

    //ignore this function just used for UI
    private void initComponents() {
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        signupEmailField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        signupButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        toggleButton = new javax.swing.JButton();
        signupPasswordField = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        signupNameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FileHub");

        jPanel1.setBackground(new java.awt.Color(74, 98, 138));
        jPanel1.setPreferredSize(new java.awt.Dimension(512, 768));

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FileHub");

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Empowering Fast, ");

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Secure, and Intuitive File Transfers");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/app.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel5)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel3)
                .addGap(39, 39, 39)
                .addComponent(jLabel5)
                .addGap(117, 117, 117)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(512, 0));

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(74, 98, 138));
        jLabel1.setText("Create an account");

        jLabel6.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(74, 98, 138));
        jLabel6.setText("Email");

        signupEmailField.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        // signupEmailField.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         signupEmailFieldActionPerformed(evt);
        //     }
        // });

        jLabel7.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(74, 98, 138));
        jLabel7.setText("Password");

        signupButton.setBackground(new java.awt.Color(74, 98, 138));
        signupButton.setFont(new java.awt.Font("Cantarell", 1, 20)); // NOI18N
        signupButton.setForeground(new java.awt.Color(255, 255, 255));
        signupButton.setText("Register");
        signupButton.setBorderPainted(false);
        // signupButton.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         signupButtonActionPerformed(evt);
        //     }
        // });

        jLabel8.setText("Already have account?");

        toggleButton.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        toggleButton.setForeground(new java.awt.Color(74, 98, 138));
        toggleButton.setText("Login");
        toggleButton.setBorderPainted(false);
        toggleButton.setContentAreaFilled(false);
        // toggleButton.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         toggleButtonActionPerformed(evt);
        //     }
        // });

        signupPasswordField.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        // signupPasswordField.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         signupPasswordFieldActionPerformed(evt);
        //     }
        // });

        jLabel9.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(74, 98, 138));
        jLabel9.setText("Username");

        signupNameField.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        // signupNameField.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         signupNameFieldActionPerformed(evt);
        //     }
        // });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(signupNameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(signupEmailField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(signupPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(toggleButton))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(138, 138, 138)
                                    .addComponent(signupButton))))
                        .addGap(50, 50, 50))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signupNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signupEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(signupPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(signupButton)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(toggleButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        verificationCodeLabel.setBounds(10, 180, 120, 25);
        verificationCodeLabel.setVisible(false);


        pack();
        setLocationRelativeTo(null);

        // Initialize OTP Dialog
        otpDialog = new JDialog(this, "Enter OTP", true);
        otpDialog.setSize(350, 250);
        otpDialog.setLayout(new BorderLayout());
        otpDialog.getContentPane().setBackground(Color.WHITE);

        verificationCodeField = new JTextField(15);
        verificationCodeField.setFont(new Font("Arial", Font.PLAIN, 14));
        verificationCodeField.setHorizontalAlignment(JTextField.CENTER);
        verificationCodeField.setBackground(new Color(245, 245, 245));
        verificationCodeField.setForeground(new Color(74, 98, 128));
        verificationCodeField.setBorder(BorderFactory.createLineBorder(new Color(74, 98, 128), 2));

        verifyButton = new JButton("Verify");
        verifyButton.setFont(new Font("Arial", Font.BOLD, 14));
        verifyButton.setBackground(new Color(74, 98, 128));
        verifyButton.setForeground(Color.WHITE);
        verifyButton.setFocusPainted(false);

        // Other layout setups for jPanel3 and main frame...
        pack();
        setLocationRelativeTo(null);
    }

    public void showOtpDialog(String email) {
        // Clear any existing components from OTP dialog in case of repeated calls
        otpDialog.getContentPane().removeAll();
        
        // Panel for OTP instructions and field
        JPanel otpPanel = new JPanel();
        otpPanel.setLayout(new GridLayout(5, 1, 10, 10));
        otpPanel.setBackground(Color.WHITE);
        
        // Additional spacing for center alignment and better layout
        otpPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        // Centering text alignment for labels
        JLabel verificationCodeLabel = new JLabel("Verification Code", JLabel.CENTER);
        verificationCodeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        verificationCodeLabel.setForeground(new Color(74, 98, 128));
    
        JLabel instructionLabel1 = new JLabel("Please type the verification code sent to", JLabel.CENTER);
        instructionLabel1.setFont(new Font("Arial", Font.PLAIN, 14));
        instructionLabel1.setForeground(new Color(102, 102, 102));
    
        JLabel instructionLabel2 = new JLabel(email, JLabel.CENTER);
        instructionLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
        instructionLabel2.setForeground(new Color(102, 102, 102));
    
        otpPanel.add(verificationCodeLabel);
        otpPanel.add(instructionLabel1);
        otpPanel.add(instructionLabel2);
        otpPanel.add(verificationCodeField);
        otpPanel.add(verifyButton);
    
        otpDialog.add(otpPanel, BorderLayout.CENTER);
    
        otpDialog.pack();
        otpDialog.setLocationRelativeTo(this); 
        otpDialog.setVisible(true); // Ensure dialog is set to visible
    }
    

    public String getOtpCode() {
        return verificationCodeField.getText();
    }

    public JButton getVerifyButton() {
        return verifyButton;
    }


    //ignore -> label name used for UI
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
}
