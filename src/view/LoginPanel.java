package view;

import control.App;
import model.Order;
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

    private final OrderPanel orderPanel;

    public LoginPanel (App mainController, MainWindow mainWindow, JPanel parent, boolean signUpPanel, OrderPanel orderPanel) {
        super(mainController, mainWindow);

        logInButton.setText(signUpPanel ? "Sign up" : "Log in");
        this.signUpPanel = signUpPanel;
        this.orderPanel = orderPanel;
        logInButton.addActionListener(signUpPanel ? e -> checkLogIn() : e -> addUser(mainWindow/*,orderpanel*/));
        goBackButton.addActionListener(e -> mainWindow.setNewPanel(parent));
    }

    private void addUser(MainWindow mainWindow) {
        if(usernameTextField.getText() != null && passwordField.getPassword() != null) {
            String[] usernames = Arrays.stream(mainController.getUsers()).map(Guest::getName).toArray(String[]::new);
            int index = Arrays.binarySearch(usernames, usernameTextField.getText());

            if(index == -1) {
                Guest newUser = new Guest(usernameTextField.getText(), new String(passwordField.getPassword()));
                mainController.addUserToDatabase(newUser);
                mainWindow.setNewPanel(orderPanel.getMainPanel());
            }
        }
    }

    private void checkLogIn() {
        int index = binarySearch(usernameTextField.getText());
        String correspondingPassword = mainController.getUsers()[index].getPassword();

        if (correspondingPassword.equals(new String(passwordField.getPassword()))) {
            // correct password
            //TODO
            parent.setNewPanel(orderPanel.getMainPanel());
        } else {
            // incorrect password
        }
    }

    private int binarySearch (String key) {
        Guest[] users = mainController.getUsers();

        int l = users.length - 1;
        int r = 0;

        while (l <= r) {

            int m = (l+r)/2;

            int comp = key.compareTo(users[m].getName());

            if (comp == 0)
                return m;

            if (comp < 0) {
                l = m;
            } else {
                r = m;
            }
        }

        return -1;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
