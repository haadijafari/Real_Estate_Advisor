import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Buyer extends People {
	// Search ability
	public void search(Scanner keyboard) {
		// Calls the static method in Search class
		Search.propertiesSearchMenu.menu(keyboard);

		System.out.println("Press ENTER to go back...");
		keyboard.nextLine();

		// Buyer menu in MainMenu class
		MainMenu.buyerChoice(keyboard);
	}

	// Buy ability
	public void buy(Scanner keyboard) {
		// text that should be printed before choosing which property to buy
		System.out.println(
				"(WARNING: if you dont have a property's Zip Code,\n" + "You have to find one in SEARCH option!)\n");
		System.out.println("Please enter Properties Zip Code to buy it ==>\n");
		System.out.println("Your Zip Code: ");

		// we have an ENTER existing because of nextInt()
		keyboard.nextLine();
		// store property's zip code in "zip"
		String zip = keyboard.nextLine();

		RemoveFile.removeFile("ZipCode" + zip + ".txt");
		
		System.out.println("\nPress Enter to go back...");
		keyboard.nextLine();
	}
	
	public void getPropList(Scanner keyboard) {
		String[] files = loopDirectory.txtNames();
		
		for(String s : files) {
			if(s.contains("ZipCode")) {
				File f = new File(s);
				try {
					Scanner sc = new Scanner(f);
					while(sc.hasNextLine()) {
						System.out.println(sc.nextLine());
					}
					System.out.println("\n**********************************\n");
					sc.close();
				} catch (FileNotFoundException e) {
					System.out.println("There was an error reading files :(");
					System.out.println("Please try again later!");
					MainMenu.mainMenu(keyboard);
				}
				
			}
		}
		System.out.println("Press ENTER to Continue...");
		keyboard.nextLine();
		keyboard.nextLine();
	}
}
