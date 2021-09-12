package control;

import model.people.Guest;

public class App {

    private double money = 0;

    private Guest currentUser;

    private final LogInController logInController;
    private final ViewController viewController;

    public static void main(String[] args) {
        new App();
    }

    public App(){
        viewController = new ViewController(this);
        logInController = new LogInController(this);
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

    public ViewController getViewController() {
        return viewController;
    }
}
