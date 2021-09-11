package view;

import control.App;

import javax.swing.*;

public class MenuePanel extends ViewPanel{
    private JButton newOrderButton;
    private JButton logOutButton;
    private JPanel finalPanel;
    private JButton lastOrderButton;

    public MenuePanel(App mainController, MainWindow parent, MainWindow mainWindow) {
        super(mainController,parent);

        mainController.getCurrentUser().clearOrder();
        newOrderButton.addActionListener( e -> mainWindow.setNewPanel(new OrderPanel(mainController,mainWindow).getMainPanel()));
        logOutButton.addActionListener( e -> mainWindow.setNewPanel(new StartPanel(mainController,parent).getMainPanel()));
        lastOrderButton.addActionListener(e -> mainWindow.setNewPanel(new ProgressPanel(mainController,mainWindow,parent).getMainPanel()));
        //Todo
    }

    public JPanel getMainPanel() {
        return finalPanel;
    }
}
