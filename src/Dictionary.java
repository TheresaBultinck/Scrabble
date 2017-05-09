import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Class with all the different English words that exist. 
 * Constraint: File has to be in alfabetical order before reading in. 
 * (file moet alfabetisch reeds op voorhand gesorteerd zijn (constraint/voorwaarde opleggen))
 * @author Theresa Bultinck
 *
 */
public class Dictionary {
	
	private ArrayList<String> dictionary; 
	
	public Dictionary(String path){
		dictionary = new ArrayList<String>();
		fileReader(path);
	}

	/**
	 * Reads in the file with the english words. 
	 * @param path this is the name of the file you want to read in, for example: "english-words/words.txt"
	 */
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
	
	/**
	 * Checks if the word exists in dictionary
	 * @param beginWord beginning of the word
	 * @return true if the word exists and false if it doesn't exist in the list of English words
	 */
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
