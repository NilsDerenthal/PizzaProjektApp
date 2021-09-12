package view;

import control.App;
import control.ViewController;
import model.food.Meal;
import model.Beverage;
import model.people.Guest;

import javax.swing.*;

public class FinalOrderPanel extends ViewPanel{
    private JPanel finalOrderPanel;
    private JButton buyButten;
    private JButton backButton;
    private JLabel label1;
    private JTextPane textPane1;
    private MainWindow mainWindow;
    private MainWindow parent;
    private OrderPanel orderPanel;

    public FinalOrderPanel(ViewController viewController, MainWindow parent, MainWindow mainWindow, OrderPanel orderPanel){
        super(viewController,parent);
        this.mainWindow=mainWindow;
        setOrderText();
        buyButten.addActionListener( e -> buy() );
        backButton.addActionListener( e -> parent.setContentPane(orderPanel.getMainPanel()));
    }

    private void buy(){

        Guest currentUser = viewController.getMainController().getCurrentUser();

        if(currentUser.getOrder()!=null) {
            if (currentUser.getBudget() >= currentUser.getOrderPrice()) {
                currentUser.reduceBudget(currentUser.getOrderPrice());
                //TODO MAIN CONTROLLER TO VIEW CONTROLLER BUT XAVER IST WORKING ON THIS
                //mainWindow.setNewPanel(new ProgressPanel(viewController, this.mainWindow).getMainPanel());
            } else {
                JOptionPane.showMessageDialog(this.getMainPanel(), "You haven't enough money");
            }
        }
    }

    private void setOrderText(){

        textPane1.setEditable(false);

        Guest currentUser = viewController.getMainController().getCurrentUser();

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
        textPane1.setText(textPane1.getText() + "\n" + "Price: " + currentUser.getOrderPrice() );
    }

    public JPanel getMainPanel() {
        return finalOrderPanel;
    }
}
