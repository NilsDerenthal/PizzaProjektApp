package model.food;

import control.App;

public abstract class Meal {

    protected double price;
    protected App mainController;

    public Meal (App mainController) {
        this.mainController = mainController;
    }

    public double getPrice(){ return price; }

    public void makeIt(){}
}
