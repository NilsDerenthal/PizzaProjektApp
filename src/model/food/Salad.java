package model.food;

import control.App;
import model.utility.Storage;

public class Salad extends Meal {

    private Storage storage;

    public Salad(App app) {
        super(app);
    }

    public void makeSalad(){
        if (storage.getSaladkit() > 0 ) {
            storage.reduceSaladkit();
        } else {
            System.out.println("There are no saladkits left");
        }
        storage.reduceDressingTankFill();

    }
}
