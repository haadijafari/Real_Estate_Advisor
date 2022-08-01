import java.io.File;
import java.util.Scanner;

public class RemoveFile {
	
	Scanner keyboard = new Scanner(System.in);
	
	// Remove method
	public static void removeFile(String fileName) {
		
		File file = new File(fileName);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("\nDone :)");
			}
		} else {
			System.out.println("\nThere was no such file :( ");
		}
	}
	
	// Remove Property
	public void removeProperty() {
		System.out.println("Please Enter Zip Code to Remove the Property:");
		String id = keyboard.nextLine();
		RemoveFile.removeFile("ZipCode" + id + ".txt");
	}
	
	// Remove Person
	public void removePerson() {
		System.out.println("Please Enter the person's ID you want to remove:");
		String id = keyboard.nextLine();
		RemoveFile.removeFile("ID" + id + ".txt");
	}
}