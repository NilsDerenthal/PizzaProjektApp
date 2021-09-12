package model.people;

import model.food.Meal;
import model.Beverage;
import model.Order;

public class Guest {

    private String name;
    private String password;
    private Order order=new Order();
    private Order[] lastOrders;

    private double budget=100;

    //Todo günstigeres lieblingsessen


    public Guest(String name, String password) {
        this.name = name;
        this.password = password;
        lastOrders=new Order[1];
    }


    public String getName() {
        return name;
    }

    public double getBudget() { return budget; }

    public double getOrderPrice() { return order.getTotalPrice(); }

    public void reduceBudget(double price) { budget -= price; }

    public void makeNewOrder(){
        Order[] tmpNewOrders = new Order[lastOrders.length + 1];

        for (int i = 0; i < lastOrders.length; i++)
            tmpNewOrders[i] = lastOrders[i];

        tmpNewOrders[lastOrders.length] = order;
        lastOrders = tmpNewOrders;
        order=new Order();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addToOrder(Meal isAddTo) { order.addMeal(isAddTo); }

    public void addBeverageToOrder(Beverage isAddTo) { order.addBeverage(isAddTo); }

    public Meal[] getOrder() { return order.getMealsInOrder(); }

    public Meal getOrder(int i) { return order.getMealsInOrder(i); }

    public Order[] getLastOrders(){ return lastOrders; }

    public Order getLastOrders(int i){ return lastOrders[i]; }

    public Beverage[] getBeverageOrder() { return order.getBeveragesInOrder(); }
}
