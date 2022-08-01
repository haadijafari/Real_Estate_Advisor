import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class loopDirectory {
	public static String[] showFiles() {
		File dir = new File(System.getProperty("user.dir"));
		String[] fileList = new String[dir.listFiles().length];
		int i = 0;
		for (File f : dir.listFiles()) {
			Pattern pattern = Pattern.compile(".txt$", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(f.getName());
			if (matcher.find() && !f.getName().equals("Admin.txt") && !f.getName().equals("Password.txt")) {
				fileList[i] = f.getName();
				i++;
			}
		}
		
		return fileList;
	}
	
	public static String[] txtNames() {
		int i = 0;
		for(String s : loopDirectory.showFiles()) {
			if(s != null) {
				i++;
			}
		}
		
		String[] names = new String[i];
		
		for(String s : loopDirectory.showFiles()) {
			if(s != null) {
				names[i-1] = s;
				i--;
			}
		}
		return names;
	}
}
