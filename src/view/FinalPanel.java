package view;

import control.App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalPanel extends ViewPanel{
    private JButton newOrderButton;
    private JButton logOutButton;
    private JPanel finalPanel;

    public FinalPanel(App mainController, MainWindow parent, MainWindow mainWindow) {
        super(mainController,parent);

        mainController.getCurrentUser().clearOrder();
        newOrderButton.addActionListener( e -> mainWindow.setNewPanel(new OrderPanel(mainController,mainWindow).getMainPanel()));

        logOutButton.addActionListener( e -> mainWindow.setNewPanel(new StartPanel(mainController,parent).getMainPanel()));
    }

    public JPanel getMainPanel() {
        return finalPanel;
    }
}