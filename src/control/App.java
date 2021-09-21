package control;

import model.people.Guest;
import model.people.Worker;
import model.utility.Oven;
import model.utility.Storage;

public class App {

    private double money;

    private Guest currentUser;

    private final LogInController logInController;
    private final ViewController viewController;
    private final OrderController orderController;

    private final Storage storage;
    private final Worker worker;
    private final Oven[] ovens;

    /**
     * Main method only used for creating an instance of this class. See {@link #App()}
     * @param args the empty command line args array
     */
    public static void main(String[] args) {
        new App();
    }

    /**
     * The constructor for this Object. Only creates the different controllers that'll manage the whole program.
     * It also creates different utilities for later use.
     */
    public App(){
        logInController = new LogInController(this);
        orderController = new OrderController(this);
        viewController = new ViewController(this);

        storage = new Storage(this);
        worker = new Worker(this);

        ovens = new Oven[]{
                new Oven(),
                new Oven(),
                new Oven()
        };

        money = 100;
    }

    // getter + setter

    public void addMoney(double amount){
        money += amount;
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

    public Oven[] getOven(){ return ovens; }

    public Worker getWorker(){ return worker; }
}
