package view;

import control.App;
import model.food.Pizza;

import javax.swing.*;

public class PizzaPanel extends ViewPanel {
    private JPanel pizzaPanel;
    private JComboBox<String> pizzaSelectionBox;
    private JButton addToCartButton;
    private JButton backButton;
    private String selectedPizzaType;

    private Pizza pizza;

    public PizzaPanel(App mainController, MainWindow mainWindow, OrderPanel orderPanel) {

        super(mainController, mainWindow);

        pizza = new Pizza(mainController);

        for (String s: pizza.getToppings()) {
            pizzaSelectionBox.addItem(s);
        }

        backButton.addActionListener(e -> mainWindow.setNewPanel(orderPanel.getMainPanel()));

        addToCartButton.addActionListener(e -> {
            selectedPizzaType = (String) pizzaSelectionBox.getSelectedItem();

            pizza.setTopping(selectedPizzaType);
            mainController.getCurrentUser().addToOrder(pizza);
        });
    }

    public JPanel getMainPanel() {
        return pizzaPanel;
    }
}
