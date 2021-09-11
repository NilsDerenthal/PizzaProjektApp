package view;

import control.App;
import model.food.Pizza;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressPanel extends ViewPanel{

    private JPanel progressPanel;
    private JProgressBar progressBar1;
    private JButton backButton;
    private Pizza pizza;

    public ProgressPanel(App mainController, MainWindow mainWindow,FinalPanel finalPanel){
        super(mainController,mainWindow);
        backButton.addActionListener( e -> mainWindow.setContentPane(finalPanel.getMainPanel()));
        if(testPizza()){ } //TODO
    }

    private boolean testPizza(){
        for(int i=0;i<mainController.getCurrentUser().getOrder().length;i++){
            if(mainController.getCurrentUser().getOrder(i).getClass()== pizza.getClass()){
                return true;
            }
        }
        return false;
    }

    public JPanel getMainPanel(){ return progressPanel; }
}
