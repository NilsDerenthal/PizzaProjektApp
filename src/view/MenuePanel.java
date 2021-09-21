package view;

import control.ViewController;
import model.Beverage;
import model.food.Doener;
import model.food.Pizza;
import model.food.Salad;

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
        lastOrdersButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "This Feature isn't implemented, yet",":(",JOptionPane.INFORMATION_MESSAGE));
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
        for(int i=0;i<viewController.getMainController().getOrderController().getTheOrder(true).getMealsInOrder().length-1;i++) setJOptionPaneI(i,theString);
        if(viewController.getMainController().getOrderController().getBeverageOrder(true).length>=1) theString=theString+viewController.getMainController().getOrderController().getBeverageOrder(true);
        return theString;
    }
    //Todo fix

    private String setJOptionPaneI(int i,String theString){
        if(viewController.getMainController().getOrderController().getOrder(i,true) instanceof Pizza) {
            theString=theString+viewController.getMainController().getOrderController().getOrder(i,true)+" , ";
        }else{
            theString=theString+setInOrderI(i)+" , ";
        }
        return theString;
    }

    private String setInOrderI(int i){
        if( viewController.getMainController().getOrderController().getOrder(i,false) instanceof Doener) return "Doener";
        if( viewController.getMainController().getOrderController().getOrder(i,false) instanceof Salad) return "Salad";
        return "";
    }

    public JPanel getMainPanel() {
        return finalPanel;
    }
}
