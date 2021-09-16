package view;

import control.ViewController;

import javax.swing.*;

public class BeveragePanel extends ViewPanel{

    private JButton backButton;
    private JButton addToCartButton;
    private JComboBox selectBox;
    private JPanel beveragePanel;
    private String selectetTyp;


    public BeveragePanel(ViewController viewController) {
        super(viewController);

        backButton.addActionListener(e -> viewController.setPanel("orderPanel"));


        addToCartButton.addActionListener(e -> {
            selectetTyp=(String)selectBox.getSelectedItem();
            viewController.getMainController().getOrderController().addBeverageToOrder(selectetTyp,false);
        });
    }

    public JPanel getMainPanel() {
        return beveragePanel;
    }
}
