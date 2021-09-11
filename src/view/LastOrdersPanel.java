package view;

import control.App;

import javax.swing.*;

public class LastOrdersPanel extends ViewPanel{

    private JTextPane textPane1;
    private JPanel lastOrdersPanel;
    private JButton goBackButton;

    public LastOrdersPanel(App mainController, MainWindow parent){
        super(mainController,parent);
    }

    public JPanel getMainPanel(){ return lastOrdersPanel; }
}
