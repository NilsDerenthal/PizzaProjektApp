package model.food;

import model.utility.Oven;
import control.App;

public class Pizza extends Meal {

    private final String[] availibleTypes = {
            "Margerita",
            "Salami",
            "Prosciutto",
            "Quattro Formaggi",
            "Marinara",
            "Funghi",
            "Capricciosa",
            "Diavola",
    };

    // kann 'null' sein -> noch kein Ofen "verfügbar"/Zugewiesen;
    // dieses 'null' muss überprüft werden.
    private Oven oven;

    // Can be Salami, Margherita, etc.
    private String typeOfPizza;

    /**
     * Creates a Pizza with the given type
     * @param type the type of Pizza (For example Salami)
     */
    public Pizza (App app, String type) {
        this(app, type, null);
        price=7;
    }

    /**
     * Creates a Pizza with a given Oven.
     * @param type the type of Pizza (for example Salami)
     * @param oven the Oven to
     */
    public Pizza (App app, String type, Oven oven) {
        super(app);
        this.typeOfPizza = type;
        this.oven = oven;
    }

    public Pizza(App mainController) {
        this(mainController, null);
    }

    public void makeIt(){
        super.makeIt();
        //Todo
    }

    public String[] getToppings () {
        return availibleTypes;
    }

    @Override
    public double getPrice() {
        if(typeOfPizza.equals("Margerita")){ return price-1; }
        return price;
    }
}
