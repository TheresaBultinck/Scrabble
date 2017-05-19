import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
	
	Dictionary dict;
	
	public Permutation(Dictionary d){
		dict = d;
	}
	
	/**
	 * Calculates the permutations and only keeps calculating the permutations if the words are valid. 
	 * @param letters array of letters to calculate permutations 
	 * @param index
	 */
	public ArrayList<String> permutations(char[] letters, int index){
		ArrayList<String> results = new ArrayList<String>();
		for(int i = index; i <= letters.length-1; i++){
			char var1 = letters[index];
			char var2 = letters[i];
			letters[index] = var2;
			letters[i] = var1;
			String current = new String(Arrays.copyOfRange(letters, 0, index+1));
			if(dict.existInDictionary(current)){
				if(dict.isWord(current)){
					results.add(current);
				}
				results.addAll(permutations(letters, index+1));
			}
			letters[index] = var1;
			letters[i] = var2;
		}
		return results; 
	}
	
	
	public String findBestScrabbleWord(String letters){
		ArrayList<String> list = permutations(letters.toCharArray(), 0);
		String largest = list.get(0);
		for(int i = 1; i<= list.size()-1; i++){
			if(largest.length() < list.get(i).length()){
				largest = list.get(i);
			}
		}
		return largest;
	}
	
}
