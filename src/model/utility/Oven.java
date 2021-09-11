package model.utility;
import  model.food.Pizza;

public class Oven {

    // kann 'null' sein
    // dieses 'null' muss überprüft werden.
    private Pizza pizza;

    private boolean baking;
    private double bakingProgress;
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

        baking = true;
        //TODO actually bake Pizza
        // -> increase baking progress -> display in the view
        return true;
    }

    public long fiveMinutesTimer(){
        return System.currentTimeMillis()-start;
    }

    public Pizza getPizza () {
        return pizza;
    }

    public void setPizza (Pizza newPizza) {
        this.pizza = newPizza;
        long start = System.currentTimeMillis();
    }

    public long getStart(){ return start; }
}
