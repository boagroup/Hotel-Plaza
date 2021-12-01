import interfaces.UI;

import java.util.Scanner;
/**
 * Main
 */

public class Main implements UI {

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
                    System.out.println("Login unsuccessful. Try again.");
                }
            }
            else if (answer.equals("2")) {
                Authentication.register();
            }
            else if (answer.equals("3")) {
                System.exit(0);
            }
            else if (answer.equals("4")) { // CHANGE THE VALUE OF THIS LINE FOR FINAL VERSION
                Authentication.setLoggedInUser(new User("Admin","0", (byte) 5));
                isLoggedIn = true;
                System.out.println("Authentication override for development purposes");
                System.out.println(Authentication.getLoggedInUser());
            }
            else {
                System.out.println("Invalid input. Retry.");
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
                    System.out.println("Logging out...");
                    UI.loadingScreen();
                    Authentication.setLoggedInUser(null);
                    isLoggedIn = false;
                    break;
                default:
                    System.out.println("Invalid Option");
                    return;
            }
        }
    }
    public static void BookingsMenu(Scanner sc, String answer) {}
    public static void RoomsMenu(Scanner sc, String answer) {}
    public static void StaffMenu(Scanner sc, String answer) {

        while (true) {
            UI.menuLogo("Staff Menu");
            System.out.println(
                    "Pick an option: " +
                            "\n1. Add Staff" +
                            "\n2. Manage Staff" +
                            "\n3. List System Users" +
                            "\n4. Remove User" +
                            "\n5. Go back");
            answer = sc.nextLine();
            switch (answer) {
                case "1":
                    System.out.println("Nothing here yet");
                    break;

                case "2":
                    System.out.println("Nope");
                    break;

                case "3":
                    Authentication.listUsers();
                    break;

                case "4":
                    Authentication.removeUser();
                    break;

                case "5":
                    return;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    public static void FinanceMenu(Scanner sc, String answer) {}
}