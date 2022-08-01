import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class RealEstateAdvisor extends People {

	// Create new Admin
	@Override
	public void createFile(Scanner keyboard) {
		// the data will be saved in "Admin.txt"
		File f1 = new File("Admin.txt");
		// For files we should use Try/Catch to avoid malfunction
		try {
			if (f1.createNewFile()) { // it checks if the Admin.txt already exist or not
									  // if not it creates on and the program will continue
				
				// to write in a text file we should create a FileWriter Object
				FileWriter myWriter = new FileWriter("Admin.txt");
				/* it calls "getInfo" method to get information from user*/
				getInfo(keyboard);
				
				// uses gotten info from "getInfo" method
				myWriter.write("ID: ADMIN :D" + "\n" + "Name          :" + name + "\n"
						+ "Last Name     :" + lastName + "\n" + "Address       :" + address + "\n"
						+ "Phone Number  :" + phoneNumber);
				// for more efficient program "mywriter" should be closed
				myWriter.close();
				
				// as you know admin should have a password :)
				Password.setPass(keyboard);
				
				System.out.println("\nAdmin has been Added :)");
				System.out.println("\nPress Enter to Continue...");
				keyboard.nextLine();

			}
			// if there is an error in Try part, Catch will be executed
		} catch (Exception e) {
			// it shows the error
			System.out.println(e);
		}
	}

	///////////// RemoveFile object:
	RemoveFile remover = new RemoveFile();

	// Remove person
	public void rmPerson() {
		remover.removePerson();
	}

	// Remove Property
	public void rmProperty() {
		remover.removeProperty();
	}

	// Add property
	public void addProperty(Scanner keyboard) {
		Property newProperty = new Property();
		newProperty.createFile(keyboard);
	}

	// Search

	// Add Seller
	public void addSeller(Scanner keyboard) {
		Seller newSeller = new Seller();
		newSeller.createFile(keyboard);
	}

	// Add Buyer
	public void addBuyer(Scanner keyboard) {
		Buyer newBuyer = new Buyer();
		newBuyer.createFile(keyboard);
	}

	// Change Pass
	public void pass(Scanner keyboard) {
		Password.setPass(keyboard);
	}
}