package view;

import control.App;
import model.food.Pizza;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressPanel extends ViewPanel{

    private JPanel progressPanel;
    private JProgressBar progressBar1;
    private JButton menueButton;
    private Pizza pizza;

    public ProgressPanel(App mainController, MainWindow mainWindow){
        super(mainController,mainWindow);
        //if(testPizza()>0){  } //TODO
        //menueButton.addActionListener( e -> mainWindow.setContentPane(new MenuePanel(mainController,mainWindow).getMainPanel()));
        menueButton.addActionListener( e -> mainWindow.setNewPanel(new MenuePanel(mainController,mainWindow).getMainPanel()));
    }

    /*private int testPizza(){
        if(mainController.getCurrentUser().getOrder()!=null) {
            for (int i = 0; i < mainController.getCurrentUser().getOrder().length; i++) {
                if (mainController.getCurrentUser().getOrder(i).getClass() == pizza.getClass()) {
                    return i;
                }
            }       //Todo
        }
        return -1;
    }*/

    public JPanel getMainPanel(){ return progressPanel; }
}
