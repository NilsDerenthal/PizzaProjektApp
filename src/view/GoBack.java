package view;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.event.ActionEvent;
import control.ViewController;

public class GoBack extends AbstractAction {

    private ViewController viewController;

    public GoBack(ViewController viewController){
        super();
        this.viewController = viewController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        viewController.setPanel("orderPanel");
        System.out.println("test");
    }
}