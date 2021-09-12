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
        logInController = new LogInController(this);
        viewController = new ViewController(this);
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
        System.out.println(logInController);
        return logInController;
    }

    public ViewController getViewController() {
        return viewController;
    }
}
