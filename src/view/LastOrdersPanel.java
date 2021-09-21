package view;

import control.ViewController;
import model.food.Doener;
import model.food.Pizza;
import model.food.Salad;

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
        textPane1.setText("");
        if(viewController.getMainController().getCurrentUser().getLastOrders().length>1) {
            for (int i = 1; i < 11 && i < viewController.getMainController().getCurrentUser().getLastOrders().length; i++)
                textPane1.setText(textPane1.getText() + setText(i) + "\n");
        }else{
            textPane1.setText("No last Orders");
        }
    }

    private String setText(int i){

        StringBuilder string = new StringBuilder();
        string.append(" Last Order "+i+" : ");
        for(int j=0;j < viewController.getMainController().getCurrentUser().getLastOrders(i).getMealsInOrder().length - 1; j++)
            string.append(viewController.getMainController().getCurrentUser().getLastOrders(i).getMealsInOrder()[j + 1]).append(" , ");

        for(int j=0;j < viewController.getMainController().getCurrentUser().getLastOrders(i).getBeveragesInOrder().length - 1; j++)
            string.append(viewController.getMainController().getCurrentUser().getLastOrders(i).getBeveragesInOrder()[j + 1]).append(" , ");

        string.append('\n');
        return string.toString();
    }

    public JPanel getMainPanel(){
        setTextPane1();
        return lastOrdersPanel;
    }
}
