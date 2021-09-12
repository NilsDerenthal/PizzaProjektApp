package control;

import model.people.Guest;
import view.MainWindow;
import view.MenuePanel;
import view.OrderPanel;

import javax.swing.*;
import java.io.*;

public class LogInController {

    private final MainWindow mainWindow;
    private final App mainController;
    private final MenuePanel nextPanel;

    private Guest[] users;
    private File userDataFile;

    public LogInController (App mainController, MainWindow mainWindow, MenuePanel nextPanel) {
        this.mainController = mainController;
        this.mainWindow = mainWindow;
        this.nextPanel = nextPanel;

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

    public void addUser (String username, char[] password) {

        int index = binarySearch(username);

        if(index == -1 && isUserNameValid(username)) {
            Guest newUser = new Guest(username, new String(password));
            addUserToDatabase(newUser);
            mainWindow.setNewPanel(nextPanel.getMainPanel());
        }else{
            JOptionPane.showMessageDialog(null ,"Username is invalid, try another one");
        }

    }

    private boolean isUserNameValid(String username){
        return !username.isEmpty() && !username.contains(":");
    }

    public void checkLogIn (String username, char[] password) {
        boolean wrongPasswordOrUser = false;

        int index = binarySearch(username);

        if (index != -1) {
            String correspondingPassword =users[index].getPassword();

            boolean pwMatches = true;

            if (correspondingPassword.length() == password.length) {
                for (int i = 0; i < password.length; i++) {
                    char c = password[i];
                    if (!(c == correspondingPassword.charAt(i))) {
                        pwMatches = false;
                        break;
                    }
                }
            } else {
                pwMatches = false;
            }


            if (pwMatches) {
                mainController.setCurrentUser(users[index]);
                mainWindow.setNewPanel(nextPanel.getMainPanel());
            } else {
                wrongPasswordOrUser = true;
            }
        } else {
            wrongPasswordOrUser = true;
        }

        if (wrongPasswordOrUser) {
            JOptionPane.showMessageDialog(null,"Wrong password or username entered");
        }
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

    private int binarySearch (String key) {

        int l = 0;
        int r = users.length - 1;

        while (l <= r) {

            int m = (l+r)/2;

            int comp = key.compareTo(users[m].getName());

            if (comp == 0)
                return m;


            if (comp > 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    public Guest[] getUsers() {
        return users;
    }
}
