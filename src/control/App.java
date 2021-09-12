package control;

import model.people.Guest;
import model.utility.Storage;
import view.MainWindow;
import view.MenuePanel;
import view.OrderPanel;

import java.io.*;
import java.util.Arrays;

public class App {

    private double money = 0;

    private Guest currentUser;

    private Storage storage;


    private LogInController logInController;

    public static void main(String[] args) {
        new App();
    }

    public App(){
        MainWindow m = new MainWindow(this);

        logInController = new LogInController(this, m, new MenuePanel(this,m));

        storage = new Storage(this);

    }


    public void subtractMoney(double amount) {
        money -= amount;
    }

    public void addMoney(double amount){ money += amount; }

    public double getMoney () {
        return money;
    }

    public void setCurrentUser(Guest currentUser) {
        this.currentUser = currentUser;
    }

    public Guest getCurrentUser(){ return currentUser; }

    public LogInController getLogInController() {
        return logInController;
    }
}
