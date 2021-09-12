package view;

import control.App;
import control.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressPanel extends ViewPanel{

    private JPanel progressPanel;
    private JProgressBar progressBar1;
    private JButton menueButton;
    private long startT=System.currentTimeMillis();

    public ProgressPanel(ViewController viewController, MainWindow mainWindow){
        super(viewController, mainWindow);
        progressOfOrder();
        menueButton.addActionListener( e -> mainWindow.setNewPanel(new MenuePanel(viewController,mainWindow).getMainPanel()));
    }

    private void progressOfOrder() {
        long progress=0;
        progressBar1.setStringPainted(true);
        //while(progress<=100) {
            progress = (System.currentTimeMillis() - startT)/6000;
            progressBar1.setString(progress + " %");
            //Todo
        //}
    }

    public JPanel getMainPanel(){ return progressPanel; }
}
