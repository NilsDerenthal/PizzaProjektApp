package control;

import view.MainWindow;
import view.OrderPanel;

import javax.swing.*;

public class ViewController {

    private final App mainController;
    private final MainWindow frame;

    private JPanel[] panels;

    public ViewController(App mainController) {
        frame = new MainWindow(mainController);
        this.mainController = mainController;

        panels = new JPanel[]{
                new OrderPanel(mainController, frame).getMainPanel(),
        };
    }

    public void setPanel(String panel) {
        switch (panel) {
            case "orderpanel" -> frame.setNewPanel(panels[0]);
        }
    }
}
