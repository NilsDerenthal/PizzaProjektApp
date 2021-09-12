package view;

import control.OrderController;
import control.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetFavMealPanel extends ViewPanel{

    private JCheckBox doenerCheckBox;
    private JCheckBox beverageCheckBox;
    private JCheckBox saladCheckBox;
    private JCheckBox pizzaCheckBox;
    private JComboBox pizzaComboBox;
    private JComboBox beverageComboBox;
    private JPanel setFaMealPanel;
    private JButton acceptButton;

    public SetFavMealPanel(ViewController viewController, OrderController orderController){
        super(viewController);
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( doenerCheckBox.isSelected()){ orderController.addDoenerToFavOrder(); }
                if( saladCheckBox.isSelected()){ orderController.addSaladToFavOrder(); }
                if( pizzaCheckBox.isSelected()) { orderController.addPizzaToFavOrder((String) pizzaComboBox.getSelectedItem()); }
                if( beverageCheckBox.isSelected()) { orderController.addBeverageToFavOrder((String) beverageComboBox.getSelectedItem()); }
                viewController.setPanel("menuePanel");
            }
        });
    }

    public JPanel getMainPanel(){ return setFaMealPanel; }
}
