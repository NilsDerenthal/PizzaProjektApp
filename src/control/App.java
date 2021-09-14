package control;

import model.people.Guest;
import model.utility.Storage;

public class App {

    private double money = 0;

    private Guest currentUser;

    private final LogInController logInController;
    private final ViewController viewController;
    private final OrderController orderController;
    private final Storage storage;

    public static void main(String[] args) {
        new App();
    }

    public App(){
        logInController = new LogInController(this);
        viewController = new ViewController(this);
        orderController = new OrderController(this);
        storage=new Storage(this);
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

    public OrderController getOrderController () {
        return orderController;
    }

    public Storage getStorage(){ return storage; }
}
