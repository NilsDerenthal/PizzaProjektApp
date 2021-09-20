package view;

import control.ViewController;
import javax.swing.*;

//TODO Fix Action - Escape should make you go back to orderPanel
public class GeneralOrderPanel extends ViewPanel {

    private JButton backButton;
    private JComboBox<String> orderTypeSelectionBox;
    private JButton addToCartButton;
    private JPanel mainPanel;

    Action goBack = new GoBack(viewController);

    public GeneralOrderPanel (ViewController viewController, String panelType) {
        super(viewController);

        mainPanel.getInputMap().put(KeyStroke.getKeyStroke("e"),"goBack");
        mainPanel.getActionMap().put("goBack",goBack);

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
}
