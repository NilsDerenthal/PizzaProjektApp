package model;

public class Beverage {

    private double price;
    private String typOfBeverage;

    public Beverage(String type){
        this.typOfBeverage=type;
        price = 2;
    }

    public double getPrice() {
        if(typOfBeverage.equals("Water")){ return price / 2; }
        return price;
    }

    public String getTypOfBeverage() { return typOfBeverage; }
}
