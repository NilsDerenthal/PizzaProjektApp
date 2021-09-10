package view;

import control.App;

public abstract class ViewPanel {

    protected App mainController;
    protected final MainWindow parent;

    public ViewPanel (App MainController, MainWindow parent){
        this.mainController = MainController;
        this.parent = parent;
    }
}
