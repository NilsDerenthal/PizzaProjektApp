package view;

import control.App;
import control.LogInController;
import control.ViewController;
import model.people.Guest;

import javax.swing.*;

public class LoginPanel extends ViewPanel{

    private JTextField usernameTextField;
    private JPanel mainPanel;
    private JPasswordField passwordField;
    private JButton goBackButton;
    private JButton logInButton;

    public LoginPanel (ViewController viewController, boolean signUpPanel) {
        super(viewController);

        logInButton.setText(signUpPanel ? "Sign up" : "Log in");

        LogInController logInController = viewController.getMainController().getLogInController();

        logInButton.addActionListener(
                !signUpPanel ?
                e -> logInController.checkLogIn(usernameTextField.getText(), passwordField.getPassword()) :
                e -> logInController.addUser(usernameTextField.getText(), passwordField.getPassword())
        );

        goBackButton.addActionListener(e -> viewController.setPanel("startPanel"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
