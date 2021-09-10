package view;

import control.App;

import javax.swing.*;

public class DoenerPanel extends ViewPanel{
    private JButton backButton;
    private JComboBox doenerSelectionBox;
    private JButton addToCartButtonton;
    private JPanel doenerPanel;

    public DoenerPanel(App maincontroller, MainWindow mainWindow, OrderPanel orderPanel) {
        super(maincontroller, mainWindow);

        backButton.addActionListener(e -> mainWindow.setNewPanel(orderPanel.getMainPanel()));
    }

    public JPanel getMainPanel() {
        return doenerPanel;
    }
}
