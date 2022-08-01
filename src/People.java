import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class People {
	String name;
	String lastName;
	String nationalId;
	String address;
	String phoneNumber;

	// Get person's info
	public void getInfo(Scanner keyboard) {
		System.out.print("Enter Name ----------: ");
		keyboard.nextLine();
		name = keyboard.nextLine();
		System.out.print("Enter Last Name -----: ");
		lastName = keyboard.nextLine();
		System.out.print("Enter National ID ---: ");
		nationalId = keyboard.nextLine();
		System.out.print("Enter address -------: ");
		address = keyboard.nextLine();
		System.out.print("Enter Phone Number --: ");
		phoneNumber = keyboard.nextLine();
	}

	// Add a person
	public void createFile(Scanner keyboard) {
		People people = new People();
		people.getInfo(keyboard);
		try {
			File f1 = new File("ID" + people.nationalId + ".txt");
			if (f1.createNewFile()) {
				FileWriter myWriter = new FileWriter("ID" + people.nationalId + ".txt");
				myWriter.write("National ID ==> " + people.nationalId + "\n" + "Name          :" + people.name + "\n"
						+ "Last Name     :" + people.lastName + "\n" + "Address       :" + people.address + "\n"
						+ "Phone Number  :" + people.phoneNumber);
				myWriter.close();

				System.out.println("\nPerson has been Added :)");
				System.out.print("\nPress Enter to Continue...");
				keyboard.nextLine();

			} else {
				System.out.println("\nPerson already exists!");
				System.out.print("\nPress Enter to Continue...");
				keyboard.nextLine();

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}