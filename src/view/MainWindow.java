package view;

import com.formdev.flatlaf.FlatDarkLaf;
import control.App;
import javax.swing.*;

public class MainWindow extends JFrame {

    private final App mainController;

    public MainWindow(App control){

        FlatDarkLaf.setup();

        this.mainController = control;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new StartPanel(mainController,this).getMainPanel());
        setVisible(true);
        setSize(800,800);
    }

    public void setNewPanel (JPanel newPanel) {
        setContentPane(newPanel);
        revalidate();
    }
}
