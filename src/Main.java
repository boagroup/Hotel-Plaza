import DatabasePackage.Database;
import ItemsPackage.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Main
 */
public final class Main implements Serializable {

    static boolean isLoggedIn = false;
    // testing
//    static ArrayList<Room> list = new ArrayList<>();

    public static void main(String[] args) {
        // testing
//        list.add(new Room(1));
//        list.add(new Room(2));
//        list.add(new Room(3));
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (!isLoggedIn) {
                loginMenu(sc);
            } else {
                mainMenu(sc);
            }
        }
    }

    /**
     * Enables the user to authenticate or to terminate the program
     */
    public static void loginMenu(Scanner sc) {
        String answer;
        while (!isLoggedIn) {
            UI.printLoginMenu();
            answer = sc.nextLine();
            switch (answer) {

                case "1": // Login
                    Authentication.login();
                    if (Authentication.isLoginSuccessful()) {
                        isLoggedIn = true;
                        Authentication.setLoginSuccessful(false);
                    } else {
                        System.out.println("\nLogin unsuccessful. Try again.");
                        UI.sleep(750);
                    }
                    break;

                case "2": // Register
                    Authentication.register();
                    break;

                case "3": // Terminate program
                    System.exit(0);
                    break;

                // CHANGE THE VALUE OF CASE "4" TO "Admin" FOR FINAL VERSION
                case "4": // Overwrite login as Admin

                    Authentication.setLoggedInUser(new User("Admin", "0", (byte) 127));
                    isLoggedIn = true;
                    System.out.println("\nAuthentication override for development purposes");
                    UI.sleep(1250);
                    break;

                default: // Invalid user input
                    System.out.println("\nInvalid input. Retry.");
                    UI.sleep(300);
                    return;
            }
        }
    }

    public static void mainMenu(Scanner sc) {
        String answer;
        mainLoop:
        while (isLoggedIn) {
            UI.printMainMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "1":
                    BookingsMenu(sc);
                    break;
                case "2":
                    RoomsMenu(sc);
                    break;
                case "3":
                    StaffMenu(sc);
                    break;
                case "4":
                    FinanceMenu(sc);
                    break;
                case "5":
                    System.out.println("\nLogging out...");
                    Authentication.setLoggedInUser(null);
                    isLoggedIn = false;
                    UI.loadingScreen();
                    break;
                default:
                    System.out.println("\nInvalid Option");
                    UI.sleep(150);
                    return;
            }
        }
    }

    public static void BookingsMenu(Scanner sc) {
        String answer;
        while (true) {
            UI.printBookingsMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "1": // Add Booking
                    break;
                case "2": // Manage Bookings
                    listAll(Booking.class, sc);
                    break;
                case "3": // Display In-house Report
                    break;
                case "4": // Go back
                    return;
                default:
                    System.out.println("\nInvalid option");
                    UI.sleep(150);
                    break;
            }
        }
    }

    public static void RoomsMenu(Scanner sc) {
        String answer;
        ArrayList<Room> list = Database.getList(Room.class);
        while (true) {
            UI.printRoomsMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "1": // Add Room
                    break;
                case "2": // Manage Rooms
                    listAll(Room.class, sc);
                    break;
                case "3": // Display Room Availability
                    break;
                case "4": // Go back
                    return;
                default:
                    System.out.println("\nInvalid option");
                    UI.sleep(150);
                    break;
            }
        }
    }

    public static void StaffMenu(Scanner sc) {
        String answer;
        while (true) {
            UI.printStaffMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "1": // Add Staff
                    System.out.println("Nothing here yet");
                    break;

                case "2": // Manage Staff
                    listAll(Staff.class, sc);
                    break;

                case "3": // List Users
                    Authentication.listUsers();
                    break;

                case "4": // Remove User
                    Authentication.removeUser();
                    break;

                case "5": // Go back
                    return;

                default:
                    System.out.println("\nInvalid option");
                    UI.sleep(150);
                    break;
            }
        }
    }

    public static void FinanceMenu(Scanner sc) {
        String answer;
    }

    public static <T extends Item> void listAll(Class<T> type, Scanner sc) {
        if (!Database.loadDatabase()) {
            UI.printLogo();
            System.out.println("Something went horribly wrong!");
        }
        ArrayList<T> list = Database.getList(type);

        if (list == null || list.isEmpty()) {
            UI.printLogo();
            System.out.println("List is empty!");
        } else {
            Integer counter;
            while (true) {
                UI.printLogo();
                counter = 1;
                for (Object elem: list ) {
                    System.out.print(counter++ + ". ");
                    System.out.println(elem.toString());
                }
                try {
                    seeDetails(list.get(sc.nextInt()-1), list, sc);
                    return;
                } catch (Exception e) {
                    if (e instanceof InputMismatchException) {
                        System.out.println("You need to enter an integer!");
                    }
                    else if (e instanceof IndexOutOfBoundsException) {
                        System.out.println("The number you put is too high!");
                    }
                    else {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    public static <T extends Item> void seeDetails(T obj, ArrayList<T> list, Scanner sc) {
        String answer;
        DetailsLoop:
        while (true) {
            UI.printLogo();
            System.out.println(obj.toString());
            System.out.println("1. Edit\n" +
                    "2. Remove\n" +
                    "3. Go back\n" +
                    "\nWhat do you wish to do?\n");
            answer = sc.nextLine();
            switch (answer) {
                case "1": // Edit
//                    obj.edit();
                    break DetailsLoop;
                case "2": // Remove
                    list.remove(obj);
                    UI.printLogo();
                    System.out.println("Removed successfully");
                    break DetailsLoop;
                case "3": // Go back
                    return;
            }
//            Database.saveDatabase();
        }
    }

}