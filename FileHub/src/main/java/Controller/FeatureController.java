package Controller;

import views.MainView;
import views.ProfileView;
import views.FeatureView;
import views.TransferView;
import views.ReceiveView;
import views.CloudView;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class FeatureController {
    private final MainView mainView;
    private final FeatureView featureView;
    private final TransferView transferView;
    private final ReceiveView receiveView;
    private final CloudView cloudView;
    private final ProfileView profileView;

    public FeatureController(MainView mainView) {
        this.mainView = mainView;
        this.featureView = mainView.getFeatureView();
        this.transferView = new TransferView();
        this.receiveView = new ReceiveView();
        this.cloudView = new CloudView();
        this.profileView = new ProfileView();

        // Add profile click listener
        mainView.getHeaderView().ProfileListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showView(profileView);
            }
        });

        // Add listeners to the main feature buttons
        featureView.getTransferPanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showView(transferView);
            }
        });

        featureView.getReceivePanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showView(receiveView);
            }
        });

        featureView.getCloudPanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showView(cloudView);
            }
        });

        // Add "Back" button listeners in each view to return to FeatureView
        transferView.addBackButtonListener(e -> showView(featureView));
        receiveView.addBackButtonListener(e -> showView(featureView));
        cloudView.addBackButtonListener(e -> showView(featureView));
        profileView.addBackButtonListener(e -> showView(featureView));
    }

    private void showView(JPanel view) {
        mainView.getContentPanel().removeAll(); 
        mainView.getContentPanel().add(view, BorderLayout.CENTER);
        mainView.revalidate();
        mainView.repaint();
    }
}
