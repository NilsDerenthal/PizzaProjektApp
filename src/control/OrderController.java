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

    public void addFoodToOrder (String orderType, String type, boolean favourite){
        Guest guest = mainController.getCurrentUser();

        Meal order = switch (orderType) {
            case "Pizza" -> new Pizza(mainController, type);
            case "Doener" -> new Doener(mainController);
            case "Salad" -> new Salad(mainController);

            default -> throw new IllegalStateException("Unexpected type: " + orderType);
        };

        if (favourite) {
            guest.addToFavOrder(order);
        } else {
            guest.addToOrder(order);
        }
    }
    public void makeNewOrder(){ mainController.getCurrentUser().makeNewOrder(); }

    public void orderFavMeal(){ mainController.getCurrentUser().orderFavMeal(); }
}
