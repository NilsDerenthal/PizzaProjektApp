package view;

import control.MainController;

import javax.swing.*;

public class GUIForm1 {

    private MainController controller;

    private JPanel mainPanel;

    public GUIForm1(MainController controller){
        this.controller = controller;

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
