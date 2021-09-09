package view;

import control.App;

import javax.swing.*;

public class FinalOrderPanel extends ViewPanel{
    private JPanel finalOrderPanel;
    private String[] orders;
    private JButton orderButten;

    public FinalOrderPanel(App mainController, MainWindow parent){
        super(mainController,parent);
        orders=new String[1];
        orders[0]="Orders: ";
    }

    private void addOrder(String newOrder){
        String[] tmpNewOrder = new String[orders.length + 2];

        for (int i = 0; i < orders.length; i++)
            tmpNewOrder[i] = orders[i];

        tmpNewOrder[orders.length] = newOrder;
        tmpNewOrder[orders.length+1]="\n";
        orders = tmpNewOrder;
    }

    private void setOrderPanel(){
        for (int i = 0; i < orders.length; i++){
            //textArea1.setText(orders[i]);
        }
    }

    public JPanel getMainPanel() {
        return finalOrderPanel;
    }
}
