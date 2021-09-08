package model.food;
import control.App;

public class Doener extends Meal {

    private double skewerPercentage = 1;
    //hardcoded value (25€)
    private double skewerPrice = 25.00;

    public Doener (App app) {
        super(app);
    }

    public void makeDoener(){
        // hardcoded value (1.5%)
        if(skewerPercentage > 0.015){
            skewerPercentage = 1;
            mainController.subtractMoney(skewerPrice);
        }

        // hardcoded in value (1.5%)
        skewerPercentage -= 0.015;
        //TODO Finish Guest / Order
        /*
        return Doener;
        gotta do stuff in Guest / Order first to be able to do this
        */
    }
}
