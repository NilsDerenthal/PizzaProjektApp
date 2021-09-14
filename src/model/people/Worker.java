package model.people;


import control.App;
import model.food.Meal;

public class Worker {

    private App mainController;
    //todo

    public Worker(App mainController){
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
