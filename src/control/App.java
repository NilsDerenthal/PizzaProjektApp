package control;

import model.food.Pizza;
import model.people.Guest;
import model.utility.*;
import view.MainWindow;

import java.util.Arrays;

public class App {

    private double money = 0;

    public static void main(String[] args) {
        new App();
    }

    public App(){
        new MainWindow(this);

        Storage storage = new Storage(this);

    }

    public void subtractMoney(double amount) {
        money -= amount;
    }
    public void addMoney(double amount){ money += amount; }

    public double getMoney () {
        return money;
    }
}
