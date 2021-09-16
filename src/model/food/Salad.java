package model.food;

import control.App;
import model.utility.Storage;

public class Salad extends Meal {


    public Salad(App app) {
        super(app);
        price = 5;
    }

    public void makeIt(){
        super.makeIt();
        if ( mainController.getStorage().getSaladkit() > 0 ) {
            mainController.getStorage().reduceSaladkit();
        }
        mainController.getStorage().reduceDressingTankFill();
    }
}
