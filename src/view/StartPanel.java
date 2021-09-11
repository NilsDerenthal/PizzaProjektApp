package view;

import control.App;

import javax.swing.*;

public class StartPanel extends ViewPanel{

    private JButton logInButton;
    private JButton signUpButton;
    private JPanel mainPanel;

    public StartPanel(App mainController, MainWindow parent) {

        super(mainController, parent);

        OrderPanel orderPanel = new OrderPanel(mainController, parent);

        logInButton.addActionListener(e -> {
            parent.setNewPanel(new LoginPanel(mainController, mainController.getLogInController(), parent, getMainPanel(), false, orderPanel).getMainPanel());
        });

        signUpButton.addActionListener(e -> {
            parent.setNewPanel(new LoginPanel(mainController, mainController.getLogInController(), parent, getMainPanel(), true, orderPanel).getMainPanel());
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
