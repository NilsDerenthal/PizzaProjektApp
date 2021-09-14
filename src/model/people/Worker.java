package model.people;


import control.App;
import control.OrderController;
import model.Beverage;
import model.Order;
import model.food.Meal;

public class Worker {

    private App mainController;
    //todo

    public Worker(App mainController/*OrderController orderController, Beverage beverage, Meal meal*/){
        this.mainController=mainController;
    }
    public void prepareFood(){

    }
    public Meal[] getNewOrder(boolean isFav){
       return mainController.getCurrentUser().getOrder(isFav);
    }
    public void makeNewOrder(){

    }


}
