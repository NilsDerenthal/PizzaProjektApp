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

    public void addBeverageToOrder(String typ,boolean isFav){ mainController.getCurrentUser().addBeverageToOrder(new Beverage(typ),isFav);}

    public void addFoodToOrder (String orderType, String type, boolean isFav){
        Guest guest = mainController.getCurrentUser();

        guest.addToOrder(switch (orderType){
            case "Pizza" -> new Pizza(mainController,type);
            case "Doener" -> new Doener(mainController);
            case "Salad" -> new Salad(mainController);

            default -> throw new IllegalStateException("Unexpected type: " + orderType);
        },isFav);
    }

    public void orderFavMeal(){ mainController.getCurrentUser().orderFavMeal(); }
}
