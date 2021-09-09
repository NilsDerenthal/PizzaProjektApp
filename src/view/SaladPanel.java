package view;

import control.App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaladPanel extends ViewPanel{
    private JButton addToCartButten;
    private JButton backButten;
    private JComboBox saladSelectionBox;
    private JPanel SaladPanel;

    public SaladPanel(App maincontroller, MainWindow mainWindow) {
        super(maincontroller, mainWindow);

    }

    public JPanel getMainPanel() {
        return SaladPanel;
    }
}
