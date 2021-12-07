import DatabasePackage.Database;
import ItemsPackage.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
                "2. Exit" +
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
        } catch (Exception e) {
            return "\nUser not logged in yet";
        }
    }

    /**
     * Prints out a proof of concept receipt intended for the final stages of a booking
     * Might need some work
     * @param guestName Parameters might need to be adjusted to work with "Database" and "Item"
     * @param price Parameters might need to be adjusted to work with "Database" and "Item"
     * @param roomNum Parameters might need to be adjusted to work with "Database" and "Item"
     */
    public static void printReceipt(String guestName, double price, int roomNum) {
        clearScreen();
        System.out.println(
                "<=============================================================>" +
                "\n<=============================================================>");
        sleep(750);
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
        sleep(750);
        System.out.println("\n\t\tGUEST: " + guestName);
        sleep(750);
        System.out.println("\n\t\tROOM NUMBER: " + roomNum);
        sleep(750);
        Date date = new Date();
        System.out.println("\n\t\tBOUGHT ON: " + date);
        System.out.println("\n\n");
        System.out.println(
                "<=============================================================>" +
                "\n<=============================================================>");
        System.out.println("\n\n\nInsert anything to go back");
        Scanner wait = new Scanner(System.in);
        wait.nextLine();
    }

    /**
     * Prints out a report containing information on all bookings
     *
     * Takes serialized ArrayList of "Booking" from Database, attributes it to an auxiliary ArrayList,
     * and iterates through the latter, printing out relevant information for the report
     *
     * Might need some work
     */
    public static void displayInHouseReport() {
            /* Refresh the console and print the logo */
            clearScreen();
            System.out.println("\n" +
                    "\n" +
                    " __  .__   __.         __    __    ______    __    __       _______. _______    .______       _______ .______     ______   .______     .___________.\n" +
                    "|  | |  \\ |  |        |  |  |  |  /  __  \\  |  |  |  |     /       ||   ____|   |   _  \\     |   ____||   _  \\   /  __  \\  |   _  \\    |           |\n" +
                    "|  | |   \\|  |  ______|  |__|  | |  |  |  | |  |  |  |    |   (----`|  |__      |  |_)  |    |  |__   |  |_)  | |  |  |  | |  |_)  |   `---|  |----`\n" +
                    "|  | |  . `  | |______|   __   | |  |  |  | |  |  |  |     \\   \\    |   __|     |      /     |   __|  |   ___/  |  |  |  | |      /        |  |     \n" +
                    "|  | |  |\\   |        |  |  |  | |  `--'  | |  `--'  | .----)   |   |  |____    |  |\\  \\----.|  |____ |  |      |  `--'  | |  |\\  \\----.   |  |     \n" +
                    "|__| |__| \\__|        |__|  |__|  \\______/   \\______/  |_______/    |_______|   | _| `._____||_______|| _|       \\______/  | _| `._____|   |__|     \n" +
                    "                                                                                                                                                    \n" +
                    "\n\n\n");

            /* Assign the serialized ArrayList "Booking" objects to auxiliary "booking" ArrayList */
            ArrayList<Booking> bookings = Database.getList(Booking.class);

            /* Iterate through all Booking objects inside "bookings" and get the relevant attributes */
            for (Booking booking : bookings) {
                System.out.println(
                        "\t\t\t\t\t\t\t\t\t====================================================================\n" +
                        "\t\t\t\t\t\t\t\t\t|| ROOM NUMBER: " + booking.getRoom().getNumber() + "\n" +
                        "\t\t\t\t\t\t\t\t\t|| GUEST: " + booking.getGuest().getName() + "\n" +
                        "\t\t\t\t\t\t\t\t\t|| CHECK-IN:  " + booking.getCheckInDate() + "\n" +
                        "\t\t\t\t\t\t\t\t\t|| CHECK-OUT: " + booking.getCheckOutDate() + "\n" +
                        "\t\t\t\t\t\t\t\t\t|| PRICE PER DAY: " + booking.getRoom().getStandardPrice() + " DKK\n" +
                        "\t\t\t\t\t\t\t\t\t|| HAS PAID: "+ (booking.getGuest().isHasPaid()? "Paid":"Not Paid") + "\n" +
                        "\t\t\t\t\t\t\t\t\t====================================================================" +
                        "\n\n\n");
            }

            /* Use any user input to close the report */
            System.out.println("\n\n\n\n\n\nInsert anything to go back");
            Scanner wait = new Scanner(System.in);
            wait.nextLine();
    }

    /**
     * Prints out a report containing information on room availability
     *
     * Takes serialized ArrayList of "Room" from Database, attributes it to an auxiliary ArrayList,
     * and iterates through the latter, printing out relevant information for the report
     *
     * Might need some work
     */
    public static void displayAvailabilityReport() {
        /* Refresh the console and print the logo */
        clearScreen();
        System.out.println("                                                                                                                                                    \n" +
                "\t\t88888888ba     ,ad8888ba,      ,ad8888ba,    88b           d88     88888888ba   88888888888  88888888ba     ,ad8888ba,    88888888ba  888888888888  \n" +
                "\t\t88      \"8b   d8\"'    `\"8b    d8\"'    `\"8b   888b         d888     88      \"8b  88           88      \"8b   d8\"'    `\"8b   88      \"8b      88       \n" +
                "\t\t88      ,8P  d8'        `8b  d8'        `8b  88`8b       d8'88     88      ,8P  88           88      ,8P  d8'        `8b  88      ,8P      88       \n" +
                "\t\t88aaaaaa8P'  88          88  88          88  88 `8b     d8' 88     88aaaaaa8P'  88aaaaa      88aaaaaa8P'  88          88  88aaaaaa8P'      88       \n" +
                "\t\t88\"\"\"\"88'    88          88  88          88  88  `8b   d8'  88     88\"\"\"\"88'    88\"\"\"\"\"      88\"\"\"\"\"\"'    88          88  88\"\"\"\"88'        88       \n" +
                "\t\t88    `8b    Y8,        ,8P  Y8,        ,8P  88   `8b d8'   88     88    `8b    88           88           Y8,        ,8P  88    `8b        88       \n" +
                "\t\t88     `8b    Y8a.    .a8P    Y8a.    .a8P   88    `888'    88     88     `8b   88           88            Y8a.    .a8P   88     `8b       88       \n" +
                "\t\t88      `8b    `\"Y8888Y\"'      `\"Y8888Y\"'    88     `8'     88     88      `8b  88888888888  88             `\"Y8888Y\"'    88      `8b      88       \n" +
                "                                                                                                                                                    \n" +
                "                                                                                                                                                    \n" +
                "\n");

        /* Assign the serialized ArrayList "Room" objects to auxiliary "rooms" ArrayList */
        ArrayList<Room> rooms = Database.getList(Room.class);

        /* Iterate through all Room objects inside "rooms" and get the relevant attributes */
        for (Room room : rooms) {
            System.out.println(
                            "\t\t\t\t\t\t\t\t\t\t====================================================================\n" +
                            "\t\t\t\t\t\t\t\t\t\t|| ROOM NUMBER: " + room.getNumber() + "\n" +
                            "\t\t\t\t\t\t\t\t\t\t|| TYPE: " + room.getType() + "\n" +
                            "\t\t\t\t\t\t\t\t\t\t|| OCCUPATION STATUS:  " + (room.isOccupied()? "Occupied":"Free") + "\n" +
                            "\t\t\t\t\t\t\t\t\t\t|| CLEANLINESS STATUS: " + (room.isClean()? "Clean":"Dirty") + "\n" +
                            "\t\t\t\t\t\t\t\t\t\t|| WORKING CONDITION: " + (room.isOutOfOrder()? "Out of Order":"In Order") + "\n" +
                            "\t\t\t\t\t\t\t\t\t\t|| STANDARD PRICE: "+ room.getStandardPrice() + " DKK\n" +
                            "\t\t\t\t\t\t\t\t\t\t====================================================================" +
                            "\n\n\n");
        }

        /* Use any user input to close the report */
        System.out.println("\n\n\n\n\n\nInsert anything to go back");
        Scanner wait = new Scanner(System.in);
        wait.nextLine();
    }
}