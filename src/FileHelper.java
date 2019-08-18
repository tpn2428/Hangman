import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHelper {
	public static ArrayList<String> getDictionary() {
		File file = new File("src/wordlist.txt");
		ArrayList<String> dict = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String line; 
			while ((line = br.readLine()) != null) {
			    dict.add(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return dict;
	}
}
