package view;

import control.App;
import control.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
        progressBar1.setStringPainted(true);

        new SwingWorker<Void, Long>() {

            @Override
            protected Void doInBackground() {
                while(true){

                    long progress = (System.currentTimeMillis() - startT) / 600;

                    if (progress >= 100)
                        break;

                    publish(progress);
                }

                return null;
            }

            @Override
            protected void process(List<Long> chunks) {
                long progress = chunks.get(chunks.size() - 1);

                progressBar1.setString(progress + " %");
                progressBar1.setValue((int) progress);
            }

            @Override
            protected void done() {
                // Wird aufgerufen wenn fertig -> "Ihre bestellung ist fertig"?
            }

        }.execute();
    }

    public JPanel getMainPanel(){ return progressPanel; }
}
