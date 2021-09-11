package view;

import control.App;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressPanel extends ViewPanel{

    private JPanel progressPanel;
    private JProgressBar progressBar1;
    private JButton backButton;

    public ProgressPanel(App mainController, MainWindow mainWindow,FinalPanel finalPanel){
        super(mainController,mainWindow);
        backButton.addActionListener( e -> mainWindow.setContentPane(finalPanel.getMainPanel()));
    }

    public JPanel getMainPanel(){ return progressPanel; }
}
