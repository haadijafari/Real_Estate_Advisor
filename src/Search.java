import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Search {
	// Search in buyers
	static class buyersSearchMenu {
		public static void menu(Scanner keyboard) {
			// menu
			System.out.println("Search in Buyers:\n" + "*********************\n" + "[1] Search with National ID\n"
					+ "[2] Search with Name & LastName\n\n" + "[99] Back\n" + "[00] Exit\n\n");
			System.out.print("Enter your choice: ");

			// make choice
			int choice;
			choice = MainMenu.choiceMaker(keyboard);
			switch (choice) {
			case 1: { // Search with National ID
				System.out.print("Please enter Buyer's National Id: ");
				keyboard.nextLine();
				String buyerId = keyboard.nextLine();
				Search.searchWithName("ID" + buyerId, keyboard);
				System.out.println("Press ENTER to go back...");
				keyboard.nextLine();
				Search.buyersSearchMenu.menu(keyboard);
				break;
			}
			case 2: { // Search with name and last name
				System.out.print("Please enter Buyer's Name: ");
				keyboard.nextLine();
				String name = keyboard.nextLine();
				System.out.print("Please enter Buyer's LastName: ");
				String lastName = keyboard.nextLine();

				Search.searchWithNameAndLastName(name, lastName, keyboard);

				System.out.println("Press ENTER to go back...");
				keyboard.nextLine();
				Search.buyersSearchMenu.menu(keyboard);
				break;
			}
			case 99: { // the menu call will be in switch case that calls this method
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
				Search.buyersSearchMenu.menu(keyboard);
				break;
			}
		}
	}

	// Search in sellers
	static class sellersSearchMenu {
		public static void menu(Scanner keyboard) {
			// menu
			System.out.println("Search in Sellers:\n" + "*********************\n" + "[1] Search with National ID\n"
					+ "[2] Search with Name & LastName\n\n" + "[99] Back\n" + "[00] Exit\n\n");
			System.out.print("Enter your choice: ");

			// make choice
			int choice;
			choice = MainMenu.choiceMaker(keyboard);
			switch (choice) {
			case 1: { // Search with National ID
				System.out.print("Please enter Seller's National Id: ");
				keyboard.nextLine();
				String buyerId = keyboard.nextLine();
				Search.searchWithName("ID" + buyerId, keyboard);
				System.out.println("Press ENTER to go back...");
				keyboard.nextLine();
				Search.sellersSearchMenu.menu(keyboard);
				break;
			}
			case 2: { // Search with name and last name
				System.out.print("Please enter Seller's Name: ");
				keyboard.nextLine();
				String name = keyboard.nextLine();
				System.out.print("Please enter Seller's LastName: ");
				String lastName = keyboard.nextLine();

				Search.searchWithNameAndLastName(name, lastName, keyboard);

				System.out.println("Press ENTER to go back...");
				keyboard.nextLine();
				Search.sellersSearchMenu.menu(keyboard);
				break;
			}
			case 99: { // the menu call will be in switch case that calls this method
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
				Search.sellersSearchMenu.menu(keyboard);
				break;
			}
		}
	}

	// Search in properties
	static class propertiesSearchMenu {
		public static void menu(Scanner keyboard) {
			// menu
			System.out.println("Search in Properties:\n" + "*********************\n" + "[1] Search with Zip Code\n"
					+ "[2] Search with Price Filter\n\n" + "[99] Back\n" + "[00] Exit\n\n");
			System.out.print("Enter your choice: ");

			// make choice
			int choice;
			choice = MainMenu.choiceMaker(keyboard);
			switch (choice) {
			case 1: { // Search with Zip Code
				System.out.print("Please enter Property's Zip Code: ");
				keyboard.nextLine();
				String zipCode = keyboard.nextLine();
				Search.searchWithName("ZipCode" + zipCode, keyboard);
				System.out.println("Press ENTER to go back...");
				keyboard.nextLine();
				Search.propertiesSearchMenu.menu(keyboard);
				break;
			}
			case 2: { // Search with Price Filter
				System.out.print("Please enter Minimum price: ");
				keyboard.nextLine();
				String min = keyboard.nextLine();
				System.out.print("Please enter Maximum price: ");
				String max = keyboard.nextLine();

				Search.searchWithPrice(Long.parseLong(min), Long.parseLong(max), keyboard);

				System.out.println("\nPress ENTER to go back...");
				keyboard.nextLine();
				Search.propertiesSearchMenu.menu(keyboard);
				break;
			}
			case 99: { // the menu call will be in switch case that calls this method
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
				Search.propertiesSearchMenu.menu(keyboard);
				break;
			}
		}
	}

	public static void searchWithName(String fullFileName, Scanner keyboard) {
		boolean match = false;
		int matchCount = 1;
		int index = 0;
		String[] names = loopDirectory.txtNames();
		for (String s : names) {
			if (s.equalsIgnoreCase(fullFileName + ".txt")) {
				match = true;
				System.out.println(matchCount + " Match Found!");
			} else {
				names[index] = (null);
			}
			index++;
		}

		if (!match) {
			System.out.println("No Match Found :(");

		} else {
			System.out.println("Press ENTER to see the results...");
			keyboard.nextLine();
			for (String s : names) {
				if (s != null) {
					try {
						System.out.println(fullFileName);
						ShowFile.viewFile(s);
						System.out.println("\n**************************\n");
					} catch (Exception e) {
						System.out.println(
								"There was an error showing matched result :(\n" + "Please Try again later!\n");
					}
				}

			}
		}
	}

	public static void searchWithNameAndLastName(String name, String lastName, Scanner keyboard) {
		String[] files = loopDirectory.txtNames();

		boolean match = false;
		int matchCount = 0;
		int index = 0;
		for (String s : files) {
			File f = new File(s);
			Scanner fSc;
			try {
				fSc = new Scanner(f);
				fSc.nextLine();
				if (fSc.nextLine().equalsIgnoreCase("Name          :" + name)) {
					if (fSc.nextLine().equalsIgnoreCase("Last Name     :" + lastName)) {
						match = true;
						matchCount++;
						System.out.println(matchCount + " Match(s) Found!");
					} else {
						files[index] = null;
					}
				} else {
					files[index] = null;
				}
			} catch (FileNotFoundException e) {
				System.out.println("There was an error in Searching :(");
			}
			index++;
		}
		if (!match) {
			System.out.println("No Match Found :(");
		} else {
			System.out.println("\nPress Enter to see result(s)...");
			keyboard.nextLine();
			for (String s : files) {
				if (s != null) {
					try {
						ShowFile.viewFile(s);
						System.out.println("\n****************************************\n");
					} catch (Exception e) {
						System.out.println("There was an error shoing match(s) :(");
					}
				}
			}
		}
	}
	
	public static void searchWithPrice(long min, long max, Scanner keyboard) {
		String[] files = loopDirectory.txtNames();
		boolean match = false;
		int matchCount = 0;
		int index = 0;
		for (String s : files) {
			if(s.contains("ZipCode")) {
				File f = new File(s);
				try {
					Scanner sc = new Scanner(f);
					sc.nextLine(); // Area
					sc.nextLine();
					long price = Long.parseLong(sc.nextLine().replace("Price:			",""));
					if(price >= min && price <= max) {
						matchCount++;
						match = true;
						System.out.println(matchCount + " Match(s) Found");
					} else {
						files[index] = null;
					}
					
					sc.close();
				} catch (FileNotFoundException e) {
					System.out.println("There was an error in searching :(");
					System.out.println("Please Try again later!");
				}
				
			} else {
				files[index] = null;
			}
			index++;
			
		}
		if (!match) {
			System.out.println("No Match Found :(\n");
		} else {
			System.out.print("Press ENTER to see resualt(s)...");
			keyboard.nextLine();
			
			for(String s : files) {
				if (s != null) {
					try {
						ShowFile.viewFile(s);
						System.out.println("\n****************************************\n");
					} catch (Exception e) {
						System.out.println("There was an error shoing match(s) :(");
					}
				}
			}
		}
	}
}
