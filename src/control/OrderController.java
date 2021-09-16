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

    public void addBeverageToOrder(String typ,boolean isFav){ mainController.getTheWorker().addBeverageToOrder(typ, isFav); }

    public void addFoodToOrder (String orderType, String type, boolean isFav){ mainController.getTheWorker().addFoodToOrder(orderType,type,isFav); }

    public void orderFavMeal(){ mainController.getTheWorker().orderFavMeal(); }

    public void addTolastOrders(){ mainController.getTheWorker().addToLastOrders(); }
}
