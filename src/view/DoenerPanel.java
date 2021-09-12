package view;

import control.App;
import control.ViewController;
import model.food.Doener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoenerPanel extends ViewPanel{
    private JButton backButton;
    private JComboBox doenerSelectionBox;
    private JButton addToCartButtonton;
    private JPanel doenerPanel;

    public DoenerPanel(ViewController viewController) {
        super(viewController);

        backButton.addActionListener( e -> viewController.setPanel("orderPanel"));
        //TODO
        //addToCartButtonton.addActionListener( e -> mainController.getCurrentUser().addToOrder(new Doener(maincontroller)));
    }

    public JPanel getMainPanel() {
        return doenerPanel;
    }
}
