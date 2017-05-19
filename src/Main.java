import java.util.regex.Pattern;

/**
 * Main method of the Scrabble Anagram generator
 * @author Theresa Bultinck
 *
 */
public class Main {

	public static void main(String[] args){
		Dictionary dict = new Dictionary("english-words/words2.txt");
		Permutation perm = new Permutation(dict);
		//System.out.println(perm.permutations("abcdefghi".toCharArray(), 0));
		System.out.println(perm.findBestScrabbleWord("abcdefghi"));
	}
}
