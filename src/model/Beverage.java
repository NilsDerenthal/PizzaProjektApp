package model;

import control.App;
import model.food.Meal;

public class Beverage extends Meal {

    private final double price;
    private final String typOfBeverage;

    public Beverage(App mainController, String type){
        super(mainController);
        this.typOfBeverage = type;
        price = 2;
    }

    public double getPrice() {
        if(typOfBeverage.equals("Water")){ return price / 2; }
        return price;
    }

    @Override
    public void makeIt() {
        //TODO ?
    }

    @Override
    public String toString() {
        return getTypOfBeverage();
    }

    public String getTypOfBeverage() { return typOfBeverage; }
}
