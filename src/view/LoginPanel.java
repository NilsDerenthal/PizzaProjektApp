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

        logInButton.addActionListener(e -> {

            boolean success;

            if (!signUpPanel)
                success = logInController.checkLogIn(usernameTextField.getText(), passwordField.getPassword());
            else
                success = logInController.addUser(usernameTextField.getText(), passwordField.getPassword());

            passwordField.setText(null);

            if (success) {
                usernameTextField.setText(null);
            }
        });

        backButton.addActionListener(e -> viewController.setPanel("startPanel"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
