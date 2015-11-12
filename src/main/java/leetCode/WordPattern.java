package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

	Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
	
	Examples:
	pattern = "abba", str = "dog cat cat dog" should return true.
	pattern = "abba", str = "dog cat cat fish" should return false.
	pattern = "aaaa", str = "dog cat cat dog" should return false.
	pattern = "abba", str = "dog dog dog dog" should return false.
	Notes:
	You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
	
	Credits:
	Special thanks to @minglotus6 for adding this problem and creating all test cases.
	
	Subscribe to see which companies asked this question
 *
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		return mySolution(pattern, str);
	}

	private boolean mySolution(String pattern, String str) {
		Map<Character, String> map = new HashMap<Character, String>();
		Map<String, Character> map2 = new HashMap<String, Character>();
		String[] split = str.split(" ");
		if (pattern.length() != split.length)
			return false;
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c) && !split[i].equals(map.get(c))) {
				return false;
			}
			if (map2.containsKey(split[i]) && c != map2.get(split[i])) {
				return false;
			}
			if (!map.containsKey(c)) {
				map.put(c, split[i]);
				map2.put(split[i], c);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern("jquery", "jquery"));
	}
}
