package view;

import control.App;
import control.OrderController;
import control.ViewController;
import model.food.Pizza;

import javax.swing.*;

public class PizzaPanel extends ViewPanel {

    private JPanel pizzaPanel;
    private JComboBox<String> pizzaSelectionBox;
    private JButton addToCartButton;
    private JButton backButton;

    public PizzaPanel(ViewController viewController) {
        super(viewController);

        for (String s: Pizza.getToppings()) {
            pizzaSelectionBox.addItem(s);
        }

        backButton.addActionListener(e -> viewController.setPanel("orderPanel"));

        addToCartButton.addActionListener(e -> {
            String selectedPizzaType = (String) pizzaSelectionBox.getSelectedItem();
            viewController.getMainController().getOrderController().addFoodToOrder("Pizza", selectedPizzaType, false);
        });
    }

    public JPanel getMainPanel() {
        return pizzaPanel;
    }
}
