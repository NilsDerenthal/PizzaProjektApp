package view;

import control.App;
import model.people.Guest;

import javax.swing.*;
import java.util.Arrays;

public class LoginPanel extends ViewPanel{

    private JTextField usernameTextField;
    private JPanel mainPanel;
    private JPasswordField passwordField;
    private JButton goBackButton;
    private JButton logInButton;

    public LoginPanel (App mainController, MainWindow mainWindow, JPanel parent) {

        super(mainController, mainWindow);

        logInButton.addActionListener(e -> {

            String[] usernames = Arrays.stream(mainController.getUsers()).map(Guest::getName).toArray(String[]::new);
            int index = Arrays.binarySearch(usernames, usernameTextField.getText(), String::compareTo);
            String correspondingPassword = mainController.getUsers()[index].getPassword();

            if (correspondingPassword.equals(new String(passwordField.getPassword()))) {
                // correct password
                //TODO
            } else {
                // incorrect password
            }
        });

        goBackButton.addActionListener(e -> mainWindow.setNewPanel(parent));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
