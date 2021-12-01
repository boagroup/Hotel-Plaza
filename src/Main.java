import java.util.Scanner;
import interfaces.UI;
/**
 * Main
 */
public class Main implements UI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = null;
        UI.printLoginMenu();
        loginMenu(sc, answer);
        MainMenu(sc, answer);
        sc.close();
    }

    public static void loginMenu(Scanner sc, String answer) {
        sc.nextLine();
    }
    public static void MainMenu(Scanner sc, String answer) {
        mainLoop:
        while (true) {
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
                    break mainLoop;
                default:
                    break;
            }
        }
    }
    public static void BookingsMenu(Scanner sc, String answer) {
        UI.printBookingsMenu();
        sc.nextLine();
    }
    public static void RoomsMenu(Scanner sc, String answer) {
        UI.printRoomsMenu();
        sc.nextLine();
    }
    public static void StaffMenu(Scanner sc, String answer) {
        UI.printStaffMenu();
        sc.nextLine();
    }
    public static void FinanceMenu(Scanner sc, String answer) {
        UI.printFinanceMenu();
        sc.nextLine();
    }
}