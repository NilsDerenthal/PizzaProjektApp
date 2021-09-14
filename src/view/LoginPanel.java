package view;

import control.LogInController;
import control.ViewController;

import javax.swing.*;

public class LoginPanel extends ViewPanel{

    private JTextField usernameTextField;
    private JPanel mainPanel;
    private JPasswordField passwordField;
    private JButton backButton;
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

        backButton.addActionListener(e -> viewController.setPanel("startPanel"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
