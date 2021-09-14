package view;

import control.ViewController;

import javax.swing.*;

public class DoenerPanel extends ViewPanel{
    private JButton backButton;
    private JComboBox doenerSelectionBox;
    private JButton addToCartButtonton;
    private JPanel doenerPanel;

    public DoenerPanel(ViewController viewController) {
        super(viewController);

        backButton.addActionListener( e -> viewController.setPanel("orderPanel"));
        addToCartButtonton.addActionListener( e -> viewController.getMainController().getOrderController().addFoodToOrder("Doener", null,false));
    }

    public JPanel getMainPanel() {
        return doenerPanel;
    }
}
