package model.food;

public abstract class Meal {

    protected int price;
    protected App mainController;

    public Meal (App mainController) {
        this.mainController = mainController;
    }
}
