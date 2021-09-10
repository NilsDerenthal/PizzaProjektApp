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
            parent.setNewPanel(new LoginPanel(mainController, parent, getMainPanel(), false).getMainPanel());
        });

        signUpButton.addActionListener(e -> {
            parent.setNewPanel(new LoginPanel(mainController, parent, getMainPanel(), true).getMainPanel());
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
