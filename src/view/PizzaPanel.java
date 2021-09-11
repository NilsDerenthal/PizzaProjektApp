package view;

import control.App;
import model.food.Pizza;

import javax.swing.*;

public class PizzaPanel extends ViewPanel {

    private JPanel pizzaPanel;
    private JComboBox<String> pizzaSelectionBox;
    private JButton addToCartButton;
    private JButton backButton;

    private Pizza thisPizza;

    public PizzaPanel(App mainController, MainWindow mainWindow, OrderPanel orderPanel) {

        super(mainController, mainWindow);

        thisPizza = new Pizza(mainController);

        for (String topping: thisPizza.getToppings()) {
            pizzaSelectionBox.addItem(topping);
        }

        backButton.addActionListener(e -> mainWindow.setNewPanel(orderPanel.getMainPanel()));

        addToCartButton.addActionListener(e -> {
            String selectedTypeOfPizza = (String) pizzaSelectionBox.getSelectedItem();
            mainController.getCurrentUser().addToOrder(new Pizza(mainController, selectedTypeOfPizza));
        });
    }

    public JPanel getMainPanel() {
        return pizzaPanel;
    }
}
