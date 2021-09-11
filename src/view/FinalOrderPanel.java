package view;

import control.App;
import model.food.Meal;

import javax.swing.*;

public class FinalOrderPanel extends ViewPanel{
    private JPanel finalOrderPanel;
    private JButton buyButten;
    private JButton backButton;
    private JLabel label1;
    private JTextPane textPane1;

    public FinalOrderPanel(App mainController, MainWindow parent){
        super(mainController,parent);
        setTextPane1();
    }

    private void setTextPane1(){
        Meal[] currentOrder=mainController.getCurrentUser().getOrder();
        for(int i=0;i< currentOrder.length;i++){
            textPane1.setText(textPane1.getText()+currentOrder[i]+"\n");
        }
    }

    public JPanel getMainPanel() {
        return finalOrderPanel;
    }
}
