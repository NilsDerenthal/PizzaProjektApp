package view;

import control.ViewController;
import model.food.Pizza;

import javax.swing.*;

public class GeneralOrderPanel extends ViewPanel{

    private JButton backButton;
    private JComboBox<String> orderTypeSelectionBox;
    private JButton addToCartButton;
    private JPanel mainPanel;

    public GeneralOrderPanel (ViewController viewController, String panelType) {
        super(viewController);

        for (String type: viewController.getMainController().getOrderController().getOrderTypes(panelType)) {
            orderTypeSelectionBox.addItem(type);
        }

        backButton.addActionListener(e -> viewController.setPanel("orderPanel"));

        addToCartButton.addActionListener(e -> {
            String selectedType = (String) orderTypeSelectionBox.getSelectedItem();
            JOptionPane.showMessageDialog(null, orderTypeSelectionBox.getSelectedItem() + " was added to to the cart");
            viewController.getMainController().getOrderController().addFoodToOrder(panelType, selectedType, false);
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
