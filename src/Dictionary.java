import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

/**
 * Class with all the different English words that exist. 
 * Constraint: File has to be in alfabetical order before reading in. 
 * (file moet alfabetisch reeds op voorhand gesorteerd zijn (constraint/voorwaarde opleggen))
 * @author Theresa Bultinck
 *
 */
public class Dictionary {
	
	private String[] dictionary; 
	private Comparator<String> matchingComparator = new Comparator<String>(){

		//Compare if beginning is equal to each other
		@Override
		public int compare(String dictionaryItem, String beginWord) {
			if (dictionaryItem.startsWith(beginWord))
				return 0;
			return dictionaryItem.compareTo(beginWord);
		}
	};
	
	public Dictionary(String path){
		dictionary = fileReader(path);
		Arrays.sort(dictionary);
	}

	/**
	 * Reads in the file with the english words. 
	 * @param path this is the name of the file you want to read in, for example: "english-words/words.txt"
	 */
	private String[] fileReader(String path){
		try {
			FileReader fr = new FileReader(path);
			LineNumberReader ln = new LineNumberReader(fr); //ieder lijn inlezen
			ln.skip(Long.MAX_VALUE); //skippen tot het einde
			int lines = ln.getLineNumber(); 
			String[] result = new String[lines];
			fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
		    for (int i = 0; i < lines; i++) {
		        result[i] = br.readLine();
		    }
		    return result; 
		} catch (IOException e) {
				e.printStackTrace();
		} 
		return new String[]{};
	}
	
	/**
	 * Checks if the word exists in dictionary
	 * @param beginWord beginning of the word
	 * @return true if the word exists and false if it doesn't exist in the list of English words
	 */
	public boolean existInDictionary(String beginWord){
		return checkPointer(Arrays.binarySearch(dictionary, beginWord, matchingComparator));
	}
	
	/**
	 * Search in O(log n) time if the word exists.
	 * @param word
	 * @return true if it exists and false otherwise
	 */
	public boolean isWord(String word){
		return checkPointer(Arrays.binarySearch(dictionary, word));
	}
	
	private boolean checkPointer(int pointer){
		if(pointer < 0){
			return false; 
		} else return true; 
	}
}
