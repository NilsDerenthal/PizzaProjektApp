package view;

import control.App;
import model.food.Pizza;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PizzaPanel extends ViewPanel {
    private JPanel pizzaPanel;
    private JComboBox pizzaSelectionBox;
    private JButton addToCartButton;
    private JButton backButton;
    private String selectetTypOfPizza;

    public PizzaPanel(App maincontroller, MainWindow mainWindow, OrderPanel orderPanel) {
        super(maincontroller, mainWindow);
        addToCartButton.addActionListener(e -> {
            //TODO Actually make this add pizza to "the cart"
        });
        /**
         * Opens order Panel when go back button is pressed
         */
        backButton.addActionListener(e -> mainWindow.setNewPanel(orderPanel.getMainPanel()));
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectetTypOfPizza=(String)pizzaSelectionBox.getSelectedItem();
                mainController.getCurrentUser().addToOrder(new Pizza(maincontroller,selectetTypOfPizza));
            }
        });
    }

    public JPanel getMainPanel() {
        return pizzaPanel;
    }
}
