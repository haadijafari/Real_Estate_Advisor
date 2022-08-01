import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Password {
	// where the pass will be saved
	static String password;

	// this method will save the password
	public static void setPass(Scanner keyboard) {
		try { // in case there will be errors we use try
				// define a file object where we will save password
			File f1 = new File("Password.txt");
			if (f1.createNewFile()) { // see if the file has already exists or not ( if not => )
				// write the password in the new created file
				FileWriter myWriter = new FileWriter("Password.txt");
				// Password qualification procedure
				getPassword(keyboard);
				myWriter.write(password);
				// then close it to avoid errors
				myWriter.close();

				System.out.println("\nPassword successfully saved :)");
				System.out.println("\nPress Enter to Continue...");
				keyboard.nextLine();
				keyboard.nextLine();

			} else { // if the Password.txt is there then we have to ask for old pass first
				// define a file object where we will save password
				File file = new File("Password.txt");
				// to read the password from the file for further compare
				Scanner fileRead = new Scanner(file);
				String correct = fileRead.next();
				fileRead.close();

				// we store the old password which the user types here in oldPass
				String oldPass;
				for (int i = 0; i < 3; i++) { // a loop for max number of entering wrong pass word
					System.out.print("Please Enter old password: ");
					// get oldPass from user
					oldPass = keyboard.next();
					// compare oldPass with real old password
					if (oldPass.equals(correct)) { // if its a pare:
						// Password qualification procedure
						getPassword(keyboard);
						FileWriter myWriter = new FileWriter("Password.txt");
						myWriter.write(password);
						// then close it to avoid errors
						myWriter.close();
						// it was a match for the old pass so we end the loop here
						break;
					}
					// this line is printed every time user enters wrong oldPass
					System.out.println("Wrong password!\nWe were unable to change password :(");
					System.out.println("------------------------------------\n\n");
					if (i == 2) {
						System.out.println("3 incorrect attempts!\nPlease try again some other time\n\n");
					}
				}

				System.out.println("Press Enter to Continue...");
				keyboard.nextLine();
				keyboard.nextLine();
			}
		} catch (Exception e) { // if there was any error in the procedure above:
			// print error
			System.out.println(e);
		}
	}

	// this method will get a qualified password from user
	public static void getPassword(Scanner keyboard) {
		// it isn't a qualified password until it passes tests below:
		boolean valid = false;

		do { // start a loop to get new password every time it is not qualified
				// Asks user to enter password
			System.out.print("Please Enter your password and then press ENTER: ");
			password = keyboard.next();

			// Checks to see if password is at least 8 characters.
			if (password.length() < 8) {
				System.out.println("Password must have at least 8 Characters");
				continue; // skip to next iteration
			}

			// Checks each character to see if it is acceptable.
			for (int i = 0; i < password.length(); i++) {
				char c = password.charAt(i);

				if (('a' <= c && c <= 'z') // Checks if it is a lower case letter
						|| ('A' <= c && c <= 'Z') // Checks if it is an upper case letter
						|| ('0' <= c && c <= '9') // Checks to see if it is a digit
				) {

					valid = true;
				} else {
					// tells the user that only letters & digits are allowed
					System.out.println("Only Letter & Digits are acceptable.");
					break;
				}

			}
		} while (!valid); // verify if the password is valid, if not repeat the process

		/** CONFIRM PASSWORD **/
		System.out.print("Please re-Enter your password: ");
		String temp = keyboard.next();
		if (temp.equals(password)) {
			// if the password is valid, tell the user it's accepted
			System.out.println("\n\nPassword Accepted :D\n\n");
		} else {
			System.out.println("\n\nPassword does not match!!!\nPlease try again :(");
			System.out.println("-------------------------\n\n");
			getPassword(keyboard);
		}
	}

	public static void checkPass(Scanner keyboard) {
		File f1 = new File("Password.txt");

		String passTemp;
		try {
			if (!f1.createNewFile()) { // see if the file has already exists or not ( if yes => )
				Scanner fileRead = new Scanner(f1);
				String correct = fileRead.next();
				fileRead.close();

				System.out.print("Please Enter your password: ");
				passTemp = keyboard.next();
				// we store the old password which the user types here in oldPass
				for (int i = 0; i < 2; i++) { // a loop for max number of entering wrong pass word
					// compare with real old password
					if (passTemp.equals(correct)) { // if its a pare:
						// it was a match for the pass so we end the loop here
						// and the program will continue running
						break;
					}
					System.out.println("Wrong Password, Try again: ");
					passTemp = keyboard.next();
				}

				if (!passTemp.equals(correct)) {
					System.out.println("\n\n3 incorrect attempts!\nPlease try again some other time\n\n");
					CodeExit.out();
				}
			} else {
				f1.delete();
			}
		} catch (Exception e) {
			System.out.println("There was an error in program :(");
			CodeExit.out();
		}
	}
}