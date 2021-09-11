package view;

import control.App;
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

    public FinalOrderPanel(App mainController, MainWindow parent,MainWindow mainWindow){
        super(mainController,parent);
        this.mainWindow=mainWindow;
        setTextPane1();
        buyButten.addActionListener( e -> buy() );
        //backButton.addActionListener( ); //Todo
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
            for (int i = 0; i < currentOrder.length; i++) {
                textPane1.setText(textPane1.getText() + currentOrder[i] + "\n");
                //Todo
            }
        }
    }

    public JPanel getMainPanel() {
        return finalOrderPanel;
    }
}
