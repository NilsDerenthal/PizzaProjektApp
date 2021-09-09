package view;

import control.App;
import javax.swing.*;

public class MainWindow extends JFrame {

    private final App mainController;

    public MainWindow(App control){

        this.mainController = control;

        setContentPane(new OrderPanel(mainController,this).getMainPanel());
        setVisible(true);
        setSize(800,800);
    }

    public void setNewPanel (JPanel newPanel) {
        setContentPane(newPanel);
        revalidate();
    }
}
