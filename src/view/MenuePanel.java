package view;

import control.ViewController;
import model.Beverage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuePanel extends ViewPanel{
    private JButton newOrderButton;
    private JButton logOutButton;
    private JPanel finalPanel;
    private JButton lastOrdersButton;
    private JButton orderFavouriteMealButton;
    private JButton changeFavMealButton;
    private JButton viewFavMealButton;

    public MenuePanel(ViewController viewController) {
        super(viewController);
        logOutButton.addActionListener( e -> viewController.setPanel("startPanel"));
        lastOrdersButton.addActionListener(e -> viewController.setPanel("lastOrdersPanel"));
        newOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.setPanel("orderPanel");
                viewController.getMainController().getCurrentUser().makeNewOrder(false);
            }
        });
        orderFavouriteMealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.getMainController().getOrderController().orderFavMeal();
                viewController.setPanel("finalOrderPanel");
            }
        });
        viewFavMealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,setJOptionPane());
            }
        });
        changeFavMealButton.addActionListener( e -> viewController.setPanel("setFavMealPanel"));
    }

    private String setJOptionPane(){
        String theString="FavOrder: ";
        for(int i=0;i<viewController.getMainController().getOrderController().getTheOrder(true).getMealsInOrder().length;i++) theString=theString+viewController.getMainController().getOrderController().getOrder(i,true)+" , ";
        if(viewController.getMainController().getOrderController().getBeverageOrder(true).length>1) theString=theString+viewController.getMainController().getOrderController().getBeverageOrder(true);
        return theString;
    }

    public JPanel getMainPanel() {
        return finalPanel;
    }
}
