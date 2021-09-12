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


    public SaladPanel(ViewController viewController, MainWindow mainWindow) {
        super(viewController, mainWindow);

        backButton.addActionListener(e -> viewController.setPanel("orderPanel"));
        //TODO MCV
        addToCartButten.addActionListener( e -> viewController.getMainController().getCurrentUser().addToOrder(new Salad(viewController.getMainController())));
    }

    public JPanel getMainPanel() {
        return SaladPanel;
    }
}
