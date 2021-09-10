package view;

import control.App;
import model.people.Guest;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginPanel extends ViewPanel{

    private final boolean signUpPanel;

    private JTextField usernameTextField;
    private JPanel mainPanel;
    private JPasswordField passwordField;
    private JButton goBackButton;
    private JButton logInButton;

    public LoginPanel (App mainController, MainWindow mainWindow, JPanel parent, boolean signUpPanel) {
        super(mainController, mainWindow);

        logInButton.setText(signUpPanel ? "Sign up" : "Log in");

        this.signUpPanel = signUpPanel;
        logInButton.addActionListener(signUpPanel ? e -> checkLogIn() : e -> addUser());
        goBackButton.addActionListener(e -> mainWindow.setNewPanel(parent));
    }

    private void addUser() {
        if(usernameTextField.getText() != null && passwordField.getPassword() != null) {
            String[] usernames = Arrays.stream(mainController.getUsers()).map(Guest::getName).toArray(String[]::new);
            int index = Arrays.binarySearch(usernames, usernameTextField.getText());

            if(index == -1) {
                Guest newUser = new Guest(usernameTextField.getText(), new String(passwordField.getPassword()));
                mainController.addUserToDatabase(newUser);
            }
        }
    }

    private void checkLogIn() {
        String[] usernames = Arrays.stream(mainController.getUsers()).map(Guest::getName).toArray(String[]::new);
        int index = Arrays.binarySearch(usernames, usernameTextField.getText(), String::compareTo);
        String correspondingPassword = mainController.getUsers()[index].getPassword();

        if (correspondingPassword.equals(new String(passwordField.getPassword()))) {
            // correct password
            //TODO
        } else {
            // incorrect password
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
