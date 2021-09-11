package view;

import control.App;


public abstract class ViewPanel {

    protected final App mainController;
    protected final MainWindow mainWindow;

    public ViewPanel (App MainController, MainWindow mainWindow){
        this.mainController = MainController;
        this.mainWindow = mainWindow;
    }
}
