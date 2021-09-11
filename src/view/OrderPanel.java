package view;

import control.App;

import javax.swing.*;

public class OrderPanel extends ViewPanel {

    private JPanel orderPanel;
    private JButton pizzaButton;
    private JButton doenerButton;
    private JButton beverageButton;
    private JButton buyButton;

    public OrderPanel(App maincontroller, MainWindow mainWindow) {
        super(maincontroller, mainWindow);
        /**
         * Opens pizzaPanel when the Pizza button is pressed
         */
        pizzaButton.addActionListener( e ->  mainWindow.setNewPanel(new PizzaPanel(maincontroller, mainWindow, OrderPanel.this).getMainPanel()));
        doenerButton.addActionListener( e -> mainWindow.setNewPanel(new DoenerPanel(maincontroller,mainWindow,OrderPanel.this).getMainPanel()));
        beverageButton.addActionListener( e -> mainWindow.setNewPanel(new SaladPanel(maincontroller,mainWindow,OrderPanel.this).getMainPanel()));
        buyButton.addActionListener(e -> mainWindow.setNewPanel(new FinalOrderPanel(mainController,mainWindow,mainWindow,this).getMainPanel()));
    }

    public JPanel getMainPanel() {
        return orderPanel;
    }
}
