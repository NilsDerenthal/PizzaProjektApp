package view;

import control.OrderController;
import control.ViewController;
import model.Beverage;

import javax.swing.*;

public class BeveragePanel extends ViewPanel{

    private JButton backButton;
    private JButton addToCardButton;
    private JComboBox selectBox;
    private JPanel beveragePanel;
    private String selectetTyp;


    public BeveragePanel(ViewController viewController, MainWindow frame, OrderController orderController) {
        super(viewController, frame);

        backButton.addActionListener(e -> viewController.setPanel("orderPanel"));


        addToCardButton.addActionListener(e -> {
            selectetTyp=(String)selectBox.getSelectedItem();
            orderController.addBeverageToOrder(selectetTyp);
        });
    }

    public JPanel getMainPanel() {
        return beveragePanel;
    }
}
