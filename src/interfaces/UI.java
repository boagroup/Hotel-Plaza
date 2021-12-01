package interfaces;
/**
 * UI
 */
public interface UI {
	String logo =
			"\n" +
			"██╗░░██╗░█████╗░████████╗███████╗██╗░░░░░  ██████╗░██╗░░░░░░█████╗░███████╗░█████╗░\n" +
			"██║░░██║██╔══██╗╚══██╔══╝██╔════╝██║░░░░░  ██╔══██╗██║░░░░░██╔══██╗╚════██║██╔══██╗\n" +
			"███████║██║░░██║░░░██║░░░█████╗░░██║░░░░░  ██████╔╝██║░░░░░███████║░░███╔═╝███████║\n" +
			"██╔══██║██║░░██║░░░██║░░░██╔══╝░░██║░░░░░  ██╔═══╝░██║░░░░░██╔══██║██╔══╝░░██╔══██║\n" +
			"██║░░██║╚█████╔╝░░░██║░░░███████╗███████╗  ██║░░░░░███████╗██║░░██║███████╗██║░░██║\n" +
			"╚═╝░░╚═╝░╚════╝░░░░╚═╝░░░╚══════╝╚══════╝  ╚═╝░░░░░╚══════╝╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝\n" +
			"\n";
	String title = "Hotel Plaza Management System\n";
	String credits = "Created by Boagroup\n";
	String inputQuestion = "\nWhat do you wish to do?\n";


	static void clearScreen() {
		try {
			System.out.print("clear");
			if(!System.getProperty("java.class.path").contains("idea_rt.jar")) {
				System.out.print("\033[H\033[2J");
				System.out.flush();
				if (System.getProperty("os.name").contains("Windows")) {
					Runtime.getRuntime().exec("cls");
				} else {
					Runtime.getRuntime().exec("clear");
				}
			}
		} catch (final Exception e) {
			//  Handle any exceptions.
		}
	}

     static void printLogo() {
		clearScreen();
		System.out.println(logo);
     }

	 static void printLoginMenu() {
		sleep();
		printLogo();
		String menu =   "Welcome to the " + title +
		                "Please log in or register your account to continue.\n\n" +
		                "1. Log in\n" +
		                "2. Register\n" +
						"3. Exit\n" +
		                inputQuestion;
	    System.out.println(menu);
	 }

	 static void printMainMenu() {
		sleep();
		printLogo();
		String menu =   title +
						credits + "\n" +
		                "1. See Bookings Menu\t\t\t" +
		                "2. See Room Menu\n" +
		                "3. See Staff Menu\t\t\t\t" +
		                "4. See Finance Options\n" +
						"\t\t\t\t\t5. Log out\n" +
		                inputQuestion;
		 System.out.println(menu);
	 }

	 static void printBookingsMenu() {
		sleep();
		printLogo();
		String menu =   title +
						credits + "\n" +
						"1. Create Booking\n" +
						"2. Manage Bookings\n" +
						"3. Display Inhouse Report\n" +
						"4. Exit\n" +
						inputQuestion;
	    System.out.println(menu);
	 }

	 static void printRoomsMenu() {
		sleep();
		printLogo();
		String menu =   title +
						credits + "\n" +
						"1. Add Room\n" +
						"2. Manage Rooms\n" +
						"3. Display Room Availability\n" +
						"4. Exit\n" +
						inputQuestion;
		 System.out.println(menu);
	 }

	 static void printStaffMenu() {
		sleep();
		printLogo();
		String menu =   title +
						credits + "\n" +
						"1. Add Staff\n" +
						"2. Manage Staff\n" +
						"3. Exit\n" +
						inputQuestion;
		System.out.println(menu);
	 }

	 static void printFinanceMenu() {
		sleep();
		printLogo();
		String menu =   title +
						credits + "\n" +
						"1. See Income Report\n" +
						"2. File Taxes\n" +
				        "3. Exit" +
						inputQuestion;
		System.out.println(menu);
	 }

	static void sleep() {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	static void wait(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	static void loadingScreen() {
		System.out.println("\n");
		System.out.print("||");
		wait(500);
		System.out.print("==========");
		wait(500);
		System.out.print("==========");
		wait(500);
		System.out.print("==========");
		wait(500);
		System.out.print("==========");
		wait(500);
		System.out.print("||");
		System.out.println("\n");
	}

	public static void menuLogo(String menuName) {
		System.out.println("\n||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("                   " + menuName);
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||\n");
	}
}
