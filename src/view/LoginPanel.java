package view;

import control.App;
import model.people.Guest;

import javax.swing.*;

public class LoginPanel extends ViewPanel{

    private JTextField usernameTextField;
    private JPanel mainPanel;
    private JPasswordField passwordField;
    private JButton goBackButton;
    private JButton logInButton;

    private final OrderPanel orderPanel;

    public LoginPanel (App mainController, MainWindow mainWindow, JPanel parent, boolean signUpPanel, OrderPanel orderPanel) {
        super(mainController, mainWindow);

        logInButton.setText(signUpPanel ? "Sign up" : "Log in");
        this.orderPanel = orderPanel;
        logInButton.addActionListener(!signUpPanel ? e -> checkLogIn() : e -> addUser());
        goBackButton.addActionListener(e -> mainWindow.setNewPanel(parent));
    }

    private void addUser() {
        if(usernameTextField.getText() != null && passwordField.getPassword() != null) {
            int index = mainController.binarySearch(usernameTextField.getText());

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

        int index = mainController.binarySearch(usernameTextField.getText());

        if (index != -1) {
            String correspondingPassword = mainController.getUsers()[index].getPassword();

            if (correspondingPassword.equals(new String(passwordField.getPassword()))) {
                mainController.setCurrentUser(mainController.getUsers()[index]);
                mainWindow.setNewPanel(orderPanel.getMainPanel());
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

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
