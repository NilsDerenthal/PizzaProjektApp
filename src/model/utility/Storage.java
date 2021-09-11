package model.utility;

import control.App;

public class Storage {
    private int saladkit;
    private double dressingTankfill;
    private App mainController;

    public Storage(App mainController) {
        this.mainController = mainController;
    }

    public void refillDressingTank(){
       if(dressingTankfill <= 0){
           mainController.subtractMoney(-10);
           dressingTankfill = 100;
        }
    }

    public void reduceDressingTankFill(){
        if(dressingTankfill>0) {
            dressingTankfill = dressingTankfill - 2.5;
        }else{
            refillDressingTank();
        }
    }

    public void setSaladkit(){
        saladkit = 35;
        mainController.subtractMoney(-35);
    }

    public void reduceSaladkit(){
        if(saladkit>0) {
            saladkit = saladkit - 1;
        }
    }

    public int getSaladkit(){
        return saladkit;
    }

}
