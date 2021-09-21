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
        for (int i = 1; i < 11 && i < viewController.getMainController().getCurrentUser().getLastOrders().length; i++) {
            //textPane1.setText(textPane1.getText() + getInOrders(i-1) + "\n");
        }
        //Todo last Orders werden nicht angezeigt
    }

    /*private String getInOrders(int i) {
        String theString="last order "+i+" : ";
        for (int y = 0;i < viewController.getMainController().getCurrentUser().getLastOrders(i).getMealsInOrder().length + viewController.getMainController().getCurrentUser().getLastOrders(i).getBeveragesInOrder().length-1; i++){
            if(viewController.getMainController().getCurrentUser().getLastOrders(i) instanceof Pizza){
                theString=theString+textPane1.getText() + viewController.getMainController().getCurrentUser().getLastOrders(i).getMealsInOrder(y);
            }else {
                String inOrderY = setInOrderY(y);
                theString=theString+inOrderY;
            }
        }
        return theString;
    }

    private String setInOrderY(int y){
        if( viewController.getMainController().getCurrentUser().getOrder(y,false) instanceof Doener) return "Doener";
        if( viewController.getMainController().getCurrentUser().getOrder(y,false) instanceof Salad) return "Salad";
        return "";
    }*/

    public JPanel getMainPanel(){
        setTextPane1();
        return lastOrdersPanel;
    }
}
