package view;

import control.App;

public abstract class ViewPanel {

    private final App mainController;
    private final MainWindow parent;

    public ViewPanel (App MainController, MainWindow parent){
        this.mainController = MainController;
        this.parent = parent;
    }
}