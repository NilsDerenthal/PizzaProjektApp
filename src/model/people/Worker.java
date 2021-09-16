package model.people;

import control.App;
import model.Beverage;
import model.food.Doener;
import model.food.Meal;
import model.food.Pizza;
import model.food.Salad;

public class Worker {

    private App mainController;

    public Worker(App mainController){
        this.mainController = mainController;
    }

    public void prepareFood(Guest guest){
        guest.getOrder(guest.getOrder(false).length - 1,false).makeIt();
    }

    public void addBeverageToOrder(String typ,boolean isFav){ mainController.getCurrentUser().addBeverageToOrder(new Beverage(typ),isFav);}

    public void addFoodToOrder (String orderType, String type, boolean isFav){
        Guest guest = mainController.getCurrentUser();

        guest.addToOrder(switch (orderType){
            case "Pizza" -> new Pizza(mainController,type);
            case "Doener" -> new Doener(mainController);
            case "Salad" -> new Salad(mainController);

            default -> throw new IllegalStateException("Unexpected type: " + orderType);
        },isFav);

        if(!isFav) prepareFood(guest);
    }

    public void addToLastOrders(){ mainController.getCurrentUser().addToLastOrders(); }

    public void orderFavMeal(){ mainController.getCurrentUser().orderFavMeal(); }


}
