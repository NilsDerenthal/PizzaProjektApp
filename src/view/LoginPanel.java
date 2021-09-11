package view;

import control.App;
import model.Order;
import model.people.Guest;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.Year;
import java.util.Arrays;
import java.util.Date;

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
        logInButton.addActionListener(!signUpPanel ? e -> checkLogIn() : e -> addUser(mainWindow));
        goBackButton.addActionListener(e -> mainWindow.setNewPanel(parent));
    }

    private void addUser(MainWindow mainWindow) {
        if(usernameTextField.getText() != null && passwordField.getPassword() != null) {
            int index = binarySearch(usernameTextField.getText());

            if(index == -1 && isUserNameValid()) {
                Guest newUser = new Guest(usernameTextField.getText(), new String(passwordField.getPassword()));
                mainController.addUserToDatabase(newUser);
                mainWindow.setNewPanel(orderPanel.getMainPanel());
            }else{
                JOptionPane.showMessageDialog(this.getMainPanel(),"Username is invalid, try another one");
            }
        }
    }

    private boolean isUserNameValid(){
        if(usernameTextField.getText() != null && passwordField.getPassword() != null) {
            return !usernameTextField.getText().isEmpty() && !usernameTextField.getText().contains(":");
        }
        return false;
    }

    private void checkLogIn() {

        boolean wrongPasswordOrUser = false;

        int index = binarySearch(usernameTextField.getText());
        if (index != -1) {
            String correspondingPassword = mainController.getUsers()[index].getPassword();

            if (correspondingPassword.equals(new String(passwordField.getPassword()))) {
                mainController.setCurrentUser(mainController.getUsers()[index]);
                parent.setNewPanel(orderPanel.getMainPanel());
            } else {
                wrongPasswordOrUser = true;
            }
        } else {
            wrongPasswordOrUser = true;
        }

        if (wrongPasswordOrUser) {
            JOptionPane.showMessageDialog(this.getMainPanel(),"Wrong password or username entered");
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

            System.out.println(m);

            if (comp > 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
