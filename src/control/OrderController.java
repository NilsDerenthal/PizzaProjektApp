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

    public void addBeverageToOrder(String typ){ mainController.getCurrentUser().addBeverageToOrder(new Beverage(typ));}

    public void addFoodToOrder (String orderType, String type){
        Guest guest = mainController.getCurrentUser();

        guest.addToOrder(switch (orderType){
            case "Pizza" -> new Pizza(mainController,type);
            case "Doener" -> new Doener(mainController);
            case "Salad" -> new Salad(mainController);

            default -> throw new IllegalStateException("Unexpected type: " + orderType);
        });
    }
    public void makeNewOrder(){ mainController.getCurrentUser().makeNewOrder(); }

    public void addSaladToFavOrder(){ mainController.getCurrentUser().addToFavOrder(new Salad(mainController)); }

    public void addDoenerToFavOrder(){ mainController.getCurrentUser().addToFavOrder(new Doener(mainController)); }

    public void addPizzaToFavOrder(String typ){ mainController.getCurrentUser().addToFavOrder(new Pizza(mainController,typ));}

    public void addBeverageToFavOrder(String typ){ mainController.getCurrentUser().addBeverageToFavOrder(new Beverage(typ));}

    public void orderFavMeal(){ mainController.getCurrentUser().orderFavMeal(); }
}
