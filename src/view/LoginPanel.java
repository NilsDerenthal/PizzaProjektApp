package view;

import control.LogInController;
import control.ViewController;

import javax.swing.*;

public class LoginPanel extends ViewPanel{

    private JPanel mainPanel;

    private JTextField usernameTextField;
    private JPasswordField passwordField;

    private JButton backButton;
    private JButton logInButton;

    /**
     * Panel for viewing the log-in
     * @param viewController the viewController Object passed as a reference
     * @param signUpPanel if this panel is a sign up panel or a log-in panel. This decides button labeling and actions.
     */
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

            if (response == null)
                usernameTextField.setText(null);
            else
                JOptionPane.showMessageDialog(null, response);
        });

        backButton.addActionListener(e -> viewController.setPanel("startPanel"));

        passwordField.addActionListener(e -> logInButton.doClick());
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
