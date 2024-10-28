import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project {
    public Project() {
        JFrame projectFrame = new JFrame("Project Page");
        projectFrame.setSize(1000, 800);
        projectFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        projectFrame.setLayout(null);  

        // File input field
        JLabel fileLabel = new JLabel("Choose a file:");
        fileLabel.setBounds(50, 50, 150, 30);
        projectFrame.add(fileLabel);

        JTextField fileInput = new JTextField();
        fileInput.setBounds(150, 50, 600, 30);
        projectFrame.add(fileInput);

        JButton browseButton = new JButton("Browse");
        browseButton.setBounds(760, 50, 100, 30);
        projectFrame.add(browseButton);

        // Buttons for Upload and Cancel
        JButton uploadButton = new JButton("Upload");
        uploadButton.setBounds(300, 100, 100, 30);
        projectFrame.add(uploadButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(450, 100, 100, 30);
        projectFrame.add(cancelButton);

        // Space for buffering bar
        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(50, 150, 900, 30);
        progressBar.setStringPainted(true);  // Show percentage
        projectFrame.add(progressBar);

        // Event listener for Browse button
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open file chooser dialog
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    // Set selected file path to text field
                    fileInput.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        // Action listener for Upload button
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate file upload process -> lokesh bhai pleazz
            }
        });

        // Action listener for Cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear file input and progress bar
                fileInput.setText("");
                progressBar.setValue(0);
            }
        });

        projectFrame.setVisible(true);
    }
}
