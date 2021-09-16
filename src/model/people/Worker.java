package model.people;

import control.App;
import model.Beverage;
import model.food.Doener;
import model.food.Pizza;
import model.food.Salad;

public class Worker {

    private final App mainController;

    public Worker(App mainController){
        this.mainController = mainController;
    }

    public void prepareFood(Guest guest){
        guest.getOrder(guest.getOrder(false).length - 1,false).makeIt();
    }

    public void addBeverageToOrder(String type,boolean isFav){ mainController.getCurrentUser().addBeverageToOrder(new Beverage(mainController, type),isFav);}

    public void addFoodToOrder (String orderType, String type, boolean isFav){
        Guest guest = mainController.getCurrentUser();

        guest.addToOrder(switch (orderType){
            case "Pizza" -> new Pizza(mainController,type);
            case "Doener" -> new Doener(mainController);
            case "Salad" -> new Salad(mainController);
            case "Beverage" -> new Beverage(mainController, type);
            default -> throw new IllegalStateException("Unexpected type: " + orderType);
        },isFav);

        if(!isFav) prepareFood(guest);
    }

    public void addToLastOrders(){ mainController.getCurrentUser().addToLastOrders(); }

    public void orderFavMeal(){ mainController.getCurrentUser().orderFavMeal(); }


}
