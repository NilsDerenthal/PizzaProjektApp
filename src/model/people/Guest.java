package model.people;

import model.food.Meal;
import model.Beverage;
import model.Order;

public class Guest {

    private final String name;
    private final String password;
    private Order order = new Order();
    private Order[] lastOrders;

    private double budget = 100;

    private Order favoriteMeal = new Order();

    private final byte[] salt;


    public Guest(String name, String password, byte[] salt) {
        this.salt = salt;
        this.name = name;
        this.password = password;
        lastOrders=new Order[1];
    }


    public String getName() {
        return name;
    }

    public double getBudget() { return budget; }

    public double getOrderPrice(boolean favMeal) { return order.getTotalPrice(favMeal); }

    public void reduceBudget(double price) { budget -= price; }

    public void makeNewOrder(boolean isFav){
        if(!isFav) {
            addToLastOrders();
            order = new Order();
        }
        if(isFav) favoriteMeal = new Order();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addToOrder(Meal isAddTo,boolean isFav) {
        if(isFav){
            favoriteMeal.addMeal(isAddTo);
        }else{
            order.addMeal(isAddTo);
        }
    }

    public void addBeverageToOrder(Beverage isAddTo,boolean isFav) {
        if(isFav) favoriteMeal.addBeverage(isAddTo);
        order.addBeverage(isAddTo);
    }

    public Meal[] getOrder(boolean isFav) {
        if(isFav) return favoriteMeal.getMealsInOrder();
        return order.getMealsInOrder();
    }

    public Meal getOrder(int i,boolean isFav) {
        if(isFav) return favoriteMeal.getMealsInOrder(i);
        return order.getMealsInOrder(i);
    }

    public Order getTheOrder(boolean isFav){
        if(isFav) return favoriteMeal;
        return order;
    }

    public Order[] getLastOrders(){ return lastOrders; }

    public Order getLastOrders(int i){ return lastOrders[i]; }

    public Beverage[] getBeverageOrder(boolean isFav) {
        if(isFav) return favoriteMeal.getBeveragesInOrder();
        return order.getBeveragesInOrder();
    }

    public byte[] getSalt() {
        return salt;
    }

    public void orderFavMeal(){
        order=favoriteMeal;
    }

    public void addToLastOrders(){
        Order[] tmpNewOrders = new Order[lastOrders.length + 1];

        System.arraycopy(lastOrders, 0, tmpNewOrders, 0, lastOrders.length);

        tmpNewOrders[lastOrders.length] = order;
        lastOrders = tmpNewOrders;
    }
}
