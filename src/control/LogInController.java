package control;

import model.people.Guest;
import view.MainWindow;
import view.OrderPanel;

import javax.swing.*;

public class LogInController {

    private final MainWindow mainWindow;
    private final App mainController;
    private final OrderPanel nextPanel;

    public LogInController (App mainController, MainWindow mainWindow, OrderPanel nextPanel) {
        this.mainController = mainController;
        this.mainWindow = mainWindow;
        this.nextPanel = nextPanel;
    }

    public void addUser (String username, char[] password) {

        int index = binarySearch(username);

        if(index == -1 && isUserNameValid(username)) {
            Guest newUser = new Guest(username, new String(password));
            mainController.addUserToDatabase(newUser);
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
            String correspondingPassword = mainController.getUsers()[index].getPassword();

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
                mainController.setCurrentUser(mainController.getUsers()[index]);
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

    private int binarySearch (String key) {
        Guest[] users = mainController.getUsers();

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
}
