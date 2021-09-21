package view;

import control.ViewController;
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

        newOrderButton.addActionListener(e -> {
            viewController.setPanel("orderPanel");
            viewController.getMainController().getCurrentUser().makeNewOrder(false);
        });

        orderFavouriteMealButton.addActionListener(e -> {
            viewController.getMainController().getOrderController().orderFavMeal();
            viewController.setPanel("finalOrderPanel");

        });
        viewFavMealButton.addActionListener(e -> JOptionPane.showMessageDialog(null, setJOptionPane()));
        changeFavMealButton.addActionListener( e -> viewController.setPanel("setFavMealPanel"));
    }

    private String setJOptionPane(){

        StringBuilder string = new StringBuilder();
        string.append("Favourite Order:\n");
        for(int i=0;i < viewController.getMainController().getOrderController().getTheOrder(true).getMealsInOrder().length - 1; i++)
            string.append(viewController.getMainController().getOrderController().getTheOrder(true).getMealsInOrder()[i + 1]).append('\n');

        if(viewController.getMainController().getOrderController().getBeverageOrder(true).length >= 1)
            string.append(viewController.getMainController().getOrderController().getBeverageOrder(true)[1]);

        return string.toString();
    }

    private String setInOrder(int i){
        if( viewController.getMainController().getOrderController().getOrder(i,false) instanceof Doener) return "Doener";
        if( viewController.getMainController().getOrderController().getOrder(i,false) instanceof Salad) return "Salad";
        return "";
    }

    public JPanel getMainPanel() {
        return finalPanel;
    }
}
