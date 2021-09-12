package control;

import model.Beverage;
import view.*;

import javax.swing.*;

public class ViewController {

    private final App mainController;
    private final MainWindow frame;
    private final OrderController orderController;

    private ViewPanel[] panels;

    public ViewController(App mainController) {
        frame = new MainWindow(mainController);
        orderController = new OrderController(mainController);
        this.mainController = mainController;

        panels = new ViewPanel[]{
                new StartPanel(this,frame),
                new OrderPanel(this, frame),
                new PizzaPanel(this, frame,orderController),
                new DoenerPanel(this, frame,orderController),
                new BeveragePanel(this, frame,orderController),
                new MenuePanel(this,frame),
                new LastOrdersPanel(this, frame),
                new FinalOrderPanel(this, frame),
                new ProgressPanel(this, frame),
                new SaladPanel(this,frame,orderController)
        };

        setPanel("startPanel");
    }

    public void setPanel(String panel) {
        switch (panel) {
            case "startPanel" -> frame.setNewPanel(panels[0].getMainPanel());
            case "orderPanel"  -> frame.setNewPanel(panels[1].getMainPanel());
            case "pizzaPanel"  -> frame.setNewPanel(panels[2].getMainPanel());
            case "doenerPanel" -> frame.setNewPanel(panels[3].getMainPanel());
            case "beveragePanel" -> frame.setNewPanel(panels[4].getMainPanel());
            case "menuePanel" -> frame.setNewPanel(panels[5].getMainPanel());
            case "lastOrdersPanel" -> frame.setNewPanel(panels[6].getMainPanel());
            case "finalOrderPanel" -> frame.setNewPanel(panels[7].getMainPanel());
            case "progressPanel" -> frame.setNewPanel(panels[8].getMainPanel());
            case "saladPanel" -> frame.setNewPanel(panels[9].getMainPanel());
        }
    }

    public App getMainController() {
        return mainController;
    }
}
