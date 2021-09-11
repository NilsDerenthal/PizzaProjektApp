package model.people;

import model.food.Meal;
import model.Order;

public class Guest {

    private String name;
    private String password;
    private Order order=new Order();

    private double budget=100;
    private Meal[] lastMeals;


    public Guest(String name, String password) {
        this.name = name;
        this.password = password;
        lastMeals = new Meal[0];
    }

    public void addToLastMeals(Meal newMeal) {
        Meal[] tmpNewMeals = new Meal[lastMeals.length + 1];

        for (int i = 0; i < lastMeals.length; i++)
            tmpNewMeals[i] = lastMeals[i];

        tmpNewMeals[lastMeals.length] = newMeal;
        lastMeals = tmpNewMeals;
    }

    public String getName() {
        return name;
    }

    public double getBudget() { return budget; }

    public double getOrderPrice() { return order.getTotalPrice(); }

    public void reduceBudget(double price) { budget -= price; }

    public void clearOrder(){ order.clearOrder(); }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addToOrder(Meal isAddTo) { order.addMeal(isAddTo); }

    public Meal[] getOrder() { return order.getMealsInOrder(); }
}
