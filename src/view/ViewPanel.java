package view;

import control.ViewController;

import javax.swing.*;


public abstract class ViewPanel {

    protected final ViewController viewController;

    public ViewPanel (ViewController viewController){
        this.viewController = viewController;
    }

    public abstract JPanel getMainPanel();
}
