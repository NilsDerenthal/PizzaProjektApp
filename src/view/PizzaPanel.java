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

    public PizzaPanel(App mainController, MainWindow mainWindow, OrderPanel orderPanel) {

        super(mainController, mainWindow);

        backButton.addActionListener(e -> mainWindow.setNewPanel(orderPanel.getMainPanel()));

        addToCartButton.addActionListener(e -> {
            selectetTypOfPizza=(String)pizzaSelectionBox.getSelectedItem();
            mainController.getCurrentUser().addToOrder(new Pizza(mainController,selectetTypOfPizza));
        });
    }

    public JPanel getMainPanel() {
        return pizzaPanel;
    }
}
