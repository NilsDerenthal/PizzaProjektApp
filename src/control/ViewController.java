package control;

import model.Beverage;
import view.*;

import javax.swing.*;

public class ViewController {

    private final App mainController;
    private final MainWindow frame;

    private ViewPanel[] panels;

    public ViewController(App mainController) {
        frame = new MainWindow(mainController);
        this.mainController = mainController;

        panels = new ViewPanel[]{
                new StartPanel(this,frame),
                new OrderPanel(this, frame),
                new PizzaPanel(this, frame),
                new DoenerPanel(this, frame),
                new BeveragePanel(this, frame),
                new MenuePanel(this,frame),
                new LastOrdersPanel(this, frame)
        };

        setPanel("startPanel");
    }

    public void setPanel(String panel) {
        switch (panel) {
            case "lastOrdersPanel" -> frame.setNewPanel(panels[6].getMainPanel());
            case "startPanel" -> frame.setNewPanel(panels[0].getMainPanel());
            case "orderPanel"  -> frame.setNewPanel(panels[1].getMainPanel());
            case "PizzaPanel"  -> frame.setNewPanel(panels[2].getMainPanel());
            case "DoenerPanel" -> frame.setNewPanel(panels[3].getMainPanel());
            case "beveragePanel" -> frame.setNewPanel(panels[4].getMainPanel());
            case "menuePanel" -> frame.setNewPanel(panels[5].getMainPanel());
        }
    }

    public App getMainController() {
        return mainController;
    }
}
