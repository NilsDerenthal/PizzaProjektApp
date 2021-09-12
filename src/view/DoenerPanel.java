package view;

import control.App;
import control.OrderController;
import control.ViewController;
import model.food.Doener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoenerPanel extends ViewPanel{
    private JButton backButton;
    private JComboBox doenerSelectionBox;
    private JButton addToCartButtonton;
    private JPanel doenerPanel;

    public DoenerPanel(ViewController viewController, OrderController orderController) {
        super(viewController);

        backButton.addActionListener( e -> viewController.setPanel("orderPanel"));
        addToCartButtonton.addActionListener( e -> orderController.addDoenerToOrder());
    }

    public JPanel getMainPanel() {
        return doenerPanel;
    }
}
