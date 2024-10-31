package Controller;

//internal files
import dao.UserDAO;
import model.User;
import service.GenerateOTP;
import service.SendOTPService;
import service.UserService;
import views.ProjectView;
import views.LoginView;
import views.SignUpView;

//UI packages
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

//Hashing packages
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginSignUpController {
    private LoginView loginView;
    private SignUpView signUpView;
    private String verificationCode;
    private String name;
    private String email;
    private String password;
    private User user;

    public LoginSignUpController(LoginView loginView, SignUpView signUpView) {
        this.loginView = loginView;
        this.signUpView = signUpView;

        // Add action listeners
        this.loginView.loginButton.addActionListener(new LoginButtonListener());
        this.signUpView.signupButton.addActionListener(new SignupButtonListener());
        this.signUpView.verifyButton.addActionListener(new VerifyButtonListener());

        // Add toggle button listeners
        this.loginView.toggleButton.addActionListener(new ToggleButtonListener());
        this.signUpView.toggleButton.addActionListener(new ToggleButtonListener());
    }

    class ToggleButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (loginView.isVisible()) {
                loginView.setVisible(false);
                signUpView.setVisible(true);
            } else {
                signUpView.setVisible(false);
                loginView.setVisible(true);
            }
        }
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String email = loginView.loginEmailField.getText();
            String password = new String(loginView.loginPasswordField.getPassword());
            String hashedPassword = sha256(password);

            // Check if all fields are filled
            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(loginView, "Please fill in all required fields.");
                return;
            }
            if (!isEmailExists(email)) {
                JOptionPane.showMessageDialog(loginView, "Email not registered. Please Sign up to create an account");
                return;
            }

            setEmail(email);
            setPassword(hashedPassword);
            try {
                if (UserDAO.isUser(getEmail(), getPassword())) {
                    JOptionPane.showMessageDialog(loginView, "Login successful!");
                    // MenuView menuView = new MenuView(getEmail());
                    // new MenuController(menuView); // Initialize MenuController
                    // menuView.setVisible(true);

                    //main project
                    ProjectView projectview = new ProjectView();
                    new ProjectController(projectview);
                    projectview.setVisible(true);

                    // Close the current frame
                    loginView.dispose();
                } else {
                    JOptionPane.showMessageDialog(loginView, "Invalid password.");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class SignupButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = signUpView.signupNameField.getText();
            String email = signUpView.signupEmailField.getText();
            String password = new String(signUpView.signupPasswordField.getPassword());
            String hashedPassword = sha256(password);
    
            // Check if all fields are filled
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(signUpView, "Please fill in all required fields.");
                return;
            }
    
            // Check if username or email already exists
            if (isUsernameExists(name)) {
                JOptionPane.showMessageDialog(signUpView, "Username already exists.");
                return;
            }
            if (isEmailExists(email)) {
                JOptionPane.showMessageDialog(signUpView, "Email already exists.");
                return;
            }
    
            // Check if password is strong
            if (!isPasswordStrong(password)) {
                JOptionPane.showMessageDialog(signUpView, "Password must be at least 8 characters long, include an uppercase letter, lowercase letter, and a digit.");
                return;
            }
    
            // If all validations pass, proceed with OTP
            setName(name);
            setEmail(email);
            setPassword(hashedPassword);
            setVerificationCode(GenerateOTP.getOTP());

            
            JOptionPane.showMessageDialog(signUpView, "Your OTP has been sent, this might take up to 10 seconds, Check your email (including spam)");
    
            if (SendOTPService.sendOTP(getName(), getEmail(), getVerificationCode())) {
                  // Display OTP dialog
                  signUpView.showOtpDialog(email);
            } else {
                JOptionPane.showMessageDialog(signUpView, "There was an error sending the OTP. Try Signing Again!");
            }
        }
    }
    
    class VerifyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String enteredCode = signUpView.getOtpCode();
    
            if (getVerificationCode().trim().equals(enteredCode)) {
                setUser(new User(getName(), getEmail(), getPassword()));
                UserService.saveUser(getUser());
                JOptionPane.showMessageDialog(signUpView, "Signup successful for " + getName() + "!");

                //main project
                ProjectView projectview = new ProjectView();
                new ProjectController(projectview);
                projectview.setVisible(true);

                signUpView.dispose(); // Close signUpView
            } else {
                JOptionPane.showMessageDialog(signUpView, "Invalid verification code.");
            }
        }
    }

    //method to check user credentials from DB 
    public boolean isUsernameExists(String username) {
        try {
            return UserDAO.isUsernameExists(username);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(signUpView, "Database error occurred. isUsernameExists");
            return false;
        }
    }
    public boolean isEmailExists(String email) {
        try {
            return UserDAO.isEmailExists(email);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(signUpView, "Database error occurred.");
            return false;
        }
    }
    public boolean isPasswordStrong(String password) {
        if (password.length() < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isDigit(c)) hasDigit = true;
        }
        return hasUpper && hasLower && hasDigit;
    } 

    //hash function to store password in SHA256 format
    
    public static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }   
}

