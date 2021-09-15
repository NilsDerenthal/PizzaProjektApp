package view;

import control.ViewController;

import javax.swing.*;

public class LastOrdersPanel extends ViewPanel{

    private JTextPane textPane1;
    private JPanel lastOrdersPanel;
    private JButton backButton;

    public LastOrdersPanel(ViewController viewController){
        super(viewController);
        backButton.addActionListener(e -> viewController.setPanel("menuePanel"));
    }

    private void setTextPane1() {
        for (int i = 1; i < 11 && i < viewController.getMainController().getCurrentUser().getLastOrders().length; i++) {
            textPane1.setText(textPane1.getText() + viewController.getMainController().getCurrentUser().getLastOrders(i) + "\n");
        }
    }

    public JPanel getMainPanel(){
        setTextPane1();
        return lastOrdersPanel;
    }
}
