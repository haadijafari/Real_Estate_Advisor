import java.io.File;
import java.util.Scanner;

public class ShowFile {
	public static void viewFile(String fullFileName) throws Exception {
		File file = new File(fullFileName);
		Scanner sc = new Scanner(file);

		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}

		sc.close();
	}
}
