package view;

import com.formdev.flatlaf.FlatDarkLaf;
import control.App;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow(App control){
        FlatDarkLaf.setup();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new StartPanel(control,this).getMainPanel());
        setVisible(true);
        //setSize(600,400);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screenSize.width/2 - 300, screenSize.height/2 - 200, 600, 400);
    }

    public void setNewPanel (JPanel newPanel) {
        setContentPane(newPanel);
        revalidate();
    }
}
