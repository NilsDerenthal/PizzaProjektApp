package control;

import com.formdev.flatlaf.util.Animator;
import model.Beverage;
import model.food.Doener;
import model.food.Meal;
import model.food.Pizza;
import model.food.Salad;

public class OrderController {

    private App mainController;

    public OrderController(App mainController){
        this.mainController=mainController;
    }

    public void addSaladToOrder(){ mainController.getCurrentUser().addToOrder(new Salad(mainController)); }

    public void addDoenerToOrder(){ mainController.getCurrentUser().addToOrder(new Doener(mainController)); }

    public void addPizzaToOrder(String typ){ mainController.getCurrentUser().addToOrder(new Pizza(mainController,typ));}

    public void addBeverageToOrder(String typ){ mainController.getCurrentUser().addBeverageToOrder(new Beverage(typ));}

    public void makeNewOrder(){ mainController.getCurrentUser().makeNewOrder(); }
}
