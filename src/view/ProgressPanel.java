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

    public ProgressPanel(ViewController viewController){
        super(viewController);
        progressOfOrder();
        menueButton.addActionListener(e -> viewController.setPanel("menuePanel"));
    }

    private void progressOfOrder() {
        progressBar1.setStringPainted(true);

        new SwingWorker<Void, Long>() {

            @Override
            protected Void doInBackground() {

                final long startTime = System.currentTimeMillis();

                while(true){
                    long progress = (System.currentTimeMillis() - startTime) / 6000;
                    //Todo länge an bestellung anpassen
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
