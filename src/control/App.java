package control;

import model.food.Pizza;
import model.people.Guest;
import model.utility.*;
import view.MainWindow;

import java.io.*;
import java.util.Arrays;


public class App {

    private double money = 0;
    private Guest[] users;
    private Storage storage;

    public static void main(String[] args) {
        new App();
    }

    public App(){
        new MainWindow(this);

        storage = new Storage(this);

        File userDataFile = new File("src/Database-impostor/Users.txt");
        String usersString = getFileContent(userDataFile);

        String[] usersFromFile = usersString.split("\r\n");
        users = new Guest[usersFromFile.length];

        for (int i = 0; i < usersFromFile.length; i++) {
            String userString = usersFromFile[i];

            String[] userData = userString.split(":");

            String name = userData[0];
            String password = userData[1];

            users[i] = new Guest(name, password);
        }
    }

    private String getFileContent (File f){

        FileInputStream inputStream;

        try {
            inputStream = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        }

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return sb.toString();
    }


    public void subtractMoney(double amount) {
        money -= amount;
    }

    public void addMoney(double amount){ money += amount; }

    public double getMoney () {
        return money;
    }
}
