package model.food;
import control.App;

public class Doener extends Meal {

    private double skewerPercentage = 1;

    public Doener (App app) {
        super(app);
        price = 3.40;
    }

    public void makeIt(){
        // hardcoded value (1.5%)
        if(skewerPercentage > 0.015){
            skewerPercentage = 1;
            //hardcoded value (25€)
            double skewerPrice = 25.00;
            mainController.addMoney(-skewerPrice);
        }

        // hardcoded in value (1.5%)
        skewerPercentage -= 0.015;
        /*
        return Doener;
        gotta do stuff in Guest / Order first to be able to do this
        */
    }

    @Override
    public String toString() {
        return "Döner";
    }
}
