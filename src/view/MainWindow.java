package view;

import control.App;
import javax.swing.*;

public class MainWindow {

    private final JFrame frame;
    private final App mainController;

    public MainWindow(App control){

        this.mainController = control;

        frame = new JFrame();
        //frame.setContentPane(null); //TODO panel hinzufügen
        frame.setVisible(true);
        frame.setSize(800,800);
    }
}
