package model;
import model.food.Meal;

public class Order {

    private double totalPrice;
    private Meal[] mealsInOrder;

    public Order(){

    }

    public double getTotalPrice(){ return totalPrice; }

    public Meal[] getMealsInOrder(){ return mealsInOrder; }

    public void addMeal(Meal newMeal){
        Meal[] tmpNewMeals = new Meal[mealsInOrder.length + 1];

        for (int i = 0; i < mealsInOrder.length; i++)
            tmpNewMeals[i] = mealsInOrder[i];

        tmpNewMeals[mealsInOrder.length] = newMeal;
        mealsInOrder = tmpNewMeals;
    }
}
