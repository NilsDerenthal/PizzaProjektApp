package control;

import view.*;

public class ViewController {

    private final App mainController;
    private final MainWindow frame;

    private ViewPanel[] panels;

    public ViewController(App mainController) {
        frame = new MainWindow(mainController);
        this.mainController = mainController;

        panels = new ViewPanel[]{
                new StartPanel(this),
                new OrderPanel(this),
                new GeneralOrderPanel(this, "Pizza"),
                new GeneralOrderPanel(this, "Doener"),
                new GeneralOrderPanel(this, "Beverage"),
                new MenuePanel(this),
                new LastOrdersPanel(this),
                new FinalOrderPanel(this),
                new ProgressPanel(this),
                new GeneralOrderPanel(this, "Salad"),
                new LoginPanel(this, false),
                new LoginPanel(this, true),
                new SetFavMealPanel(this)
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
            case "logInPanel" -> frame.setNewPanel(panels[10].getMainPanel());
            case "signInPanel" -> frame.setNewPanel(panels[11].getMainPanel());
            case "setFavMealPanel" -> frame.setNewPanel(panels[12].getMainPanel());
        }
    }

    public App getMainController() {
        return mainController;
    }
}
