package view;

import control.App;
import model.food.Meal;
import model.Beverage;

import javax.swing.*;

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
        setOrderText();
        buyButten.addActionListener( e -> buy() );
        backButton.addActionListener( e -> parent.setContentPane(orderPanel.getMainPanel()));
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

    private void setOrderText(){

        textPane1.setEditable(false);

        if(mainController.getCurrentUser().getOrder()!=null) {
            Meal[] currentOrder = mainController.getCurrentUser().getOrder();
            for (int i = 1; i < currentOrder.length; i++) {
                textPane1.setText(textPane1.getText() + currentOrder[i] + "\n");
                //Todo
            }
        }
        if(mainController.getCurrentUser().getBeverageOrder()!=null) {
            Beverage[] currentOrder = mainController.getCurrentUser().getBeverageOrder();
            for (int i = 1; i < currentOrder.length; i++) {
                textPane1.setText(textPane1.getText() + currentOrder[i].getTypOfBeverage() + "\n");
            }
        }
        textPane1.setText(textPane1.getText() + "\n" + "Price: " + mainController.getCurrentUser().getOrderPrice() );
    }

    public JPanel getMainPanel() {
        return finalOrderPanel;
    }
}
