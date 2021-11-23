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

    public void printLogo();
	public void printLoginMenu();
	public void printMainMenu();
	public void printBookingsMenu();
	public void printRoomsMenu();
	public void printStaffMenu();
	public void printFinanceMenu();
}