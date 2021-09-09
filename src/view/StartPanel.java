package view;

import control.App;

import javax.swing.*;

public class StartPanel extends ViewPanel{

    private JButton logInButton;
    private JButton signUpButton;
    private JPanel mainPanel;

    public StartPanel(App mainController, MainWindow parent) {

        super(mainController, parent);

        logInButton.addActionListener(e -> {
            parent.setNewPanel(new LoginPanel(mainController, parent, getMainPanel()).getMainPanel());
        });

        signUpButton.addActionListener(e -> {

        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
