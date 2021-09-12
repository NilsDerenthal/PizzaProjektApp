package view;

import control.ViewController;

import javax.swing.*;

public class StartPanel extends ViewPanel{

    private JButton logInButton;
    private JButton signUpButton;
    private JPanel mainPanel;

    public StartPanel(ViewController viewController, MainWindow parent) {

        super(viewController, parent);

        OrderPanel orderPanel = new OrderPanel(viewController, mainWindow);

        //TODO
        logInButton.addActionListener(e -> {
            parent.setNewPanel(new LoginPanel(viewController, viewController.getMainController().getLogInController(), parent, getMainPanel(), false, orderPanel).getMainPanel());
        });

        signUpButton.addActionListener(e -> {
            parent.setNewPanel(new LoginPanel(viewController, viewController.getMainController().getLogInController(), parent, getMainPanel(), true, orderPanel).getMainPanel());
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
