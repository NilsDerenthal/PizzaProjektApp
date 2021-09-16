package model;
import model.food.Meal;

public class Order {

    private double totalPrice;
    private Meal[] mealsInOrder=new Meal[1];
    private Beverage[] beveragesInOrder=new Beverage[1];

    public Order(){

    }

    public double getTotalPrice(boolean favMeal){
        if(favMeal){
            return (totalPrice/10)*9;
        }
        return totalPrice;
    }

    public void increasPrice(double price){ totalPrice=totalPrice+price; }

    public Meal[] getMealsInOrder(){ return mealsInOrder; }

    public Meal getMealsInOrder(int i){ return mealsInOrder[i]; }

    public Beverage[] getBeveragesInOrder(){ return beveragesInOrder; }

    public void addMeal(Meal newMeal){
        Meal[] tmpNewMeals = new Meal[mealsInOrder.length + 1];

        for (int i = 0; i < mealsInOrder.length; i++)
            tmpNewMeals[i] = mealsInOrder[i];

        tmpNewMeals[mealsInOrder.length] = newMeal;
        mealsInOrder = tmpNewMeals;
        totalPrice=totalPrice+ newMeal.getPrice();
    }
    public void addBeverage(Beverage newBeverage){
        Beverage[] tmpNewBeverages = new Beverage[beveragesInOrder.length + 1];

        for (int i = 0; i < beveragesInOrder.length; i++)
            tmpNewBeverages[i] = beveragesInOrder[i];

        tmpNewBeverages[beveragesInOrder.length] = newBeverage;
        beveragesInOrder = tmpNewBeverages;
        totalPrice=totalPrice+ newBeverage.getPrice();
    }

    public void clearOrder(){
        mealsInOrder = new Meal[1];
        beveragesInOrder = new Beverage[1];
    }
}
