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
	public void permutations(char[] letters, int index){
		if(index == letters.length-1){
			System.out.println(letters);
		}
		for(int i = index; i <= letters.length-1; i++){
			char var1 = letters[index];
			char var2 = letters[i];
			letters[index] = var2;
			letters[i] = var1;
			if(dict.existInDictionary(new String(Arrays.copyOfRange(letters, 0, i)))){
				permutations(letters, index+1);
			}
			letters[index] = var1;
			letters[i] = var2;
		}
	}
	
}
