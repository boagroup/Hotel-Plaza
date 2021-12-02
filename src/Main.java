

import java.util.Scanner;
/**
 * Main
 */

public class Main {

    static boolean isLoggedIn = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = null;
        while (true) {
            if (!isLoggedIn) {
                loginMenu(sc, answer);
            } else {
                MainMenu(sc, answer);
            }
        }

    }

    /**
     * Enables the user to authenticate or to terminate the program
     */
    public static void loginMenu(Scanner sc, String answer) {

        while (!isLoggedIn) {
            UI.printLoginMenu();
            answer = sc.nextLine();
            if (answer.equals("1")) {
                Authentication.login();
                if (Authentication.isLoginSuccessful()) {
                    isLoggedIn = true;
                    Authentication.setLoginSuccessful(false);
                }
                else {
                    System.out.println("\nLogin unsuccessful. Try again.");
                    UI.wait(750);
                }
            }
            else if (answer.equals("2")) {
                Authentication.register();
            }
            else if (answer.equals("3")) {
                System.exit(0);
            }
            else if (answer.equals("4")) { // CHANGE THE VALUE OF THIS LINE FOR FINAL VERSION
                Authentication.setLoggedInUser(new User("Admin","0", (byte) 127));
                isLoggedIn = true;
                System.out.println("\nAuthentication override for development purposes");
                System.out.println(Authentication.getLoggedInUser());
                UI.wait(1000);
            }
            else {
                System.out.println("\nInvalid input. Retry.");
                UI.wait(300);
            }
        }
    }
    public static void MainMenu(Scanner sc, String answer) {
        mainLoop:
        while (isLoggedIn) {
            UI.printMainMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "1":
                    BookingsMenu(sc, answer);
                    break;
                case "2":
                    RoomsMenu(sc, answer);
                    break;
                case "3":
                    StaffMenu(sc, answer);
                    break;
                case "4":
                    FinanceMenu(sc, answer);
                    break;
                case "5":
                    System.out.println("\nLogging out...");
                    Authentication.setLoggedInUser(null);
                    isLoggedIn = false;
                    UI.loadingScreen();
                    break;
                default:
                    System.out.println("\nInvalid Option");
                    UI.wait(150);
                    return;
            }
        }
    }
    public static void BookingsMenu(Scanner sc, String answer) {}
    public static void RoomsMenu(Scanner sc, String answer) {}
    public static void StaffMenu(Scanner sc, String answer) {

        while (true) {
            UI.printStaffMenu();
            answer = sc.nextLine();
            switch (answer) {
                case "1": // See Bookings Menu
                    System.out.println("Nothing here yet");
                    break;

                case "2": // See Room Menu
                    System.out.println("Nope");
                    break;

                case "3": // See Staff Menu
                    Authentication.listUsers();
                    break;

                case "4": // See Finance Options
                    Authentication.removeUser();
                    break;

                case "5": // Log out
                    return;

                default:
                    System.out.println("\nInvalid option");
                    UI.wait(150);
                    break;
            }
        }
    }
    public static void FinanceMenu(Scanner sc, String answer) {}
}