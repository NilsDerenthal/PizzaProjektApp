package model.people;

import control.App;
import model.Beverage;
import model.food.Doener;
import model.food.Pizza;
import model.food.Salad;

public class Worker {

    private final App mainController;

    /**
     * Creates a worker
     * @param mainController the mainController reference
     */
    public Worker(App mainController){
        this.mainController = mainController;
    }

    /**
     * Makes the food that is the current order of the guest.
     * @param guest the guest who's food is to be made
     */
    public void prepareFood(Guest guest){
        guest.getOrder(guest.getOrder(false).length - 1,false).makeIt();
    }

    /**
     * Adds a beverage to the current user's order.
     * @param type the type of the order
     * @param isFav if this is to be added to the favourite order
     */
    public void addBeverageToOrder(String type,boolean isFav){ mainController.getCurrentUser().addBeverageToOrder(new Beverage(mainController, type),isFav);}

    /**
     * Adds a
     * @param orderType the type of order to be added
     * @param type the type of the order to be added
     * @param isFav if this is to be added to favourites
     */
    public void addFoodToOrder (String orderType, String type, boolean isFav){
        Guest guest = mainController.getCurrentUser();

        guest.addToOrder(switch (orderType){
            case "Pizza" -> new Pizza(mainController,type);
            case "Doener" -> new Doener(mainController);
            case "Salad" -> new Salad(mainController);
            case "Beverage" -> new Beverage(mainController, type);

            default -> throw new IllegalStateException("Unexpected type: " + orderType);

        } , isFav);

        if(!isFav)
            prepareFood(guest);
    }

    /**
     * Adds to the last orders
     */
    public void addToLastOrders(){ mainController.getCurrentUser().addToLastOrders(); }

    /**
     * Orders the favourite meal of the current user
     */
    public void orderFavMeal(){ mainController.getCurrentUser().orderFavMeal(); }


}
