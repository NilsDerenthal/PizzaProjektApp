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

            String response;

            if (!signUpPanel)
                response = logInController.checkLogIn(usernameTextField.getText(), passwordField.getPassword());
            else
                response = logInController.addUser(usernameTextField.getText(), passwordField.getPassword());

            passwordField.setText(null);

            if (response == null) {
                usernameTextField.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, response);
            }

        });

        backButton.addActionListener(e -> viewController.setPanel("startPanel"));

        passwordField.addActionListener(e -> logInButton.doClick());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
