package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaPanel {
    private JPanel pizzaPanel;
    private JComboBox pizzaSelectionBox;
    private JButton addToCartButton;
    private JButton backButton;

    public PizzaPanel() {
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Actually make this add pizza to "the cart"
            }
        });
    }

    public JPanel getMainPanel() {
        return pizzaPanel;
    }
}
