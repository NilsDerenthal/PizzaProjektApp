package view;

import control.App;
import control.LogInController;
import model.people.Guest;

import javax.swing.*;

public class LoginPanel extends ViewPanel{

    private JTextField usernameTextField;
    private JPanel mainPanel;
    private JPasswordField passwordField;
    private JButton goBackButton;
    private JButton logInButton;

    private final OrderPanel orderPanel;

    public LoginPanel (App mainController, LogInController logInController, MainWindow mainWindow, JPanel parent, boolean signUpPanel, OrderPanel orderPanel) {
        super(mainController, mainWindow);

        logInButton.setText(signUpPanel ? "Sign up" : "Log in");
        this.orderPanel = orderPanel;

        logInButton.addActionListener(
                !signUpPanel ?
                e -> logInController.checkLogIn(usernameTextField.getText(), passwordField.getPassword()) :
                e -> logInController.addUser(usernameTextField.getText(), passwordField.getPassword())
        );

        goBackButton.addActionListener(e -> mainWindow.setNewPanel(parent));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
