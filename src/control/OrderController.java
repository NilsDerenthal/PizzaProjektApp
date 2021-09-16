package control;

public class OrderController {

    private final App mainController;

    public OrderController(App mainController){
        this.mainController = mainController;
    }

    public void addBeverageToOrder(String typ,boolean isFav){ mainController.getTheWorker().addBeverageToOrder(typ, isFav); }

    public void addFoodToOrder (String orderType, String type, boolean isFav){ mainController.getTheWorker().addFoodToOrder(orderType,type,isFav); }

    public void orderFavMeal(){ mainController.getTheWorker().orderFavMeal(); }

    public void addTolastOrders(){ mainController.getTheWorker().addToLastOrders(); }

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
                    "Cola"
            };

            case "Salad" -> new String[]{
                    "with dressing",
                    "without dressing"
            };

            default -> throw new IllegalStateException("Unexpected value: " + meal);
        };
    }
}
