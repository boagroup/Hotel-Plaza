import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Authentication implements Serializable {

    private static User loggedInUser;
    private static boolean loginSuccessful = false;
    private static boolean nameIsRepeated = false;
    private static ArrayList<User> userArrayList = new ArrayList<User>();

    /**
     * Registers a new user to the System
     */
    public static void register() {

        /* Password required to use the register function */
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert security password:\nIf you don't know the password, type \"1\" to go back");
        String securityPass = sc.nextLine();
        if (securityPass.equals("2137")) {
            System.out.println("Permission granted");
        }
        else if (securityPass.equals("1")) {
            return;
        }
        else {
            System.out.println("Incorrect password.");
            return;
        }

        /* User input */
        System.out.println("Please insert your new username:");
        String userName = sc.nextLine();
        System.out.println("Please insert your new password:");
        String userPass = sc.nextLine();
        System.out.println("Please insert the permission level of the user:\n" +
                "     RECOMMENDED PERMISSION LEVELS:\n" +
                "     1: Basic User (e.g. Receptionist)\n" +
                "     2: Intermediate User (e.g. Manager)\n" +
                "     3: Advanced User (e.g. Accountant, GM)\n" +
                "     4: Full-permission User (e.g. Director)");
        byte userPermission = 0;
        while (true) {
            try {
                userPermission = Byte.parseByte(sc.nextLine());
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Oops! That's not a valid number.\nTry again.");
            }
        }

        /* IF Users.ser FILE ALREADY EXISTS */
        File f = new File("Users.ser");
        if (f.exists()) {

            /* Check if username is repeated */
            for (User user : loadUsers()) {
                if (user.getUsername().equals(userName)) {
                    nameIsRepeated = true;
                    break;
                }
            }

            /* Handle repeated username */
            if (nameIsRepeated) {
                System.out.println("Error! That account already exists. Please try again.");
                nameIsRepeated = false; // resetting the variable, otherwise the error will persist
            }

            /* If username is not repeated, save user to file */
            else {
                userArrayList = loadUsers();
                userArrayList.add(new User(userName, userPass, userPermission));
                saveUsers();
                System.out.println("Registration successful. Returning to start menu");
                Interface.loadingScreen();
            }
        }

        /* IF s FILE DOES NOT EXIST */
        else {
            userArrayList.add(new User(userName, userPass, userPermission));
            saveUsers();
            System.out.println("First registration successful. Returning to start menu");
            Interface.loadingScreen();
        }
    }


    /**
     * Logs in an existing user to the System
     */
    public static void login() {

        /* Prevent crash if no users have been registered yet */
        File f = new File("Users.ser");
        if (!f.exists()) {
            System.out.println("No users registered.");
            return;
        }


        /* Login loop */
        while (!isLoginSuccessful()) {

            /* User input */
            System.out.println("Please enter your username:");
            Scanner sca = new Scanner(System.in);
            String userName = sca.nextLine();
            System.out.println("Please enter your password:");
            String userPass = sca.nextLine();

           /* Handles login if user input matches a User object from the serialized file */
            for (User user : loadUsers()) {
                if (user.getUsername().equals(userName)) {
                    if (user.getPassword().equals(userPass)) {
                        loggedInUser = user;
                        setLoginSuccessful(true);
                        break;
                    }
                }
            }
            if (isLoginSuccessful()) {
                Interface.loadingScreen();
                System.out.println("You are now logged in.");
                System.out.println(loggedInUser); // REMOVE THIS LINE FOR FINAL VERSION
                break;
            }

            /* Handles login if no match is found */
            else {
                System.out.println("Uh oh!\nIncorrect credentials.");
            }
            break;
        }
    }

    /**
     * Serializes userArrayList to "Users.ser" file
     */
    public static void saveUsers() {
        try {
            FileOutputStream fileOut = new FileOutputStream("Users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(userArrayList);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            System.out.println("Oops! An error has occurred.");
            i.printStackTrace();
        }
    }

    /**
     * Returns deserialized ArrayList of Users from "Users.ser" file
     */
    public static ArrayList<User> loadUsers() {
        ArrayList<User> u = null;
        try {
            FileInputStream fileIn = new FileInputStream("Users.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            u = (ArrayList<User>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("User class not found");
            c.printStackTrace();
            return null;
        }
        return u;
    }


    /* Getters and setters */

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        Authentication.loggedInUser = loggedInUser;
    }

    public static boolean isLoginSuccessful() {
        return loginSuccessful;
    }

    public static void setLoginSuccessful(boolean loginSuccessful) {
        Authentication.loginSuccessful = loginSuccessful;
    }

    public static ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public static void setUserArrayList(ArrayList<User> userArrayList) {
        Authentication.userArrayList = userArrayList;
    }
}
