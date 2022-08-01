import java.util.Scanner;

class MainMenu {//The first show of menu
	public static void mainMenu(Scanner keyboard) {
		System.out.println("**********************************************************");
		System.out.println("\t  REAL ESTATE ADVISOR MANAGEMENT SYSTEM");
		System.out.println("**********************************************************");
		System.out.println("\t\t-----------------------");
		System.out.println("\t\t coded BY Hadi & Arash");
		System.out.println("\t\t-----------------------");
		System.out.println("\n[1] Real Estate Advisor");
		System.out.println("[2] Customer ");

		System.out.println("\n[00] Exit");

		System.out.print("\nYour Choice: ");

		MainMenu.mainMenueMakeChoice(keyboard);// Call method for getting number in first menu
	}

	public static void mainMenueMakeChoice(Scanner keyboard) {//Getting the numbers in menu from user
		int choice = 0;
		choice = MainMenu.choiceMaker(keyboard);// Getting number as user's choice
		

		System.out.println("\n\n###################################################\n");

		switch (choice) {
		case 1: { // Real Estate Advisor //
			Password.checkPass(keyboard);// Check password just for real estate advisor
			MainMenu.realEstateChoice(keyboard);// Open the advisor access method

			break;
		}
		case 2: { // Customer //
			System.out.println("[1] Buyer\n" + "[2] Seller\n\n" + "[99] Back\n" + "[00] Exit\n\n" + "Your Choice: ");

			int choice2 = 0;
			choice2 = MainMenu.choiceMaker(keyboard);// Getting number as user's choice

			switch (choice2) {
			case 1: { // buyer
				MainMenu.buyerChoice(keyboard);
				break;
			}
			case 2: { // seller
				MainMenu.sellerChoice(keyboard);
				break;
			}
			default: {
				System.out.println("Unexpected value: " + choice2 + "\n" + "Press ENTER to try again...");
				keyboard.nextLine();
				keyboard.nextLine();
				MainMenu.mainMenu(keyboard);
				break;
			}
			}
		}
		case 00: {
			CodeExit.out();
			break;
		}
		default: {
			System.out.println("Unexpected value: " + choice + "\n" + "Press ENTER to try again...");
			keyboard.nextLine();
			keyboard.nextLine();
			MainMenu.mainMenu(keyboard);
			break;
		}
		}
	}

	public static void realEstateChoice(Scanner keyboard) {// Open the advisor access method
		RealEstateAdvisor admin = new RealEstateAdvisor();
		admin.createFile(keyboard);

		System.out.println("\n[1] Add Buyer");
		System.out.println("[2] Add Seller ");
		System.out.println("[3] Remove Person ");
		System.out.println("[4] Add Property ");
		System.out.println("[5] Remove Property ");
		System.out.println("[6] Search in Buyers ");
		System.out.println("[7] Search in Sellers ");
		System.out.println("[8] Search in Properties ");
		System.out.println("[9] Change password");

		System.out.println("\n[99] Back");
		System.out.println("[00] Exit");

		System.out.print("\nYour Choice: ");

		int choice;
		choice = MainMenu.choiceMaker(keyboard);// Getting number as user's choice

		switch (choice) {
		case 1: { // Add Buyer
			admin.addBuyer(keyboard);
			break;
		}
		case 2: { // Add Seller
			admin.addSeller(keyboard);
			break;
		}
		case 3: { // Remove person
			admin.rmPerson();
			break;
		}
		case 4: { // Add Property
			admin.addProperty(keyboard);
			break;
		}
		case 5: { // Remove Property
			admin.rmProperty();
			break;
		}
		//////////////////////////////////
		case 6: { // Search in Buyers
			Search.buyersSearchMenu.menu(keyboard);
			
			keyboard.nextLine();
			MainMenu.realEstateChoice(keyboard);
			break;
		}
		case 7: { // Search in Sellers
			Search.sellersSearchMenu.menu(keyboard);
			
			keyboard.nextLine();
			MainMenu.realEstateChoice(keyboard);
			break;
		}
		case 8: { // Search in Properties
			Search.propertiesSearchMenu.menu(keyboard);

			System.out.println("Press ENTER to go back...");
			keyboard.nextLine();
			MainMenu.realEstateChoice(keyboard);
			break;
		}
		///////////////////////////////////
		case 9: { // Change pass
			admin.pass(keyboard);
			break;
		}
		case 99: { // Back
			MainMenu.mainMenu(keyboard);
			break;
		}
		case 0: { // Exit
			CodeExit.out();
			break;
		}
		default:
			System.out.print("Please Enter a valid choice: ");
			break;
		}
		MainMenu.realEstateChoice(keyboard);

	}

	public static void buyerChoice(Scanner keyboard) {
		System.out.println("\n\n\n\n"
				+ "###################################################\n"
				+ "Buyer Panel ===>>\n\n"
				+ "[1] Search");
		System.out.println("[2] Show Properties List");
		System.out.println("[3] Buy! :D");

		System.out.println("\n[99] Back");
		System.out.println("[00] Exit");
		
		System.out.print("\nYour Choice: ");

		int choice;
		choice = MainMenu.choiceMaker(keyboard);// Getting number as user's choice
		Buyer buyer = new Buyer();

		switch (choice) {
		case 1: {
			// Search
			buyer.search(keyboard);
			MainMenu.buyerChoice(keyboard);
			break;
		}
		case 2: {
			// show properties list
			buyer.getPropList(keyboard);
			MainMenu.buyerChoice(keyboard);
			break;
		}
		case 3: {
			// buying
			buyer.buy(keyboard);
			MainMenu.buyerChoice(keyboard);
			break;
		}
		case 99: {
			MainMenu.mainMenu(keyboard);
			break;
		}
		case 00: {
			CodeExit.out();
			break;
		}
		default:
			System.out.println("Unexpected value: " + choice + "\n" + "Press ENTER to try again...");
			keyboard.nextLine();
			keyboard.nextLine();
			MainMenu.buyerChoice(keyboard);
			break;
		}

	}

	public static void sellerChoice(Scanner keyboard) {
		System.out.println("\n\n\n\n"
				+ "###################################################\n"
				+ "Seller Panel ===>>\n\n"
				+ "[1] Add your Property");
		System.out.println("[2] Remove your Property");

		System.out.println("\n[99] Back");
		System.out.println("[00] Exit");

		int choice;
		choice = MainMenu.choiceMaker(keyboard);// Getting number as user's choice
		Seller seller = new Seller();
		switch (choice) {
		case 1: {
			// Add your Property
			seller.addProperty(keyboard);
			MainMenu.sellerChoice(keyboard);
			break;
		}
		case 2: {
			// Remove Property
			seller.rmProperty();
			MainMenu.sellerChoice(keyboard);
			break;
		}
		case 99: {
			MainMenu.mainMenu(keyboard);
			break;
		}
		case 00: {
			CodeExit.out();
			break;
		}
		default:
			System.out.println("Unexpected value: " + choice + "\n" + "Press ENTER to try again...");
			keyboard.nextLine();
			keyboard.nextLine();
			MainMenu.sellerChoice(keyboard);
			break;
		}

	}

	public static int choiceMaker(Scanner keyboard) {// Getting number as user's choice
		int choice = 0;
		try {
			choice = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid choice! Press Enter for Main Menu...");
			keyboard.nextLine();
			keyboard.nextLine();
			MainMenu.mainMenu(keyboard);
			System.exit(0);
		}

		return choice;
	}
}