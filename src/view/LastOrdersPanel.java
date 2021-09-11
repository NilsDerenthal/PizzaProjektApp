package view;

import control.App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LastOrdersPanel extends ViewPanel{

    private JTextPane textPane1;
    private JPanel lastOrdersPanel;
    private JButton goBackButton;

    public LastOrdersPanel(App mainController, MainWindow parent){
        super(mainController,parent);
        //goBackButton.addActionListener( e -> parent.setNewPanel(new MenuePanel(mainController,parent))); //Todo
    }

    /*private void setTextPane1(){
        for(int i=0;i<10&&i<mainController.getCurrentUser().getLastMeals().length;i++){
            textPane1.setText(textPane1.getText() + mainController.getCurrentUser().getLastMeals(i) + "\n");
        }
    }*/

    public JPanel getMainPanel(){ return lastOrdersPanel; }
}
