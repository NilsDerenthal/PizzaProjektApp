package view;

import control.ViewController;

import javax.swing.*;

public class StartPanel extends ViewPanel{

    private JButton logInButton;
    private JButton signUpButton;
    private JPanel mainPanel;

    public StartPanel(ViewController viewController) {

        super(viewController);


        logInButton.addActionListener(e -> {
            viewController.setPanel("logInPanel");
        });

        signUpButton.addActionListener(e -> {
            viewController.setPanel("signInPanel");
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
