package view;

import control.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderPanel extends ViewPanel {

    private JPanel orderPanel;
    private JButton pizzaButton;
    private JButton doenerButton;
    private JButton saladButton;
    private JButton checkoutButton;
    private JButton beverageButton;
    private JButton cancelOrderButton;

    public OrderPanel(ViewController viewController) {
        super(viewController);

        pizzaButton.addActionListener(e ->  viewController.setPanel("pizzaPanel"));
        doenerButton.addActionListener(e -> viewController.setPanel("doenerPanel"));
        saladButton.addActionListener(e -> viewController.setPanel("saladPanel"));
        checkoutButton.addActionListener(e -> viewController.setPanel("finalOrderPanel"));
        beverageButton.addActionListener(e -> viewController.setPanel("beveragePanel"));
        cancelOrderButton.addActionListener(e -> viewController.setPanel("menuePanel"));
    }

    public JPanel getMainPanel() {
        return orderPanel;
    }
}
