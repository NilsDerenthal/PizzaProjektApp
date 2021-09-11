package view;

import control.App;
import model.food.Doener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoenerPanel extends ViewPanel{
    private JButton backButton;
    private JComboBox doenerSelectionBox;
    private JButton addToCartButtonton;
    private JPanel doenerPanel;

    public DoenerPanel(App maincontroller, MainWindow mainWindow, OrderPanel orderPanel) {
        super(maincontroller, mainWindow);

        backButton.addActionListener( e -> mainWindow.setNewPanel(orderPanel.getMainPanel()));
        addToCartButtonton.addActionListener( e -> mainController.getCurrentUser().addToOrder(new Doener(maincontroller)));
    }

    public JPanel getMainPanel() {
        return doenerPanel;
    }
}
