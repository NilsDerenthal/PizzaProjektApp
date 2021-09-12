package view;

import control.ViewController;
import model.Beverage;

import javax.swing.*;

public class BeveragePanel extends ViewPanel{

    private JButton backButton;
    private JButton addToCardButton;
    private JComboBox selectBox;
    private JPanel beveragePanel;
    private String selectetTyp;


    public BeveragePanel(ViewController viewController, MainWindow frame) {
        super(viewController, frame);

        backButton.addActionListener(e -> viewController.setPanel("orderPanel"));


        addToCardButton.addActionListener(e -> {
            selectetTyp=(String)selectBox.getSelectedItem();
            this.viewController.getMainController().getCurrentUser().addBeverageToOrder(new Beverage(selectetTyp));
        });
    }

    public JPanel getMainPanel() {
        return beveragePanel;
    }
}
