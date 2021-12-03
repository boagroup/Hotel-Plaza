/**
 * UI class that handles the graphical aspect of the application
 */
public final class UI {

    /**
     * private constructor that disallows creating an instance of the UI class
     * @throws RuntimeException when called
     */
    private UI() throws RuntimeException {
        throw new RuntimeException("Instantiation of UI class is not allowed");
    }

    /* Attributes to store String elements for repeatability purposes */
    private final static String logo =
                    "\n" +
                    "██╗░░██╗░█████╗░████████╗███████╗██╗░░░░░  ██████╗░██╗░░░░░░█████╗░███████╗░█████╗░\n" +
                    "██║░░██║██╔══██╗╚══██╔══╝██╔════╝██║░░░░░  ██╔══██╗██║░░░░░██╔══██╗╚════██║██╔══██╗\n" +
                    "███████║██║░░██║░░░██║░░░█████╗░░██║░░░░░  ██████╔╝██║░░░░░███████║░░███╔═╝███████║\n" +
                    "██╔══██║██║░░██║░░░██║░░░██╔══╝░░██║░░░░░  ██╔═══╝░██║░░░░░██╔══██║██╔══╝░░██╔══██║\n" +
                    "██║░░██║╚█████╔╝░░░██║░░░███████╗███████╗  ██║░░░░░███████╗██║░░██║███████╗██║░░██║\n" +
                    "╚═╝░░╚═╝░╚════╝░░░░╚═╝░░░╚══════╝╚══════╝  ╚═╝░░░░░╚══════╝╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝\n" +
                    "\n";
    private final static String title =         "Hotel Plaza Management System\n";
    private final static String credits =       "Created by Boagroup\n";
    private final static String inputQuestion = "\nWhat do you wish to do?\n";

    /**
     * Platform-independent function that clears the screen on the Java console.
     * <p>
     * Works by printing a large amount of characters that are removed by a plugin.
     */
    public static void clearScreen() {
        try {
            System.out.print("clear");
            if (!System.getProperty("java.class.path").contains("idea_rt.jar")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                if (System.getProperty("os.name").contains("Windows")) {
                    Runtime.getRuntime().exec("cls");
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

    /**
     * Clears the screen, then prints out the logo attribute containing ASCII art.
     */
    public static void printLogo() {
        clearScreen();
        System.out.println(logo);
    }

    /**
     * Adds delay and prints logo for aesthetics, then prints out the options available in the "login" screen.
     */
    public static void printLoginMenu() {
        sleep();
        printLogo();
        String menu = "Welcome to the " + title +
                "Please log in or register your account to continue.\n\n" +
                "1. Log in\n" +
                "2. Register\n" +
                "3. Exit\n" +
                inputQuestion;
        System.out.println(menu);
    }

    /**
     * Adds delay and prints logo for aesthetics, then prints out the options available in the "Main Menu" screen.
     */
    public static void printMainMenu() {
        sleep();
        printLogo();
        String menu = title +
                credits +
                returnCurrentUser() + "\n" +
                "1. See Bookings Menu\t\t\t" +
                "2. See Room Menu\n" +
                "3. See Staff Menu\t\t\t\t" +
                "4. See Finance Options\n" +
                "\t\t\t\t\t5. Log out\n" +
                inputQuestion;
        System.out.println(menu);
    }

    /**
     * Adds delay and prints logo for aesthetics, then prints out the options available in the "Bookings Menu" section.
     */
    public static void printBookingsMenu() {
        sleep();
        printLogo();
        String menu = title +
                credits +
                returnCurrentUser() + "\n" +
                "1. Create Booking\n" +
                "2. Manage Bookings\n" +
                "3. Display Inhouse Report\n" +
                "4. Exit\n" +
                inputQuestion;
        System.out.println(menu);
    }

    /**
     * Adds delay and prints logo for aesthetics, then prints out the options available in the "Rooms Menu" section.
     */
    public static void printRoomsMenu() {
        sleep();
        printLogo();
        String menu = title +
                credits +
                returnCurrentUser() + "\n" +
                "1. Add Room\n" +
                "2. Manage Rooms\n" +
                "3. Display Room Availability\n" +
                "4. Exit\n" +
                inputQuestion;
        System.out.println(menu);
    }

    /**
     * Adds delay and prints logo for aesthetics, then prints out the options available in the "Staff Menu" section.
     */
    public static void printStaffMenu() {
        sleep();
        printLogo();
        String menu = title +
                credits +
                returnCurrentUser() + "\n" +
                "1. Add Staff\t\t\t\t\t" +
                "2. Manage Staff\n" +
                "3. List System Users\t\t\t" +
                "4. Remove User\n" +
                "\t\t\t\t\t5. Go back\n" +
                inputQuestion;
        System.out.println(menu);
    }

    /**
     * Adds delay and prints logo for aesthetics, then prints out the options available in the "Finance Menu" section.
     */
    public static void printFinanceMenu() {
        sleep();
        printLogo();
        String menu = title +
                credits +
                returnCurrentUser() + "\n" +
                "1. See Income Report\n" +
                "2. File Taxes\n" +
                "3. Exit" +
                inputQuestion;
        System.out.println(menu);
    }

    /**
     * Adds one second of delay for aesthetic purposes
     */
    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Adds one second of delay for aesthetic purposes
     * @param ms amount of delay in milliseconds
     * @throws IllegalArgumentException if {@code ms} is negative
     */
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Simulates a loading bar filling up using symbols and delay functions.
     */
    public static void loadingScreen() {
        System.out.print("\n\n||");
        for (int i = 0; i < 4; i++) {
            sleep(300);
            System.out.print("====================");
        }
        sleep(300);
        System.out.print("||\n\n");
    }

    /**
     * Simulates a loading bar filling up using symbols and delay functions.
     * @param length - length of the loading bar
     * @throws IllegalArgumentException if {@code length} is negative
     */
    public static void loadingScreen(int length) throws IllegalArgumentException{
        if (length < 0) {
            throw new IllegalArgumentException("value is negative");
        }
        System.out.print("\n\n||");
        for (int i = 0; i < length; i++) {
            sleep(300);
            System.out.print("====================");
        }
        sleep(300);
        System.out.print("||\n\n");
    }

    /**
     * Returns a String containing a message with the current user's username and permission level.
     *
     * Should not be used in places where the user is not logged in yet, e.g. "loginMenu"
     *
     * Will not crash if misplaced. Has to be a function instead of a variable otherwise the program won't compile
     */
    public static String returnCurrentUser() {
        try {
            return "\nYou are currently logged in as user " + "\"" + Authentication.getLoggedInUser().getUsername() + "\"" + " with permission level " + Authentication.getLoggedInUser().getPermission() + "\n";
        }
       catch (Exception e) {
            return "\nUser not logged in yet";
        }
    }
}