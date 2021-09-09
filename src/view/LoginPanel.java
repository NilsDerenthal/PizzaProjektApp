package view;

import control.App;

import javax.swing.*;

public class LoginPanel extends ViewPanel{

    private JTextField textField1;
    private JPanel mainPanel;
    private JPasswordField passwordField1;
    private JButton goBackButton;
    private JButton logInButton;

    public LoginPanel (App mainController, MainWindow mainWindow, JPanel parent) {
        super(mainController, mainWindow);

        logInButton.addActionListener(e -> {
            // check if password matches
        });

        goBackButton.addActionListener(e -> mainWindow.setNewPanel(parent));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
