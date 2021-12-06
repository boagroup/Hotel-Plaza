import DatabasePackage.Database;
import ItemsPackage.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Main
 */
public final class Main implements Serializable {

    static boolean isLoggedIn = false;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // testing
//        list.add(new Room(1));
//        list.add(new Room(2));
//        list.add(new Room(3));
        if (Database.fileExists()) {
            Database.loadDatabase();
        }
        Database.putList(Room.class);
        Database.putList(Guest.class);
        Database.putList(Staff.class);
        Database.putList(Booking.class);
//        ArrayList<Room> list = Database.getList(Room.class);
////        list.add(new Room(101));
////        list.add(new Room(201));
////        list.add(new Room(333));
        Database.saveDatabase();
        while (true) {
            if (!isLoggedIn) {
                loginMenu();
            } else {
                mainMenu();
            }
        }
    }

    /**
     * Enables the user to authenticate or to terminate the program
     */
    public static void loginMenu() {
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
                    sc.close();
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

    public static void mainMenu() {
        String answer;
        mainLoop:
        while (isLoggedIn) {
            UI.printMainMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "1":
                    BookingsMenu();
                    break;
                case "2":
                    RoomsMenu();
                    break;
                case "3":
                    StaffMenu();
                    break;
                case "4":
                    FinanceMenu();
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

    public static void BookingsMenu() {
        String answer;
        while (true) {
            UI.printBookingsMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "1": // Add Booking
                    addBooking();
                    break;
                case "2": // Manage Bookings
                    listAll(Booking.class);
                    break;
                case "3": // Display In-house Report
                    UI.displayInHouseReport();
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

    public static void RoomsMenu() {
//        String answer;
        while (true) {
            UI.printRoomsMenu();
            UI.sleep(100);
//            answer = sc.nextLine();
            switch (sc.nextLine()) {
                case "1": // Add Room
                    if (Authentication.getLoggedInUser().getPermission() >= 3) {
                        addItem(Room.class, new Room(Database.getList(Room.class).size() + 101));
                    }
                    else {
                        System.out.println("You do not have the required permission level to add new rooms!");
                        UI.sleep(1350);
                    }
                    break;
                case "2": // Manage Rooms
                    if (Authentication.getLoggedInUser().getPermission() >= 3) {
                        listAll(Room.class);
                    }
                    else {
                        System.out.println("You do not have the required permission level to manage rooms!");
                        UI.sleep(1350);
                    }
                    break;
                case "3": // Display Room Availability
                    UI.displayAvailabilityReport();
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

    public static void StaffMenu() {
        String answer;
        while (true) {
            UI.printStaffMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "1": // Add Staff
                    if (Authentication.getLoggedInUser().getPermission() >= 3) {
                        addItem(Staff.class, new Staff(""));
                    }
                    else {
                        System.out.println("You do not have the required permission level to add new staff members!");
                        UI.sleep(1400);
                    }
                    break;

                case "2": // Manage Staff
                    if (Authentication.getLoggedInUser().getPermission() >= 3) {
                        listAll(Staff.class);
                    }
                    else {
                        System.out.println("You do not have the required permission level to manage staff!");
                        UI.sleep(1350);
                    }
                    break;

                case "3": // List Users
                    Authentication.listUsers();
                    break;

                case "4": // Remove User
                    if (Authentication.getLoggedInUser().getPermission() >= 3) {
                        Authentication.removeUser();
                    }
                    else {
                        System.out.println("You do not have the required permission level to remove users!");
                        UI.sleep(1350);
                    }
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

    public static void FinanceMenu() {
        while(true){
            double dough = 0;
            UI.printLogo();
            UI.printFinanceMenu();
            switch (sc.nextLine()) {
                case "1": // Display Income Report
                    if (Authentication.getLoggedInUser().getPermission() >= 3) {
                        if (!Database.loadDatabase()) {
                            UI.printLogo();
                            System.out.println("Something went horribly wrong!");
                            UI.sleep(1000);
                            break;
                        }
                        for (Booking elem : Database.getList(Booking.class)) {
                            dough += elem.getRoom().getStandardPrice() * (1 + ChronoUnit.DAYS.between(elem.getCheckInDate(), elem.getCheckOutDate()));
                        }
                        UI.printLogo();
                        System.out.println("\t\t\t\t\t<=========================================>");
                        System.out.println("\t\t\t\t\tTOTAL INCOME (before taxes): ");
                        System.out.println("\t\t\t\t\t\t" + dough + " DKK\n\n");
                        System.out.println("\t\t\t\t\tTOTAL INCOME (after taxes): ");
                        System.out.println("\t\t\t\t\t\t" + dough * 0.75 + " DKK");
                        System.out.println("\t\t\t\t\t<=========================================>");
                        System.out.println("\t\t\t\t\t\n\nInsert anything to go back");
                        sc.nextLine();
                    }
                    else {
                        System.out.println("You do not have the required permission level to access the financial report!");
                        UI.sleep(1600);
                    }
                    break;
                case "2": // Go back
                    return;
            }
        }
    }

    public static <T extends Item> void listAll(Class<T> type) {
        if (!Database.loadDatabase()) {
            UI.printLogo();
            System.out.println("Something went horribly wrong!");
            UI.sleep(1000);
            return;
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
                System.out.println("\n\n0. Go Back\n");
                try {
                    counter = sc.nextInt();
                    if (counter < 1) {
                        return;
                    }
                    seeDetails(list.get(counter-1), list);
                } catch (Exception e) {
                    UI.printLogo();
                    if (e instanceof InputMismatchException) {
                        System.out.println("You need to enter an integer!");
                    }
                    else if (e instanceof IndexOutOfBoundsException) {
                        System.out.println("The number you put is too high!");
                    }
                    else {
                        System.out.println(e.getMessage());
                    }
                    UI.sleep(1000);
                }
            }
        }
    }

    public static <T extends Item> void seeDetails(T obj, ArrayList<T> list) {
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
                    UI.printLogo();
                    while(obj.edit(sc)) {
                        UI.printLogo();
                    }
                    UI.printLogo();
                    if (Database.saveDatabase()) {
                        System.out.println("Edited successfully");
                    } else {
                        System.out.println("Something went horribly wrong!");
                    }
                    break DetailsLoop;
                case "2": // Remove
                    list.remove(obj);
                    UI.printLogo();
                    if (Database.saveDatabase()) {
                        System.out.println("Removed successfully");
                    } else {
                        System.out.println("Something went horribly wrong!");
                    }
                    UI.sleep(1000);
                    break DetailsLoop;
                case "3": // Go back
                    break DetailsLoop;
                default:
                    break;
            }
//            Database.saveDatabase();
        }
    }

    public static <T extends Item> void addItem(Class<T> type, T obj) {
        UI.printLogo();
        if (!Database.loadDatabase()) {
            UI.printLogo();
            System.out.println("Something went horribly wrong!");
            UI.sleep(1000);
            return;
        }
        ArrayList<T> list = Database.getList(type);
        try {
            while(obj.edit(sc)) {
                UI.printLogo();
            }
            UI.printLogo();
            questionLoop:
            while (true) {
                UI.printLogo();
                System.out.println("Do you wish to add this " + type.getSimpleName() + " to the Database?");
                System.out.println("1. Yes\n2. No");
                switch (sc.nextLine()) {
                    case "1":
                        list.add(obj);;
                        break questionLoop;
                    case "2":
                        System.out.println("Adding abandoned");
                        return;
                    default:
                        System.out.println("Wrong input!");
                        break;
                }
            }
            if (Database.saveDatabase()) {
                System.out.println("Added successfully");
            } else {
                System.out.println("Something went horribly wrong!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addBooking() {
        if (!Database.loadDatabase()) {
            UI.printLogo();
            System.out.println("Something went horribly wrong!");
            return;
        }
        ArrayList<Room> rooms = Database.getList(Room.class);
        if (rooms == null || rooms.isEmpty()) {
            UI.printLogo();
            System.out.println("Add Rooms first!");
            return;
        }
        Booking booking = new Booking();
//        boolean dateAlert = false;
        Integer counter;
        booking.setGuest(new Guest(""));
        bookingLoop:
        while (true) {
            UI.printLogo();
            System.out.println("1. Guest: " + (booking.getGuest().toString()));
            System.out.println("2. Room: " + (booking.getRoom()==null?"Not chosen!": booking.getRoom().toString()));
            System.out.println("3. Check-in Date: " + (booking.getCheckInDate()==null?"Not chosen!": booking.getCheckInDate().toString()));
            System.out.println("   Check-out Date: " + ( booking.getCheckOutDate()==null?"Not chosen!":  booking.getCheckOutDate().toString()));
//            if (dateAlert) {
//                System.out.println("Warning! Your room is unavailable during this time!");
//            }
            System.out.println("\n9. Finish Adding Booking");
            System.out.println("0. Abandon\n");
            System.out.println("What do you wish to do?");
            switch (sc.nextLine()) {
                case "1":
                    UI.printLogo();
                    while(booking.getGuest().edit(sc)) {
                        UI.printLogo();
                    }
                    break;
                case "2":
                    rooms = Database.getList(Room.class);
                    while(true) {
                        UI.printLogo();
                        counter = 1;
                        for (Object elem: rooms ) {
                            System.out.print(counter++ + ". ");
                            System.out.println(elem.toString());
                        }
                        System.out.println("\n\n0. None\n");
                        try {
                            counter = Integer.parseInt(sc.nextLine());
                            booking.setRoom((counter < 1 ? null : rooms.get(counter-1)));
                            break;
                        } catch (Exception e) {
                            UI.printLogo();
                            System.out.println((e instanceof NumberFormatException? "You have to put in a number!":e.getMessage()));
                            UI.sleep(2000);
                        }
                    }
                    if (!checkDates(booking.getCheckInDate(), booking.getCheckOutDate(), booking.getRoom())) {
                        UI.printLogo();
                        System.out.println("During this period room is occupied!");
                        booking.setRoom(null);
                        UI.sleep(2000);
                    }
                    break;
                case "3":
                    UI.printLogo();
                    while (booking.edit(sc)) {
                        UI.printLogo();
                    }
                    if (!checkDates(booking.getCheckInDate(), booking.getCheckOutDate(), booking.getRoom())) {
                        UI.printLogo();
                        System.out.println("During this period room is occupied!");
                        booking.setCheckInDate(null);
                        booking.setCheckOutDate(null);
                        UI.sleep(2000);
                    }
                    break;
                case "9":
                    if (booking.getRoom() == null || booking.getGuest() == null || booking.getCheckInDate() == null || booking.getCheckOutDate() == null) {
                        UI.printLogo();
                        System.out.println("You need to fill everything!");
                        UI.sleep(2000);
                        break;
                    }
                    break bookingLoop;
                case "0":
                    return;
                default:
                    System.out.println("Wrong input!");
                    UI.sleep(1000);
            }
        }
        if (Database.getList(Booking.class).add(booking)) {
            if (Database.saveDatabase()) {
                UI.printLogo();
                System.out.println("You successfully added the Booking!");
            }
        }
    }

    public static boolean checkDates(LocalDate checkIn, LocalDate checkOut, Room room) {
        Database.loadDatabase();
        for (Booking elem: Database.getList(Booking.class)) {
            if (elem.getRoom() != room) {
                continue;
            }
            LocalDate in = elem.getCheckInDate();
            LocalDate out = elem.getCheckOutDate();
            if (!(checkIn.isAfter(out) || checkOut.isBefore(in)) || checkIn.isEqual(out)) {
                return false;
            }
        }
        return true;
    }
}