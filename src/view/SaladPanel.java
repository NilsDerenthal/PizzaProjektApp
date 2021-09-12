package view;

import control.App;
import control.ViewController;
import model.food.Salad;

import javax.swing.*;

public class SaladPanel extends ViewPanel{
    private JButton addToCartButten;
    private JButton backButton;
    private JComboBox saladSelectionBox;
    private JPanel SaladPanel;


    public SaladPanel(ViewController viewController, MainWindow mainWindow, OrderPanel orderPanel) {
        super(viewController, mainWindow);

        backButton.addActionListener(e -> mainWindow.setNewPanel(orderPanel.getMainPanel()));
        //TODO MCV
        addToCartButten.addActionListener( e -> viewController.getMainController().getCurrentUser().addToOrder(new Salad(viewController.getMainController())));
    }

    public JPanel getMainPanel() {
        return SaladPanel;
    }
}
