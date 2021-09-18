package view;

import control.OrderController;
import control.ViewController;
import javax.swing.*;

public class SetFavMealPanel extends ViewPanel{

    private JCheckBox doenerCheckBox;
    private JCheckBox beverageCheckBox;
    private JCheckBox saladCheckBox;
    private JCheckBox pizzaCheckBox;
    private JComboBox pizzaComboBox;
    private JComboBox beverageComboBox;
    private JPanel setFaMealPanel;
    private JButton acceptButton;

    public SetFavMealPanel(ViewController viewController){
        super(viewController);

        acceptButton.addActionListener(e -> {

            OrderController orderController = viewController.getMainController().getOrderController();
            if( doenerCheckBox.isSelected()){ orderController.addFoodToOrder("Doener", null, true); }
            if( saladCheckBox.isSelected()){ orderController.addFoodToOrder("Salad", null, true); }
            if( pizzaCheckBox.isSelected()) { orderController.addFoodToOrder("Pizza", (String) pizzaComboBox.getSelectedItem(), true); }
            if( beverageCheckBox.isSelected()) { orderController.addBeverageToOrder((String) beverageComboBox.getSelectedItem(),true); }
            viewController.setPanel("menuePanel");
        });
    }

    public JPanel getMainPanel(){
        viewController.getMainController().getOrderController().clearFavMeal();
        return setFaMealPanel;
    }
}
