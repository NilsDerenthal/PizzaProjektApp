package control;

import model.food.Pizza;
import model.people.Guest;
import model.utility.Storage;
import org.apache.commons.lang3.StringUtils;
import view.MainWindow;

import java.io.*;
import java.util.Arrays;

public class App {

    private double money = 0;
    private Guest[] users;
    private Storage storage;

    private File userDataFile;

    public static void main(String[] args) {
        new App();


    }

    public App(){
        new MainWindow(this);

        storage = new Storage(this);

        userDataFile = new File("src/Database-impostor/Users.txt");
        String usersString = getFileContent(userDataFile);

        String[] usersFromFile = usersString.split("\n");
        users = new Guest[usersFromFile.length];

        for (int i = 0; i < usersFromFile.length; i++) {
            String userString = usersFromFile[i];

            String[] userData = userString.split(":");

            String name = userData[0];
            String password = userData[1];

            users[i] = new Guest(name, password);
        }

        addUserToDatabase(new Guest("TEST", "fsddsfsdf"));
        addUserToDatabase(new Guest("ZZZZ", "434"));
        addUserToDatabase(new Guest("Q", "434"));
        addUserToDatabase(new Guest("ZQZZ", "434"));

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

    public void addUserToDatabase (Guest guest) {
        Guest[] newUsers = new Guest[users.length + 1];

        StringBuilder newFileDataString = new StringBuilder();
        boolean inserted = false;

        for (int i = 0; i < newUsers.length; i++) {

            int offset = inserted || i == newUsers.length - 1 ? -1:0;

            if ((guest.getName().compareToIgnoreCase(users[i + offset].getName()) < 0 || i == newUsers.length - 1) && !inserted){
                inserted = true;
                newUsers[i] = guest;
            } else {
                newUsers[i] = users[i + offset];
            }

            newFileDataString.append(String.format("%s:%s%n", newUsers[i].getName(), newUsers[i].getPassword()));
        }

        users = newUsers;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userDataFile))) {
            writer.write(newFileDataString.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void subtractMoney(double amount) {
        money -= amount;
    }

    public void addMoney(double amount){ money += amount; }

    public double getMoney () {
        return money;
    }
}
