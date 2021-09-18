package model.food;

import model.utility.Oven;
import control.App;

public class Pizza extends Meal {

    // kann 'null' sein -> noch kein Ofen "verfügbar"/Zugewiesen;
    // dieses 'null' muss überprüft werden.
    private Oven oven;

    // Can be Salami, Margherita, etc.
    private final String typeOfPizza;
    private final Oven[] ovens;

    /**
     * Creates a Pizza with the given type
     * @param type the type of Pizza (For example Salami)
     */
    public Pizza (App app, String type) {
        super(app);
        this.typeOfPizza = type;
        price = 7;
        ovens = mainController.getOven();
    }

    public Pizza(App mainController) {
        this(mainController, null);
    }

    public void makeIt(){
        super.makeIt();
        int oven=checkOven();
        if(oven >= 0) {
            ovens[oven].makePizza();
            ovens[oven].setPizza(this);
        }
    }

    private int checkOven(){
        for(int i = 0; i < ovens.length; i++){
            if(!ovens[i].bakePizza()){ return i; }
        }
        return -1;
    }


    @Override
    public double getPrice() {
        if(typeOfPizza.equals("Margerita")){ return price-1; }
        return price;
    }

    @Override
    public String toString() {
        return "Pizza " + typeOfPizza;
    }

    //this is unused, just making it a comment for now
    /*
    public void setTopping(String selectedPizzaType) {
        typeOfPizza = selectedPizzaType;
    }
    */
}
