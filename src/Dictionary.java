import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

//file moet alfabetisch reeds op voorhand gesorteerd zijn (constraint/voorwaarde opleggen)
public class Dictionary {
	
	private ArrayList<String> dictionary; 
	
	public Dictionary(String path){
		dictionary = new ArrayList<String>();
		fileReader(path);
	}

	private void fileReader(String path){
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
		    while (line != null) {
		        dictionary.add(line);
		        line = br.readLine();
		    }
		} catch (IOException e) {
				e.printStackTrace();
		} 
	}
	
	//true if beginWord exist, false if doesn't exist
	public boolean existInDictionary(String beginWord){
		Pattern p = Pattern.compile(beginWord + ".*");
		  for (String s : dictionary) {
		    if (p.matcher(s).matches()) {
		      return true;
		    }
		  }
		  return false;
	}
}
