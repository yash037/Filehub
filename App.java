import javax.swing.*;  
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class App {  
    public static void main(String args[]) {  
        JFrame f = new JFrame("Label Example");  

        // Heading
        JLabel heading = new JLabel("Welcome to Diddy Party", SwingConstants.CENTER);  
        heading.setBounds(0, 50, 1000, 50);                                                         // x, y, width, height
        heading.setFont(new Font("Arial", Font.BOLD, 36)); 

        // info about application 
        JLabel info = new JLabel("<html>Lorem ipsum dolor sit amet. Et dolorem obcaecati est consectetur nesciunt qui voluptatem dolorem sed vero harum et inventore dolores vel consectetur quae. Qui voluptatibus velit qui labore dignissimos est eaque dolor et porro consequuntur id dignissimos atque.</html>", SwingConstants.CENTER);  
        info.setBounds(150, 120, 700, 100);  
        info.setFont(new Font("Arial", Font.PLAIN, 14)); 

        // Username
        JLabel textLabel = new JLabel("Text:");
        textLabel.setBounds(350, 250, 100, 30);  
        textLabel.setFont(new Font("Arial", Font.PLAIN, 18)); 

        JTextField textField = new JTextField();
        textField.setBounds(450, 250, 200, 30);

        // Password 
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(350, 300, 100, 30);  
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18)); 

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(450, 300, 200, 30);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(450, 350, 200, 30);

        // Action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Project();
            }
        });

        // Add components to the main frame
        f.add(heading);  
        f.add(info);
        f.add(textLabel);
        f.add(textField);
        f.add(passwordLabel);
        f.add(passwordField);
        f.add(loginButton);

        f.setSize(1000, 800);  
        f.setLayout(null);  
        f.setVisible(true);  
    }  
}
