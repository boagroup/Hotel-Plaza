import java.util.Date;
/**
 * UI
 */
public class UI {

    /* Attributes to store String elements for repeatability purposes */
    static String logo =
            "\n" +
                    "██╗░░██╗░█████╗░████████╗███████╗██╗░░░░░  ██████╗░██╗░░░░░░█████╗░███████╗░█████╗░\n" +
                    "██║░░██║██╔══██╗╚══██╔══╝██╔════╝██║░░░░░  ██╔══██╗██║░░░░░██╔══██╗╚════██║██╔══██╗\n" +
                    "███████║██║░░██║░░░██║░░░█████╗░░██║░░░░░  ██████╔╝██║░░░░░███████║░░███╔═╝███████║\n" +
                    "██╔══██║██║░░██║░░░██║░░░██╔══╝░░██║░░░░░  ██╔═══╝░██║░░░░░██╔══██║██╔══╝░░██╔══██║\n" +
                    "██║░░██║╚█████╔╝░░░██║░░░███████╗███████╗  ██║░░░░░███████╗██║░░██║███████╗██║░░██║\n" +
                    "╚═╝░░╚═╝░╚════╝░░░░╚═╝░░░╚══════╝╚══════╝  ╚═╝░░░░░╚══════╝╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝\n" +
                    "\n";
    static String title = "Hotel Plaza Management System\n";
    static String credits = "Created by Boagroup\n";
    static String inputQuestion = "\nWhat do you wish to do?\n";


    /**
     * Platform-independent function that clears the screen on the Java console.
     * <p>
     * Works by printing a large amount of characters that are removed by a plugin.
     */
    static void clearScreen() {
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
    static void printLogo() {
        clearScreen();
        System.out.println(logo);
    }


    /**
     * Adds delay and prints logo for aesthetics, then prints out the options available in the "login" screen.
     */
    static void printLoginMenu() {
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
    static void printMainMenu() {
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
    static void printBookingsMenu() {
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
    static void printRoomsMenu() {
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
    static void printStaffMenu() {
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
    static void printFinanceMenu() {
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
    static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    /**
     * Adds a custom amount of delay for aesthetic purposes
     *
     * @param ms Amount of delay in milliseconds
     */
    static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    /**
     * Simulates a loading bar filling up using symbols and delay functions.
     */
    static void loadingScreen() {
        System.out.println("\n");
        System.out.print("||");
        wait(300);
        System.out.print("====================");
        wait(300);
        System.out.print("====================");
        wait(300);
        System.out.print("====================");
        wait(300);
        System.out.print("====================");
        wait(300);
        System.out.print("||");
        System.out.println("\n");
    }


    /**
     * Returns a String containing a message with the current user's username and permission level.
     *
     * Should not be used in places where the user is not logged in yet, e.g. "loginMenu"
     *
     * Will not crash if misplaced. Has to be a function instead of a variable otherwise the program won't compile
     */
    static String returnCurrentUser() {
        try {
            String s = "\nYou are currently logged in as user " + "\"" + Authentication.getLoggedInUser().getUsername() + "\"" + " with permission level " + Authentication.getLoggedInUser().getPermission() + "\n";
            return s;
        }
       catch (Exception e) {
            String error;
            return  error = "\nUser not logged in yet";
        }
    }


    /**
     * Prints out a simple logo
     *
     * @param menuName Custom String value to create a simple logo for each menu
     */
    static void menuLogo(String menuName) { //To be deleted soon if of no use
        System.out.println("\n||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("                   " + menuName);
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||\n");
    }


    /**
     * Prints out a proof of concept receipt intended for the final stages of a booking
     * Might need some work
     * @param guestName Parameters might need to be adjusted to work with "Database" and "Item"
     * @param price Parameters might need to be adjusted to work with "Database" and "Item"
     * @param roomNum Parameters might need to be adjusted to work with "Database" and "Item"
     */
    static void printReceipt(String guestName, double price, int roomNum) {
        clearScreen();
        System.out.println(
                "<=============================================================>" +
                "\n<=============================================================>");
        wait(750);
        System.out.println(
                "                                     __            __     \n" +
                "                                    /  |          /  |    \n" +
                "  ______   ______   _______  ______ $$/  ______  _$$ |_   \n" +
                " /      \\ /      \\ /       |/      \\/  |/      \\/ $$   |  \n" +
                "/$$$$$$  /$$$$$$  /$$$$$$$//$$$$$$  $$ /$$$$$$  $$$$$$/   \n" +
                "$$ |  $$/$$    $$ $$ |     $$    $$ $$ $$ |  $$ | $$ | __ \n" +
                "$$ |     $$$$$$$$/$$ \\_____$$$$$$$$/$$ $$ |__$$ | $$ |/  |\n" +
                "$$ |     $$       $$       $$       $$ $$    $$/  $$  $$/ \n" +
                "$$/       $$$$$$$/ $$$$$$$/ $$$$$$$/$$/$$$$$$$/    $$$$/  \n" +
                "                                       $$ |               \n" +
                "                                       $$ |               \n" +
                "                                       $$/                ");
        System.out.println("\t\tPRICE: " + price + " DKK");
        wait(750);
        System.out.println("\n\t\tGUEST: " + guestName);
        wait(750);
        System.out.println("\n\t\tROOM NUMBER: " + roomNum);
        wait(750);
        Date date = new Date();
        System.out.println("\n\t\tBOUGHT ON: " + date);
        System.out.println("\n\n");
        System.out.println(
                "<=============================================================>" +
                "\n<=============================================================>");
        wait(10000);
    }
}