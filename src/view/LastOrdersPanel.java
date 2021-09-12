package view;

import control.App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LastOrdersPanel extends ViewPanel{

    private JTextPane textPane1;
    private JPanel lastOrdersPanel;
    private JButton goBackButton;

    public LastOrdersPanel(App mainController, MainWindow mainWindow){
        super(mainController,mainWindow);
        goBackButton.addActionListener( e -> mainWindow.setNewPanel(new MenuePanel(mainController,mainWindow).getMainPanel()));
        setTextPane1();
    }

    private void setTextPane1() {
        for (int i = 0; i < 10 && i < mainController.getCurrentUser().getLastOrders().length; i++) {
            textPane1.setText(textPane1.getText() + mainController.getCurrentUser().getLastOrders(i) + "\n");
        }
    }

    public JPanel getMainPanel(){ return lastOrdersPanel; }
}
