package view;

import control.App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuePanel extends ViewPanel{
    private JButton newOrderButton;
    private JButton logOutButton;
    private JPanel finalPanel;
    private JButton lastOrderButton;

    public MenuePanel(App mainController, MainWindow mainWindow) {
        super(mainController,mainWindow);
        logOutButton.addActionListener( e -> mainWindow.setNewPanel(new StartPanel(mainController,mainWindow).getMainPanel()));
        lastOrderButton.addActionListener(e -> mainWindow.setNewPanel(new LastOrdersPanel(mainController,mainWindow).getMainPanel()));
        //Todo
        newOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setNewPanel(new OrderPanel(mainController,mainWindow).getMainPanel());
                mainController.getCurrentUser().makeNewOrder();
            }
        });
    }

    public JPanel getMainPanel() {
        return finalPanel;
    }
}
