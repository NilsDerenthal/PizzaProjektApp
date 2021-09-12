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

    public OrderPanel(ViewController viewController) {
        super(viewController);

        pizzaButton.addActionListener(e ->  viewController.setPanel("pizzaPanel"));
        doenerButton.addActionListener(e -> viewController.setPanel("doenerPanel"));
        saladButton.addActionListener(e -> viewController.setPanel("saladPanel"));
        buyButton.addActionListener(e -> viewController.setPanel("finalOrderPanel"));
        beverageButton.addActionListener(e -> viewController.setPanel("beveragePanel"));
    }

    public JPanel getMainPanel() {
        return orderPanel;
    }
}
