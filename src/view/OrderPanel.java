package view;

import control.ViewController;

import javax.swing.*;

public class OrderPanel extends ViewPanel {

    private JPanel orderPanel;
    private JButton pizzaButton;
    private JButton doenerButton;
    private JButton saladButton;
    private JButton buyButton;
    private JButton beverageButton;

    public OrderPanel(ViewController viewController, MainWindow mainWindow) {
        super(viewController, mainWindow);

        pizzaButton.addActionListener(e ->  viewController.setPanel("PizzaPanel"));
        doenerButton.addActionListener(e -> viewController.setPanel("DoenerPanel"));
        saladButton.addActionListener(e -> viewController.setPanel("SaladPanel"));
        buyButton.addActionListener(e -> viewController.setPanel("finalOrderPanel"));
        beverageButton.addActionListener(e -> viewController.setPanel("BeveragePanel"));
    }

    public JPanel getMainPanel() {
        return orderPanel;
    }
}
