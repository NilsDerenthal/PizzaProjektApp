package view;

import control.ViewController;

import javax.swing.*;


public abstract class ViewPanel {

    protected final ViewController viewController;
    protected final MainWindow mainWindow;

    public ViewPanel (ViewController viewController, MainWindow mainWindow){
        this.viewController = viewController;
        this.mainWindow = mainWindow;
    }

    public abstract JPanel getMainPanel();
}
