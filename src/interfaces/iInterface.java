package interfaces;
/**
 * Interface
 */
public interface iInterface {
	String logo = "\n" +
			"██╗░░██╗░█████╗░████████╗███████╗██╗░░░░░  ██████╗░██╗░░░░░░█████╗░███████╗░█████╗░\n" +
			"██║░░██║██╔══██╗╚══██╔══╝██╔════╝██║░░░░░  ██╔══██╗██║░░░░░██╔══██╗╚════██║██╔══██╗\n" +
			"███████║██║░░██║░░░██║░░░█████╗░░██║░░░░░  ██████╔╝██║░░░░░███████║░░███╔═╝███████║\n" +
			"██╔══██║██║░░██║░░░██║░░░██╔══╝░░██║░░░░░  ██╔═══╝░██║░░░░░██╔══██║██╔══╝░░██╔══██║\n" +
			"██║░░██║╚█████╔╝░░░██║░░░███████╗███████╗  ██║░░░░░███████╗██║░░██║███████╗██║░░██║\n" +
			"╚═╝░░╚═╝░╚════╝░░░░╚═╝░░░╚══════╝╚══════╝  ╚═╝░░░░░╚══════╝╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝";

     void printLogo();
	 void printLoginMenu();
	 void printMainMenu();
	 void printBookingsMenu();
	 void printRoomsMenu();
	 void printStaffMenu();
	 void printFinanceMenu();
}