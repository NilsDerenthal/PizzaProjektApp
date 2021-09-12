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
    private  final long startT=System.currentTimeMillis();

    public ProgressPanel(ViewController viewController, MainWindow mainWindow){
        super(viewController, mainWindow);
        progressOfOrder();
        menueButton.addActionListener( e -> mainWindow.setNewPanel(new MenuePanel(viewController,mainWindow).getMainPanel()));
    }

    private void progressOfOrder() {
        final long[] progress = {0};
        progressBar1.setStringPainted(true);
        SwingWorker<Void, String> Worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                while(progress[0] <100){
                    progress[0] = (System.currentTimeMillis() - startT) / 60;
                    progressBar1.setString(progress[0] + " %");
                    progressBar1.setValue((int) progress[0]);
                }
                return null;
            }
        };
    }

    public JPanel getMainPanel(){ return progressPanel; }
}
