package model;

public class Beverage {

    private final double price;
    private final String typOfBeverage;

    public Beverage(String type){
        this.typOfBeverage = type;
        price = 2;
    }

    public double getPrice() {
        if(typOfBeverage.equals("Water")){ return price / 2; }
        return price;
    }

    public String getTypOfBeverage() { return typOfBeverage; }
}
