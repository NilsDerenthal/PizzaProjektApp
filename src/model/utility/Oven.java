package model.utility;
import  model.food.Pizza;

public class Oven {

    // kann 'null' sein
    // dieses 'null' muss überprüft werden.
    private Pizza pizza;

    private boolean baking;
    private long start;

    public Oven (Pizza pizza) {
        this.pizza = pizza;
    }

    public Oven () {
        this(null);
    }

    public boolean bakePizza () {

        // testet ob schon etwas gebacken wird oder pizza nicht existiert
        // wenn ja -> returns false

        if (baking || pizza == null)
            return false;

        return true;
    }
    public void makePizza(){

        if(bakePizza() == false){

            baking = true;
            start= System.currentTimeMillis();
            if (fiveMinutesTimer() >= 3000){
                baking = false;
            }


        }
    }
    private long fiveMinutesTimer(){
        return System.currentTimeMillis()-start;
    }

    public Pizza getPizza () {
        return pizza;
    }

    public void setPizza (Pizza newPizza) {
        this.pizza = newPizza;
    }
}
