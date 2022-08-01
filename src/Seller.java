import java.util.Scanner;

public class Seller extends People {
	
	// Add property
		public void addProperty(Scanner keyboard) {
			Property newProperty = new Property();
			newProperty.createFile(keyboard);
		}
	
		// Remove Property
		public void rmProperty() {
			RemoveFile remover = new RemoveFile();
			remover.removeProperty();
		}
}
