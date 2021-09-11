package view;

import control.App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderPanel extends ViewPanel {

    private JPanel orderPanel;
    private JButton pizzaButton;
    private JButton doenerButton;
    private JButton beverageButton;
    private JButton checkOutButton;

    public OrderPanel(App maincontroller, MainWindow mainWindow) {
        super(maincontroller, mainWindow);
        /**
         * Opens pizzaPanel when the Pizza button is pressed
         */
        pizzaButton.addActionListener( e ->  mainWindow.setNewPanel(new PizzaPanel(maincontroller, mainWindow, OrderPanel.this).getMainPanel()));
        doenerButton.addActionListener( e -> mainWindow.setNewPanel(new DoenerPanel(maincontroller,mainWindow,OrderPanel.this).getMainPanel()));
        beverageButton.addActionListener( e -> mainWindow.setNewPanel(new SaladPanel(maincontroller,mainWindow,OrderPanel.this).getMainPanel()));
        checkOutButton.addActionListener( e -> mainWindow.setNewPanel(new StartPanel(mainController,mainWindow).getMainPanel()));
    }

    public JPanel getMainPanel() {
        return orderPanel;
    }
}
