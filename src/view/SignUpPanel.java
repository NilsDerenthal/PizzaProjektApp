package view;

import control.App;
import model.people.Guest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SignUpPanel extends ViewPanel{

    private JTextField usernameField;
    private JTextField passwordField;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton signUpButton;
    private JPanel mainPanel;
    private JButton backButton;
    private StartPanel startpannel;

    public SignUpPanel(App maincontroller, MainWindow mainWindow, JPanel parent){
        super(maincontroller,mainWindow);
        signUpButton.addActionListener( e -> addUser() );
        backButton.addActionListener(e -> mainWindow.setNewPanel(parent));
    }

    private void addUser(){
        if(usernameField.getText() != null && passwordField.getText() != null) {
            String[] usernames = Arrays.stream(mainController.getUsers()).map(Guest::getName).toArray(String[]::new);
            int index = Arrays.binarySearch(usernames,usernameField.getText());
            if(index==-1) {
                Guest newUser = new Guest(usernameField.getText(), passwordField.getText());
                mainController.addUserToDatabase(newUser);
            }
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
