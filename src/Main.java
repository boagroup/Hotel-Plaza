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
            System.out.println("Pick an option: ");
            System.out.println("1. Login\n2. Register\n3. Exit");
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
            else if (answer.equals("4")) {                                                      //REMOVE THIS LINE FOR FINAL VERSION
                Authentication.setLoggedInUser(new User("Admin","0", (byte) 5));       //REMOVE THIS LINE FOR FINAL VERSION
                isLoggedIn = true;                                                              //REMOVE THIS LINE FOR FINAL VERSION
                System.out.println("Authentication override for development purposes");         //REMOVE THIS LINE FOR FINAL VERSION
                System.out.println(Authentication.getLoggedInUser());                           //REMOVE THIS LINE FOR FINAL VERSION
            }                                                                                   //REMOVE THIS LINE FOR FINAL VERSION
            else {
                System.out.println("Invalid input. Retry.");
            }
        }
    }
    public static void MainMenu(Scanner sc, String answer) {
        mainLoop:
        while (isLoggedIn) {
            System.out.println("What do you wish to do?");
            System.out.println(
                    "1. Open Bookings Menu\n" +
                    "2. Open Rooms Menu\n" +
                    "3. Open Staff Menu\n" +
                    "4. Open Finance Menu\n" +
                    "5. Log out");

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
                    Interface.loadingScreen();
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
            Interface.menuLogo("Staff Menu");
            System.out.println(
                    "Pick an option: " +
                            "\n1. Add Staff" +
                            "\n2. Manage Staff" +
                            "\n3. List System Users" +
                            "\n4. Go back");
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
                    return;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    public static void FinanceMenu(Scanner sc, String answer) {}
}