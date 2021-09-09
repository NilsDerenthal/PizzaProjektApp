package view;

import control.App;
import model.people.Guest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private App app;

    public SignUpPanel(App maincontroller, MainWindow mainWindow, JPanel parent){
        super(maincontroller,mainWindow);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.addUserToDatabase(new Guest(usernameField.getText(),passwordField.getText()));
            }
        });
        backButton.addActionListener(e -> mainWindow.setNewPanel(parent));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
