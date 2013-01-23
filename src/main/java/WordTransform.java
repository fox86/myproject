import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author kchung
 */
public class WordTransform {


	public static HashSet<String> setupDictionary(String[] words) {
		HashSet<String> hash = new HashSet<String>();
		for (String word : words){
			hash.add(word.toUpperCase());
		}
		return hash;
	}

	public static void main(String[] args) {
		String[] words = {
			"maps", "tan", "tree", "apple", "cans", "help", "aped", "free", "apes", "flat", "trap", "fret",
			"trip", "trie", "frat", "fril"};
		Set<String> dict = setupDictionary(words);
		Map<String, String> btMap = transform("tree", "flat", dict);
		String source = "FLAT";
		while(source != null){
			System.out.println(source);
			source = btMap.get(source);
		}
	}

	public static Map<String, String> transform(String w, String t, Set<String> dict) {
		w = w.toUpperCase();
		t = t.toUpperCase();

		Map<String, String> btMap = new HashMap<String, String>();
		Set<String> used = new HashSet<String>();

		Queue<String> bfsQ = new LinkedList<String>();
		bfsQ.add(w);
		used.add(w);

		while (!bfsQ.isEmpty()){
			String curr = bfsQ.poll();
			for (String e : getOneEdit(curr, dict, used)){

				if (e.equals(t)){
					btMap.put(e, curr);
					return btMap;
				} else{
					btMap.put(e, curr);
					bfsQ.add(e);
				}
			}
		}
		return btMap;
	}

	public static Collection<String> getOneEdit(String w, Set<String> dict, Set<String> used) {
		Collection<String> list = new HashSet<String>();
		for (int i = 0; i < w.length(); i++){
			char[] word = w.toCharArray();
			char charAt = w.charAt(i);
			for (char c = 'A'; c <= 'Z'; c++){
				if (c != charAt){
					word[i] = c;
					String oneEdit = String.copyValueOf(word);
					if (dict.contains(oneEdit) && !used.contains(oneEdit)){
						list.add(oneEdit);
						used.add(oneEdit);
					}
				}
			}
		}
		return list;
	}
}
