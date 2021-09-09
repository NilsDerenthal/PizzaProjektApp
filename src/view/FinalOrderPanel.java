package view;

import control.App;

import javax.swing.*;

public class FinalOrderPanel extends ViewPanel{
    private JPanel finalOrderPanel;
    private JButton buyButten;
    private JButton backButton;
    private JLabel label1;
    private JLabel label2;

    public FinalOrderPanel(App mainController, MainWindow parent){
        super(mainController,parent);
        label1.setText("Order:");
    }


    public JPanel getMainPanel() {
        return finalOrderPanel;
    }
}
