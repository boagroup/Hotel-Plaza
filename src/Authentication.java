import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Authentication implements Serializable {

    private static User loggedInUser;
    private static boolean loginSuccessful = false;
    private static boolean nameIsRepeated = false;
    private static ArrayList<User> userArrayList = new ArrayList<>();


    /**
     * Registers a new user to the System.
     *
     * The registration is complete once a new User object has been stored in a "Users.ser" file.
     *
     * Has built-in failsafe features to prevent the program from crashing.
     */
    public static void register() {

        /* Password required to use the register function */
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInsert security PIN:\nIf you don't know the PIN, insert anything to go back");
        String securityPass = sc.nextLine();
        if (securityPass.equals("2137")) {
            System.out.println("\nPermission granted");
        }
        else {
            System.out.println("\nIncorrect password.");
            return;
        }

        /* User input */
        System.out.println("\nPlease insert your new username:");
        String userName;

        /* Loop used for failsafe mechanism */
        while (true) {
            userName = sc.nextLine();

            /* Preventing user from creating an Admin user */
            if (userName.equals("Admin")) {
                System.out.println("\nRestricted username.\nPick another.");
            }
            else {
                break;
            }
        }

        System.out.println("\nPlease insert your new password:");
        String userPass = sc.nextLine();
        System.out.println("\nPlease insert the permission level of the user:\n" +
                "     RECOMMENDED PERMISSION LEVELS:\n" +
                "     1: Basic User (e.g. Receptionist)\n" +
                "     2: Intermediate User (e.g. Manager)\n" +
                "     3: Advanced User (e.g. Accountant, GM)\n" +
                "     4: Full-permission User (e.g. Director)");
        byte userPermission = 0;

        /* Loop used for failsafe mechanism */
        while (true) {

            /* Preventing user from inserting invalid input */
            try {
                userPermission = Byte.parseByte(sc.nextLine());
                break;
            }
            catch (NumberFormatException exception) {
                System.out.println("\nOops! That's not a valid number.\nTry again.");
            }
        }

        /* IF Users.ser FILE ALREADY EXISTS */
        File f = new File("database/Users.ser");
        if (f.exists() && !f.isDirectory()) {

            /* Check if username is repeated */
            for (User user : loadUsers()) {
                if (user.getUsername().equals(userName)) {
                    nameIsRepeated = true;
                    break;
                }
            }

            /* Handle repeated username */
            if (nameIsRepeated) {
                System.out.println("\nError! That account already exists. Please try again.");
                nameIsRepeated = false; // resetting the variable, otherwise the error will persist
                UI.sleep(1500);
            }

            /* If username is not repeated, save user to file */
            else {
                userArrayList = loadUsers();
                userArrayList.add(new User(userName, userPass, userPermission));
                saveUsers();
                System.out.println("\nRegistration successful. Returning to start menu");
                UI.loadingScreen();
            }
        }

        /* IF s FILE DOES NOT EXIST */
        else {
            userArrayList.add(new User(userName, userPass, userPermission));
            saveUsers();
            System.out.println("\nFirst registration successful. Returning to start menu");
            UI.loadingScreen();
        }
    }


    /**
     * Logs in an existing user to the System.
     *
     * The login is complete once an existing User from the "Users.ser" file is stored in the loggedInUser attribute.
     *
     * Has built-in failsafe features to prevent the program from crashing.
     */
    public static void login() {

        /* Prevent crash if no users have been registered yet */
        File f = new File("database/Users.ser");
        if (!f.exists() && !f.isDirectory()) {
            System.out.println("\nNo users registered.");
            return;
        }


        /* Login loop */
        while (!isLoginSuccessful()) {

            /* User input */
            System.out.println("\nPlease enter your username:");
            Scanner sca = new Scanner(System.in);
            String userName = sca.nextLine();
            System.out.println("\nPlease enter your password:");
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
                UI.loadingScreen();
                System.out.println("\nYou are now logged in.");
                UI.sleep(1250);
                break;
            }

            /* Handles login if no match is found */
            else {
                System.out.println("\nUh oh!\nIncorrect credentials.");
                UI.sleep(350);
            }
            break;
        }
    }


    /**
     * Serializes userArrayList to "Users.ser" file.
     */
    public static void saveUsers() {
        try {
            FileOutputStream fileOut = new FileOutputStream("database/Users.ser");
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
     * Returns deserialized ArrayList of Users from "Users.ser" file.
     */
    public static ArrayList<User> loadUsers() {
        ArrayList<User> u = null;
        try {
            FileInputStream fileIn = new FileInputStream("database/Users.ser");
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


    /**
     * Prints out a list with all the users stored in memory in the "Users.ser" file.
     *
     * The "password" attribute of each User gets censored for security purposes by default.
     *
     * The censorship can be overwritten if the user is an admin.
     *
     * Has built-in failsafe features to prevent the program from crashing.
     */
    public static void listUsers() {
        UI.loadingScreen();
        UI.clearScreen();
        System.out.println("\n" +
                "UUUUUUUU     UUUUUUUU                                                             LLLLLLLLLLL               iiii                            tttt          \n" +
                "U::::::U     U::::::U                                                             L:::::::::L              i::::i                        ttt:::t          \n" +
                "U::::::U     U::::::U                                                             L:::::::::L               iiii                         t:::::t          \n" +
                "UU:::::U     U:::::UU                                                             LL:::::::LL                                            t:::::t          \n" +
                " U:::::U     U:::::U    ssssssssss       eeeeeeeeeeee    rrrrr   rrrrrrrrr          L:::::L               iiiiiii     ssssssssss   ttttttt:::::ttttttt    \n" +
                " U:::::D     D:::::U  ss::::::::::s    ee::::::::::::ee  r::::rrr:::::::::r         L:::::L               i:::::i   ss::::::::::s  t:::::::::::::::::t    \n" +
                " U:::::D     D:::::Uss:::::::::::::s  e::::::eeeee:::::eer:::::::::::::::::r        L:::::L                i::::i ss:::::::::::::s t:::::::::::::::::t    \n" +
                " U:::::D     D:::::Us::::::ssss:::::se::::::e     e:::::err::::::rrrrr::::::r       L:::::L                i::::i s::::::ssss:::::stttttt:::::::tttttt    \n" +
                " U:::::D     D:::::U s:::::s  ssssss e:::::::eeeee::::::e r:::::r     r:::::r       L:::::L                i::::i  s:::::s  ssssss       t:::::t          \n" +
                " U:::::D     D:::::U   s::::::s      e:::::::::::::::::e  r:::::r     rrrrrrr       L:::::L                i::::i    s::::::s            t:::::t          \n" +
                " U:::::D     D:::::U      s::::::s   e::::::eeeeeeeeeee   r:::::r                   L:::::L                i::::i       s::::::s         t:::::t          \n" +
                " U::::::U   U::::::Ussssss   s:::::s e:::::::e            r:::::r                   L:::::L         LLLLLL i::::i ssssss   s:::::s       t:::::t    tttttt\n" +
                " U:::::::UUU:::::::Us:::::ssss::::::se::::::::e           r:::::r                 LL:::::::LLLLLLLLL:::::Li::::::is:::::ssss::::::s      t::::::tttt:::::t\n" +
                "  UU:::::::::::::UU s::::::::::::::s  e::::::::eeeeeeee   r:::::r                 L::::::::::::::::::::::Li::::::is::::::::::::::s       tt::::::::::::::t\n" +
                "    UU:::::::::UU    s:::::::::::ss    ee:::::::::::::e   r:::::r                 L::::::::::::::::::::::Li::::::i s:::::::::::ss          tt:::::::::::tt\n" +
                "      UUUUUUUUU       sssssssssss        eeeeeeeeeeeeee   rrrrrrr                 LLLLLLLLLLLLLLLLLLLLLLLLiiiiiiii  sssssssssss              ttttttttttt  \n" +
                "\n\n");
        /* Prints out the list if the user is an admin */
        if (loggedInUser.getUsername().equals("Admin")) {
            System.out.println("\nListing users with admin permission levels...\n");

            /* Handles the list if the "Users.ser" file exists */
            File f = new File("database/Users.ser");
            if (f.exists() && (!loadUsers().isEmpty())) {
                for (User user : loadUsers()) {
                    System.out.println();
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<=================================>");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tUSERNAME: " + user.getUsername());
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tPASSWORD: " + user.getPassword());
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tPERMISSION LEVEL: " + user.getPermission());
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<=================================>");
                    System.out.println();
                }
            }
            else if (f.exists() && (loadUsers().isEmpty())) {
                System.out.println("\nAll of the users have been deleted.");
            }

            /* Handles the list if the "Users.ser" file does not exist */
            else {
                System.out.println();
                System.out.println("No users have been registered yet.");
                System.out.println("The Admin user is not stored in memory.");
                System.out.println();
            }
        }

        /* Prints out the censored list for regular users */
        else {
            for (User user : loadUsers()) {
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<=================================>");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tUSERNAME: " + user.getUsername());
                user.setPassword("*****");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tPASSWORD: " + user.getPassword());
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tPERMISSION LEVEL: " + user.getPermission());
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<=================================>");
                System.out.println();
            }
        }
        System.out.println("\nInsert any key to go back");
        Scanner sleeping = new Scanner(System.in);
        sleeping.nextLine();
    }


    /**
     * Prints out a list with all the users stored in memory in the "Users.ser" file.
     *
     * The authorized user can select one of the users by typing its associated number.
     *
     * The selected user will be deleted from the "Users.ser" file.
     *
     * Has built-in failsafe features to prevent the program from crashing.
     *
     */
    public static void removeUser() {
        if (loggedInUser.getPermission() >= 3) {

            /* Check if "Users.ser" file exists */
            File f = new File("database/Users.ser");

            /* If it does, iterate through each user and print out
            their names alongside their incremented indexes */
            if (f.exists() && !f.isDirectory()) {
                System.out.println("Saved Users:");
                int i = 1;
                for (User user : loadUsers()) {
                    System.out.println(i++ + ". " + user.getUsername());
                }

                /* Assign the deserialized ArrayList from "Users.ser"
                to the "userArrayList" attribute */
                userArrayList = Authentication.loadUsers();

                /* If "userArrayList" is NOT empty, request user input */
                if (!userArrayList.isEmpty()) {
                    System.out.println("\nType the number of the User that you want to remove:");
                    Scanner sca = new Scanner(System.in);
                    String answer = sca.nextLine();

                    /* Try to parse the String input to an integer and remove
                    the user who corresponds to the decremented input */
                    try {

                        /* Assign the user to be removed to an auxiliary User object */
                        User toBeRemoved = userArrayList.get(Integer.parseInt(answer) - 1);

                        /* If the name of the user who is logged in does not match the user to be removed... */
                        if (!loggedInUser.getUsername().equals(toBeRemoved.getUsername())) {

                            /* If the logged-in user has appropriate permission levels... */
                            if(loggedInUser.getPermission() >= toBeRemoved.getPermission()) {

                                /* Success scenario; User is removed */
                                userArrayList.remove(Integer.parseInt(answer) - 1);
                                System.out.println("\nUser removed successfully.");
                                UI.sleep(1000);
                            }

                            /* If the logged-in user does not have the appropriate permission levels */
                            else {
                                System.out.println("You cannot remove users with higher permission levels than you!");
                                UI.sleep(2750);
                            }

                        }

                        /* If the usernames match, print error message, as you cannot remove yourself */
                        else {
                            System.out.println("\nYou cannot remove yourself!");
                            UI.sleep(1600);
                        }

                    }
                        /* If it cannot parse, print an error message */
                    catch (Exception e) {
                        System.out.println("\nInvalid input");
                        UI.sleep(1000);
                    }
                }

                /* If "userArrayList" is empty, print error because all users must have been deleted */
                else {
                    System.out.println("\nOut of users to remove.");
                    UI.sleep(1550);
                }
                saveUsers();
            }
            /* If the "Users.ser" file does not exist, print
            error message (only possible in admin mode) */
            else {
                System.out.println("\nNo users have been registered yet.");
                UI.sleep(1750);
            }
        }
        else {
            System.out.println("\nYou do not have permission to remove users.");
            UI.sleep(2000);
        }
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