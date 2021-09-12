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

    public void addSaladToFavOrder(){ mainController.getCurrentUser().addToFavOrder(new Salad(mainController)); }

    public void addDoenerToFavOrder(){ mainController.getCurrentUser().addToFavOrder(new Doener(mainController)); }

    public void addPizzaToFavOrder(String typ){ mainController.getCurrentUser().addToFavOrder(new Pizza(mainController,typ));}

    public void addBeverageToFavOrder(String typ){ mainController.getCurrentUser().addBeverageToFavOrder(new Beverage(typ));}
}
