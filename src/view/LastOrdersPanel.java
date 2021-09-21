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
        for (int i = 1; i < 11 && i < viewController.getMainController().getCurrentUser().getLastOrders().length-1; i++) {
            textPane1.setText(textPane1.getText() + getInOrders(i) + "\n");
        }
    }

    private String getInOrders(int i) {
        StringBuilder theString= new StringBuilder("last order " + i + " : ");
        for (int y = 1; i < 11 && i < viewController.getMainController().getCurrentUser().getLastOrders(i).getMealsInOrder().length + viewController.getMainController().getCurrentUser().getLastOrders(i).getBeveragesInOrder().length-1; i++){
            if(viewController.getMainController().getCurrentUser().getOrder(i,false) instanceof Pizza){
                theString.append(textPane1.getText()).append(viewController.getMainController().getCurrentUser().getLastOrders(i).getMealsInOrder(y));
            }else {
                String inOrderY = setInOrderY(y);
                theString.append(inOrderY);
            }
        }
        return theString.toString();
    }

    private String setInOrderY(int y){
        if( viewController.getMainController().getCurrentUser().getOrder(y,false) instanceof Doener) return "Doener";
        if( viewController.getMainController().getCurrentUser().getOrder(y,false) instanceof Salad) return "Salad";
        return "";
    }

    public JPanel getMainPanel(){
        setTextPane1();
        return lastOrdersPanel;
    }
}
