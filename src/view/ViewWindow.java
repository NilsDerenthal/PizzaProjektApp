package view;

import control.MainController;

import javax.swing.*;

public class ViewWindow {

    private JFrame jFrame;
    private MainController control;

    public ViewWindow(MainController control){
        this.control = control;
        jFrame = new JFrame();
        jFrame.setContentPane(new GUIForm1(control).getMainPanel());
        jFrame.setVisible(true);
        jFrame.setSize(800,800);
    }
}
