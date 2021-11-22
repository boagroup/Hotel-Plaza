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

    public static void loginMenu(Scanner sc, String answer) {
        while (true) {
            Interface.printLoginMenu();
//            System.out.println("What do you wish to do?");
//            answer = sc.nextLine();
        }
    }
    public static void MainMenu(Scanner sc, String answer) {
        mainLoop:
        while (true) {
            Interface.printMainMenu();
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