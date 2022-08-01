import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Property {
	String address;
	int area;
	long price;
	int roomNumber;
	boolean parking = false;
	int builtYear;
	String zipCode;
	
	public void getInfo(Scanner keyboard) {
		System.out.print("Enter Adress -------------------: ");
		keyboard.nextLine();
		address = keyboard.nextLine();
		System.out.print("Enter Zip Code -----------------: ");
		zipCode = keyboard.nextLine();
		System.out.print("Enter Area ---------------------: ");
		area = keyboard.nextInt();
		keyboard.nextLine();
		System.out.print("Enter Price --------------------: ");
		price = keyboard.nextLong();
		keyboard.nextLine();
		System.out.print("Enter Number of Rooms ----------: ");
		roomNumber = keyboard.nextInt();
		keyboard.nextLine();
		System.out.print("Enter Built Year ---------------: ");
		builtYear = keyboard.nextInt();
		
		System.out.print("Does it have Parking spot?(y/n) : ");
		keyboard.nextLine();
		String park = keyboard.nextLine();
		if(park.equalsIgnoreCase("y") || park.equals("1"))
			parking = true;
	}
	 
	public void createFile(Scanner keyboard) {
		Property property = new Property();
		property.getInfo(keyboard);
		try {
			File f2 = new File("ZipCode"+ property.zipCode + ".txt");
			if ( f2.createNewFile() ) {
				FileWriter propertyWrite = new FileWriter("ZipCode"+ property.zipCode + ".txt");
				propertyWrite.write("Zip code ==> " + property.zipCode+ "\n" 
								  + "Area:			" + property.area +"\n"
								  + "Price:			" + property.price +"\n"
								  + "RoomNumber:		" + property.roomNumber +"\n"
								  + "BuiltYear:		" + property.builtYear+"\n"
								  + "Adress:			" + property.address +"\n"
								  + "Parking:		" + ((property.parking)?"Yes":"No"));
				
				propertyWrite.close();
				
				System.out.println("\nProperty has been Added :)");
				System.out.println("\nPress Enter to Continue...");
				keyboard.nextLine();
			
			} else {
				System.out.println("\nProperty already exists!");
				System.out.print("\nPress Enter to Continue...");
				keyboard.nextLine();
				keyboard.nextLine();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}