package control;

import model.people.Guest;
import model.people.Worker;
import model.utility.Oven;
import model.utility.Storage;

public class App {

    private double money = 0;

    private Guest currentUser;

    private final LogInController logInController;
    private final ViewController viewController;
    private final OrderController orderController;
    private final Storage storage;
    private final Worker worker;
    private final Oven[] ovens = { new Oven(), new Oven(), new Oven() };

    public static void main(String[] args) {
        new App();
    }

    public App(){
        logInController = new LogInController(this);
        orderController = new OrderController(this);
        viewController = new ViewController(this);

        storage = new Storage(this);
        worker = new Worker(this);
    }

    public void addMoney(double amount){ money += amount; }

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

    public Oven[] getOven(){ return ovens; }

    public Worker getTheWorker(){ return worker; }
}
