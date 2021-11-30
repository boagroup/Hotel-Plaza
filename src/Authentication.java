import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Authentication implements Serializable {

    public static User loggedInUser;
    private static boolean loginSuccessful = false;
    private static boolean nameIsRepeated = false;

    /**
     * Registers a new user to the System
     */
    public static void register() {

        /* Password required to use the register function */
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert security password:");
        String securityPass = sc.nextLine();
        if (securityPass.equals("2137")) {
            System.out.println("Permission granted");
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
        try {
            userPermission = Byte.parseByte(sc.nextLine());
        }
        catch (NumberFormatException exception) {
            System.out.println("That's not a valid number");
            return;
        }

        /* IF User.ser FILE ALREADY EXISTS */
        File f = new File("User.ser");
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
                User.userArrayList = loadUsers();
                User.userArrayList.add(new User(userName, userPass, userPermission));
                saveUsers();
                System.out.println("Registration successful. Returning to start menu");
                Interface.loadingScreen();
            }
        }

        /* IF User.ser FILE DOES NOT EXIST */
        else {
            User.userArrayList.add(new User(userName, userPass, userPermission));
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
        File f = new File("User.ser");
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
                System.out.println("You are now logged in.");
                System.out.println(loggedInUser); // REMOVE THIS LINE FOR FINAL VERSION
                Interface.loadingScreen();
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
     * Serializes userArrayList to "User.ser" file
     */
    public static void saveUsers() {
        try {
            FileOutputStream fileOut = new FileOutputStream("User.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(User.userArrayList);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            System.out.println("Oops! An error has occurred.");
            i.printStackTrace();
        }
    }

    /**
     * Returns deserialized ArrayList of Users from "User.ser" file
     */
    public static ArrayList<User> loadUsers() {
        ArrayList<User> u = null;
        try {
            FileInputStream fileIn = new FileInputStream("User.ser");
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
    public static boolean isLoginSuccessful() {
        return loginSuccessful;
    }

    public static void setLoginSuccessful(boolean loginSuccessful) {
        Authentication.loginSuccessful = loginSuccessful;
    }


}
