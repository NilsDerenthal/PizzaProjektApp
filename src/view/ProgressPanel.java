package view;

import control.App;
import model.food.Pizza;

import javax.swing.*;

public class ProgressPanel extends ViewPanel{

    private JPanel progressPanel;
    private JProgressBar progressBar1;
    private JButton menueButton;
    private Pizza pizza;

    public ProgressPanel(App mainController, MainWindow mainWindow,MainWindow parent){
        super(mainController,mainWindow);
        if(testPizza()>0){  } //TODO
        menueButton.addActionListener( e -> mainWindow.setContentPane(new MenuePanel(mainController,parent,mainWindow).getMainPanel()));
    }

    private int testPizza(){
        for(int i=0;i<mainController.getCurrentUser().getOrder().length;i++){
            if(mainController.getCurrentUser().getOrder(i).getClass() == pizza.getClass()){
                return i;
            }
        }
        return -1;
    }

    public JPanel getMainPanel(){ return progressPanel; }
}
