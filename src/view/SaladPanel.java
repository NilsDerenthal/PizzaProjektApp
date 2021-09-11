package view;

import control.App;
import model.food.Salad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaladPanel extends ViewPanel{
    private JButton addToCartButten;
    private JButton backButton;
    private JComboBox saladSelectionBox;
    private JPanel SaladPanel;


    public SaladPanel(App maincontroller, MainWindow mainWindow, OrderPanel orderPanel) {
        super(maincontroller, mainWindow);

        backButton.addActionListener(e -> mainWindow.setNewPanel(orderPanel.getMainPanel()));
        addToCartButten.addActionListener( e -> mainController.getCurrentUser().addToOrder(new Salad(maincontroller)));
    }

    public JPanel getMainPanel() {
        return SaladPanel;
    }
}
