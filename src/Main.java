import java.util.Scanner;
/**
 * Main
 */
public final class Main {

    static boolean isLoggedIn = false;

    public static void main(String[] args) {
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
    }

    public static void RoomsMenu(Scanner sc) {
        String answer;
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
                    System.out.println("Nope");
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
}