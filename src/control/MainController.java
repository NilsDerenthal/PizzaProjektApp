package control;

import view.ViewWindow;

public class MainController {

    public static void main(String[] args) {
        new MainController();
    }

    public MainController(){
        new ViewWindow(this);
        // Im Konstruktor von ViewWindow beginnt das Programm
    }

}
