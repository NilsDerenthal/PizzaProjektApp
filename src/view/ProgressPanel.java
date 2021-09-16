package view;

import control.ViewController;
import model.food.Pizza;
import javax.swing.*;
import java.util.List;

public class ProgressPanel extends ViewPanel{

    private JPanel progressPanel;
    private JProgressBar progressBar1;
    private JButton menueButton;
    private int processDuration;

    public ProgressPanel(ViewController viewController){
        super(viewController);

        menueButton.addActionListener(e ->  viewController.setPanel("menuePanel"));
    }

    private int checkDuration(){
        for(int i=0;i<viewController.getMainController().getCurrentUser().getOrder(false).length;i++){
            if(viewController.getMainController().getCurrentUser().getOrder(i,false) instanceof Pizza) return 3000;
        }
        return 1000;
    }

    private void progressOfOrder() {
        progressBar1.setStringPainted(true);

        new SwingWorker<Void, Long>() {

            @Override
            protected Void doInBackground() {

                final long startTime = System.currentTimeMillis();

                while(true){
                    long progress = (System.currentTimeMillis() - startTime) / processDuration;
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
                JOptionPane.showMessageDialog(null,"Your Order is finished");
            }

        }.execute();
    }

    public JPanel getMainPanel(){
        processDuration=checkDuration();
        progressOfOrder();
        System.out.println(processDuration);
        return progressPanel;
    }
}
