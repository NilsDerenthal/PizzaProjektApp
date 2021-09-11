package view;

import control.App;
import model.Order;
import model.food.Meal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalOrderPanel extends ViewPanel{
    private JPanel finalOrderPanel;
    private JButton buyButten;
    private JButton backButton;
    private JLabel label1;
    private JTextPane textPane1;
    private MainWindow mainWindow;
    private OrderPanel orderPanel;

    public FinalOrderPanel(App mainController, MainWindow parent, MainWindow mainWindow, OrderPanel orderPanel){
        super(mainController,parent);
        this.mainWindow=mainWindow;
        setTextPane1();
        buyButten.addActionListener( e -> buy() );
        backButton.addActionListener( e -> parent.setContentPane(orderPanel.getMainPanel())); //Todo
    }

    private void buy(){
        if(mainController.getCurrentUser().getOrder()!=null) {
            if (mainController.getCurrentUser().getBudget() >= mainController.getCurrentUser().getOrderPrice()) {
                mainController.getCurrentUser().reduceBudget(mainController.getCurrentUser().getOrderPrice());
                mainWindow.setNewPanel(new FinalPanel(mainController, parent, mainWindow).getMainPanel());
            } else {
                JOptionPane.showMessageDialog(this.getMainPanel(), "You haven't enough money");
            }
        }
    }

    private void setTextPane1(){
        if(mainController.getCurrentUser().getOrder()!=null) {
            Meal[] currentOrder = mainController.getCurrentUser().getOrder();
            for (int i = 1; i < currentOrder.length; i++) {
                textPane1.setText(textPane1.getText() + currentOrder[i] + "\n");
                //Todo
            }
        }
        textPane1.setText(textPane1.getText() + "\n" + "Price: " + mainController.getCurrentUser().getOrderPrice() );
    }

    public JPanel getMainPanel() {
        return finalOrderPanel;
    }
}
