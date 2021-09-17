package control;

public class OrderController {

    // The main controller, passed down
    private final App mainController;

    /**
     * basic contructor for this Controller
     * @param mainController the main controller
     */
    public OrderController(App mainController){
        this.mainController = mainController;
    }

    /**
     * Adds the specified food to the current order.
     * @param orderType One of Pizza, Doener, Beverage and Salad
     * @param type the specified type of Pizza/Beverage. Can be null for salad and Doener
     * @param isFav inidicates wheter this should be added to favourites or normal order
     */
    public void addFoodToOrder (String orderType, String type, boolean isFav){ mainController.getWorker().addFoodToOrder(orderType,type,isFav); }

    public void addBeverageToOrder (String type,boolean isFav){ mainController.getWorker().addBeverageToOrder(type,isFav);}

    /**
     * Orders the favourite meal
     */
    public void orderFavMeal(){ mainController.getWorker().orderFavMeal(); }

    /**
     * Adds the current order to the last order list.
     */
    public void addToLastOrders(){ mainController.getWorker().addToLastOrders(); }

    /**
     * Gets the possible types of the specified order.
     * @param meal the meal for which the orders are to be listed. One of Pizza, Doener, Salad and Beverage
     * @return the available options
     */
    public String[] getOrderTypes(String meal) {
        return switch (meal) {
            case "Pizza" -> new String[]{
                    "Margerita",
                    "Salami",
                    "Prosciutto",
                    "Quattro Formaggi",
                    "Marinara",
                    "Funghi",
                    "Capricciosa",
                    "Diavola"
            };

            case "Doener" -> new String[]{
                    "With sauce",
                    "without sauce"
            };

            case "Beverage" -> new String[]{
                    "Soda",
                    "Water",
                    "Juice"
            };

            case "Salad" -> new String[]{
                    "with dressing",
                    "without dressing"
            };

            default -> throw new IllegalStateException("Unexpected value: " + meal);
        };
    }
}
