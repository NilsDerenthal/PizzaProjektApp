package control;

import model.people.Guest;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class LogInController {

    // main controller
    private final App mainController;

    // all users
    private Guest[] users;

    // file the users + their data is stored in
    private final File userDataFile;

    /**
     * Default Constructor
     * @param mainController main/parent controller
     */
    public LogInController (App mainController) {

        this.mainController = mainController;

        // read file into an array of Guest Objects.
        // The userdata is formatted as username:password:salt
        // where password has been hashed using the salt.
        userDataFile = new File("src/database/Users.txt");
        String usersString = getFileContent(userDataFile);

        String[] usersFromFile = usersString.split("\n");
        users = new Guest[usersFromFile.length];

        for (int i = 0; i < usersFromFile.length; i++) {
            String userString = usersFromFile[i];

            String[] userData = userString.split(":");

            String name = userData[0];
            String password = userData[1];
            String salt = userData[2];

            users[i] = new Guest(name, password, hexToBytes(salt));
        }

    }

    /**
     * Reads The content of this file into a String and returns it
     * @param file the file whose content are to be read
     * @return the content of the file
     */
    private String getFileContent (File file){

        FileInputStream inputStream = null;

        // won't throw
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException ignore) {}

        StringBuilder sb = new StringBuilder();

        try {
            assert inputStream != null;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * Adds a user to the database in case that the username as well as the password are valid
     * @param username the username of the new user
     * @param password the password for this user. Stored as a char array for security reasons.
     * @return [tag description can't be empty -Nils-]
     */
    public boolean addUser (String username, char[] password) {

        String errorText = null;
        int index = binarySearch(username);

        if (!isUserNameValid(username))
            errorText = "Username is invalid";
        if (!isPasswordValid(password))
            errorText = "Password is invalid, please make sure it is longer than five characters and does not start with a space";
        if (index != -1)
            errorText = "Username has already been taken";

        if(errorText == null) {
            byte[] salt = generateSalt();
            Guest newUser = new Guest(username, hash(password, salt), salt);
            addUserToDatabase(newUser);
            mainController.getViewController().setPanel("setFavMealPanel");
        }else{
            JOptionPane.showMessageDialog(null , errorText);
        }

        return errorText == null;
    }

    /**
     * Generates "salt", a byte array with random contents. It is important to use SecureRandom to ensure security.
     * @return the random byte array of size 64
     */
    private byte[] generateSalt() {
        byte[] bytes = new byte[64];
        new SecureRandom().nextBytes(bytes);
        return bytes;
    }

    /**
     * Returns whether this username is valid by the given Regex.
     * The regex tests for word characters only allowing for whitespaces.
     * word characters mean letters a-z, upper- and lowercase
     * @param username the username to be tested
     * @return whether the username is valid
     */
    private boolean isUserNameValid(String username){
        return !username.isEmpty() && username.matches("^(\\w* ?)+$");
    }

    /**
     * Returns whether this password is valid. A password being valid is identified by it having more than 5 characters.
     * @param password the password
     * @return if this password is valid
     */
    private boolean isPasswordValid(char[] password){
        return password.length >= 5 && password[0] != ' ';
    }

    /**
     * Checks if the login is successful for the given user and password.
     * @param username the username
     * @param password the password to be tested for the user
     * @return [tag description can't be empty -Nils-]
     */
    public boolean checkLogIn (String username, char[] password) {
        String errorText = null;

        int index = binarySearch(username);

        if (index != -1) {
            String correspondingPassword = users[index].getPassword();

            boolean pwMatches = correspondingPassword.equals(hash(password, users[index].getSalt()));

            if (pwMatches) {
                mainController.setCurrentUser(users[index]);
                mainController.getViewController().setPanel("menuePanel");
            } else {
                errorText = "Password does not match";
            }
        } else {
            errorText = "Unknown Username";
        }

        if (errorText != null) {
            JOptionPane.showMessageDialog(null, "Wrong password or username entered");
        }

        return errorText == null;
    }

    /**
     * Adds a user to the database. It does so by inserting it alphabetically into the already existing user array.
     * This method is only to be called after it has been determined if it is a valid username and password.
     * @param guest the new Guest object
     */
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

            newFileDataString.append(String.format("%s:%s:%s%n", newUsers[i].getName(), newUsers[i].getPassword(), bytesToHex(newUsers[i].getSalt())));
        }

        users = newUsers;
        mainController.setCurrentUser(users[newUsers.length-1]);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userDataFile))) {
            writer.write(newFileDataString.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Hashes the given input String with the given salt.
     * This simply means adding the salt to the end of the input string and hashing the resulting String.
     * @param input the input string
     * @param salt the salt added to the input string
     * @return the hashed String representation in hexadecimal
     */
    private String hash(char[] input, byte[] salt) {
        // Exception won't have to be caught
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("SHA3-256");
            messageDigest.update(salt);
            final byte[] hashedBytes = messageDigest.digest(new String(input).getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashedBytes);

        } catch (NoSuchAlgorithmException ignored) {return null;}
    }

    /**
     * Converts bytes to a hexadecimal String. Source: https://www.baeldung.com/sha-256-hashing-java
     * @param hash the hashed input argument
     * @return The hexadecimal representation of the input bytes
     */
    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {

            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * Creates an array of bytes from this hexadecimal String, read from the file. This is the complement method to {@link #bytesToHex(byte[])}
     * Source: https://stackoverflow.com/questions/140131/convert-a-string-representation-of-a-hex-dump-to-a-byte-array-using-java
     * @param hex the hexadecimal input string
     * @return the byte array
     */
    private byte[] hexToBytes(String hex) {

        int len = hex.length();
        byte[] bytes = new byte[len/2];

        for (int i = 0; i < len; i += 2) {
            bytes[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i+1), 16));
        }
        return bytes;
    }

    /**
     * Performs a custom binary search for a user in the Guest array
     * @param key the username to be searched for
     * @return -1 if the username cannot be found, the index in the array otherwise
     */
    private int binarySearch (String key) {

        int l = 0;
        int r = users.length - 1;

        while (l <= r) {

            int m = (l+r)/2;

            int comp = key.compareTo(users[m].getName());

            if (comp == 0)
                return m;


            if (comp < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}
