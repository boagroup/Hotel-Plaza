import java.util.Scanner;
/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = null;
        loginMenu(sc, answer);
        MainMenu(sc, answer);
        sc.close();
    }

    /**
     * Enables the user to authenticate or to terminate the program
     */
    public static void loginMenu(Scanner sc, String answer) {
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.println("Pick an option: ");
            System.out.println("1. Login\n2. Register\n3. Exit");
            answer = sc.nextLine();

            if (answer.equals("1")) {
                Authentication.login();
                if (Authentication.isLoginSuccessful()) {
                    isLoggedIn = true;
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
            else if (answer.equals("4")) {                                                 //REMOVE THIS LINE FOR FINAL VERSION
                Authentication.loggedInUser = new User("Admin","0", (byte) 5);  //REMOVE THIS LINE FOR FINAL VERSION
                isLoggedIn = true;                                                         //REMOVE THIS LINE FOR FINAL VERSION
                System.out.println("Authentication override for development purposes");    //REMOVE THIS LINE FOR FINAL VERSION
                System.out.println(Authentication.loggedInUser);                           //REMOVE THIS LINE FOR FINAL VERSION
            }                                                                              //REMOVE THIS LINE FOR FINAL VERSION
            else {
                System.out.println("Invalid input. Retry.");
            }
        }
    }
    public static void MainMenu(Scanner sc, String answer) {
        mainLoop:
        while (true) {
            System.out.println("What do you wish to do?");
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
                    break mainLoop;
                default:
                    break;
            }
        }
    }
    public static void BookingsMenu(Scanner sc, String answer) {}
    public static void RoomsMenu(Scanner sc, String answer) {}
    public static void StaffMenu(Scanner sc, String answer) {}
    public static void FinanceMenu(Scanner sc, String answer) {}
}