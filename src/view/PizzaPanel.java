package view;

import control.App;
import control.ViewController;
import model.food.Pizza;

import javax.swing.*;

public class PizzaPanel extends ViewPanel {

    private JPanel pizzaPanel;
    private JComboBox<String> pizzaSelectionBox;
    private JButton addToCartButton;
    private JButton backButton;

    private String selectedPizzaType;

    public PizzaPanel(ViewController viewController) {
        super(viewController);

        for (String s: Pizza.getToppings()) {
            pizzaSelectionBox.addItem(s);
        }

        backButton.addActionListener(e -> viewController.setPanel("orderPanel"));

        addToCartButton.addActionListener(e -> {
            selectedPizzaType = (String) pizzaSelectionBox.getSelectedItem();

            //TODO
            //pizza.setTopping(selectedPizzaType);
            //mainController.getCurrentUser().addToOrder(pizza);
        });
    }

    public JPanel getMainPanel() {
        return pizzaPanel;
    }
}
