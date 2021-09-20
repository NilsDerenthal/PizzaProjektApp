package view;

import control.ViewController;
import model.food.Pizza;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//TODO Fix KeyListener - Escape should make you go back to orderPanel
public class GeneralOrderPanel extends ViewPanel implements KeyListener {

    private JButton backButton;
    private JComboBox<String> orderTypeSelectionBox;
    private JButton addToCartButton;
    private JPanel mainPanel;

    public GeneralOrderPanel (ViewController viewController, String panelType) {
        super(viewController);

        mainPanel.addKeyListener(this);

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

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE) {
            viewController.setPanel("orderPanel");
        }
    }

    //Method needs to be overridden, but is unused here
    @Override
    public void keyPressed(KeyEvent e) {
    }

    //Method needs to be overridden, but is unused here
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
