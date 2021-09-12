package view;

import control.ViewController;

import javax.swing.*;

public class LastOrdersPanel extends ViewPanel{

    private JTextPane textPane1;
    private JPanel lastOrdersPanel;
    private JButton goBackButton;

    public LastOrdersPanel(ViewController viewController, MainWindow mainWindow){
        super(viewController,mainWindow);
        goBackButton.addActionListener( e -> mainWindow.setNewPanel(new MenuePanel(viewController,mainWindow).getMainPanel()));
    }

    private void setTextPane1() {
        for (int i = 0; i < 10 && i < viewController.getMainController().getCurrentUser().getLastOrders().length; i++) {
            textPane1.setText(textPane1.getText() + viewController.getMainController().getCurrentUser().getLastOrders(i) + "\n");
        }
    }

    public JPanel getMainPanel(){
        //TODO
        setTextPane1();
        return lastOrdersPanel;
    }
}
