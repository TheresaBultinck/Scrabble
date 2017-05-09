import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args){
		Dictionary dict = new Dictionary("english-words/words.txt");
		Permutation perm = new Permutation(dict);
		perm.permutations("ABC".toCharArray(), 0);
		Pattern p = Pattern.compile("a"+ ".*"); //beginnen met a, alles wat er achterkomt is ok
		System.out.println(p.matcher("a").matches());
	}
}
