package view;

import control.App;
import control.ViewController;
import model.food.Meal;
import model.Beverage;
import model.people.Guest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class FinalOrderPanel extends ViewPanel{
    private JPanel finalOrderPanel;
    private JButton buyButten;
    private JButton backButton;
    private JLabel label1;
    private JTextPane textPane1;
    private MainWindow mainWindow;
    private OrderPanel orderPanel;

    public FinalOrderPanel (ViewController viewController) {
        super(viewController);
        buyButten.addActionListener( e -> buy() );
        backButton.addActionListener( e -> viewController.setPanel("orderPanel"));
    }

    private void buy(){
        if(viewController.getMainController().getCurrentUser().getOrder()!=null) {
            if (viewController.getMainController().getCurrentUser().getBudget() >= viewController.getMainController().getCurrentUser().getOrderPrice(false)) {
                viewController.getMainController().getCurrentUser().reduceBudget(viewController.getMainController().getCurrentUser().getOrderPrice(isFav()));
                viewController.setPanel("progressPanel");
            } else {
                JOptionPane.showMessageDialog(this.getMainPanel(), "You haven't enough money");
            }
        }
    }

    private boolean isFav(){
        return Arrays.equals(viewController.getMainController().getCurrentUser().getOrder(), viewController.getMainController().getCurrentUser().getFavOrder()) && Arrays.equals(viewController.getMainController().getCurrentUser().getBeverageOrder(), viewController.getMainController().getCurrentUser().getFavBeverageOrder());
    }

    private void setOrderText(){

        textPane1.setEditable(false);

        Guest currentUser = viewController.getMainController().getCurrentUser();

        //Todo

        if(currentUser.getOrder()!=null) {
            Meal[] currentOrder = currentUser.getOrder();
            for (int i = 1; i < currentOrder.length; i++) {
                textPane1.setText(textPane1.getText() + currentOrder[i] + "\n");
            }
        }
        if(currentUser.getBeverageOrder()!=null) {
            Beverage[] currentOrder = currentUser.getBeverageOrder();
            for (int i = 1; i < currentOrder.length; i++) {
                textPane1.setText(textPane1.getText() + currentOrder[i].getTypOfBeverage() + "\n");
            }
        }
        textPane1.setText(textPane1.getText() + "\n" + "Price: " + currentUser.getOrderPrice(isFav()) );
    }

    public JPanel getMainPanel() {
        setOrderText();
        return finalOrderPanel;
    }
}
