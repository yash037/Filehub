package Controller;

import views.LoginView;
import views.MainView;
import views.SignUpView;

import javax.swing.SwingUtilities;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            SignUpView signUpView = new SignUpView();
            new LoginSignUpController(loginView, signUpView);
            loginView.setVisible(true);
        });
    }
}
