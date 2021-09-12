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

    private String selectedPizzaType;

    public PizzaPanel(ViewController viewController, MainWindow frame, OrderController orderController) {
        super(viewController, frame);

        for (String s: Pizza.getToppings()) {
            pizzaSelectionBox.addItem(s);
        }

        backButton.addActionListener(e -> viewController.setPanel("orderPanel"));

        addToCartButton.addActionListener(e -> {
            selectedPizzaType = (String) pizzaSelectionBox.getSelectedItem();
            orderController.addPizzaToOrder(selectedPizzaType);
            //Todo
        });
    }

    public JPanel getMainPanel() {
        return pizzaPanel;
    }
}
