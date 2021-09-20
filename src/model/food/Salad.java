package model.food;

import control.App;

public class Salad extends Meal {


    public Salad(App app) {
        super(app);
        price = 5;
    }

    public void makeIt(){
        if ( mainController.getStorage().getSaladkit() > 0 ) {
            mainController.getStorage().reduceSaladkit();
        }
        mainController.getStorage().reduceDressingTankFill();
    }

    @Override
    public String toString() {
        return "Salad";
    }
}
