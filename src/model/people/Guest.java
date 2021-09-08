package model.people;

import model.food.Meal;

public class Guest {

    private String name;
    private String password;

    private double budget;
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
}
