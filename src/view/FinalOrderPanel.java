package view;

import control.ViewController;
import model.food.Doener;
import model.food.Meal;
import model.Beverage;
import model.food.Pizza;
import model.food.Salad;
import model.people.Guest;

import javax.swing.*;
import java.util.Arrays;

public class FinalOrderPanel extends ViewPanel{
    private JPanel finalOrderPanel;
    private JButton orderButton;
    private JButton backButton;
    private JLabel label1;
    private JTextPane textPane1;
    private MainWindow mainWindow;
    private OrderPanel orderPanel;

    public FinalOrderPanel (ViewController viewController) {
        super(viewController);
        orderButton.addActionListener(e -> buy() );
        backButton.addActionListener( e -> viewController.setPanel("orderPanel"));
    }

    private void buy(){
        if(viewController.getMainController().getCurrentUser().getOrder(false) != null && !orderIsEmty()) {
            if (viewController.getMainController().getCurrentUser().getBudget() >= viewController.getMainController().getCurrentUser().getOrderPrice(false)) {
                viewController.getMainController().getCurrentUser().reduceBudget(viewController.getMainController().getCurrentUser().getOrderPrice(isFav()));
                viewController.getMainController().getOrderController().addTolastOrders();
                viewController.setPanel("progressPanel");
            } else {
                JOptionPane.showMessageDialog(this.getMainPanel(), "You haven't enough money");
            }
        }else{
            JOptionPane.showMessageDialog(null,"your Order is emty");
        }
    }

    private boolean orderIsEmty(){
        return viewController.getMainController().getCurrentUser().getOrder(false).length < 2;
    }

    private boolean isFav(){
        return Arrays.equals(viewController.getMainController().getCurrentUser().getOrder(false), viewController.getMainController().getCurrentUser().getOrder(true)) && Arrays.equals(viewController.getMainController().getCurrentUser().getBeverageOrder(false), viewController.getMainController().getCurrentUser().getBeverageOrder(true));
    }

    private void setOrderText(){

        textPane1.setText(null);
        textPane1.setEditable(false);

        Guest currentUser = viewController.getMainController().getCurrentUser();

        if(currentUser.getOrder(false)!=null) {
            String inOrderI;
            Meal[] currentOrder = currentUser.getOrder(false);
            for (int i = 1; i < currentOrder.length; i++) {
                if(viewController.getMainController().getCurrentUser().getOrder(i,false) instanceof Pizza){
                    textPane1.setText(textPane1.getText() + currentOrder[i] + "\n");
                }else {
                    inOrderI = setInOrderI(i);
                    textPane1.setText(textPane1.getText() + inOrderI + "\n");
                }
            }
        }
        if(currentUser.getBeverageOrder(false)!=null) {
            Beverage[] currentOrder = currentUser.getBeverageOrder(false);
            for (int i = 1; i < currentOrder.length; i++) {
                textPane1.setText(textPane1.getText() + currentOrder[i].getTypOfBeverage() + "\n");
            }
        }
        textPane1.setText(textPane1.getText() + "\n" + "Price: " + currentUser.getOrderPrice(isFav()) );
    }

    private String setInOrderI(int i){
        if( viewController.getMainController().getCurrentUser().getOrder(i,false) instanceof Doener) return "Doener";
        if( viewController.getMainController().getCurrentUser().getOrder(i,false) instanceof Salad) return "Salad";
        return "";
    }

    public JPanel getMainPanel() {
        setOrderText();
        return finalOrderPanel;
    }
}
