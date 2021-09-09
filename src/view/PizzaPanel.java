package view;

import control.App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaPanel extends ViewPanel {
    private JPanel pizzaPanel;
    private JComboBox pizzaSelectionBox;
    private JButton addToCartButton;
    private JButton backButton;

    public PizzaPanel(App maincontroller, MainWindow mainWindow, OrderPanel orderPanel) {
        super(maincontroller, mainWindow);
        addToCartButton.addActionListener(e -> {
            //TODO Actually make this add pizza to "the cart"
        });
        /**
         * Opens order Panel when go back button is pressed
         */
        backButton.addActionListener(e -> mainWindow.setNewPanel(orderPanel.getMainPanel()));
    }

    public JPanel getMainPanel() {
        return pizzaPanel;
    }
}
