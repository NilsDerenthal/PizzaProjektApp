package control;

import com.formdev.flatlaf.util.Animator;
import model.Beverage;
import model.food.Doener;
import model.food.Meal;
import model.food.Pizza;
import model.food.Salad;
import model.people.Guest;

public class OrderController {

    private App mainController;

    public OrderController(App mainController){
        this.mainController=mainController;
    }

    public void addBeverageToOrder(String typ){ mainController.getCurrentUser().addBeverageToOrder(new Beverage(typ),false);}

    public void addFoodToOrder (String orderType, String type){
        Guest guest = mainController.getCurrentUser();

        guest.addToOrder(switch (orderType){
            case "Pizza" -> new Pizza(mainController,type);
            case "Doener" -> new Doener(mainController);
            case "Salad" -> new Salad(mainController);

            default -> throw new IllegalStateException("Unexpected type: " + orderType);
        },false);
    }
    public void makeNewOrder(){ mainController.getCurrentUser().makeNewOrder(); }

    public void addSaladToFavOrder(){ mainController.getCurrentUser().addToOrder(new Salad(mainController),true); }

    public void addDoenerToFavOrder(){ mainController.getCurrentUser().addToOrder(new Doener(mainController),true); }

    public void addPizzaToFavOrder(String typ){ mainController.getCurrentUser().addToOrder(new Pizza(mainController,typ),true);}

    public void addBeverageToFavOrder(String typ){ mainController.getCurrentUser().addBeverageToOrder(new Beverage(typ),true);}

    public void orderFavMeal(){ mainController.getCurrentUser().orderFavMeal(); }
}
