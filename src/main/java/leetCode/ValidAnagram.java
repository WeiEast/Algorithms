package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * 假设string中只有小写字母
 * 
 */
@SuppressWarnings(value = "all")
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		return bestSolution(s, t);

	}

	private boolean bestSolution(String s, String t) {
		if (s == null && t == null)
			return true;
		if (s != null && t != null && s.length() == t.length()) {
			char[] schar = s.toCharArray();
			char[] tchar = t.toCharArray();
			Arrays.sort(schar);
			Arrays.sort(tchar);
			for (int i = 0; i < tchar.length; i++) {
				if (tchar[i] != schar[i])
					return false;
			}
			return true;
		} else {
			return false;
		}
	}

	private boolean normalSolution(String s, String t) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		if (s == null && t == null)
			return true;
		if (s != null && t != null) {
			if (s.length() != t.length()) {
				return false;
			} else {
				for (int i = 0; i < s.length(); i++) {
					if (map.containsKey(s.charAt(i))) {
						map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
					} else {
						map.put(s.charAt(i), 1);

					}

				}
				for (int i = 0; i < t.length(); i++) {
					if (map.containsKey(t.charAt(i))
							&& map.get(t.charAt(i)) != null
							&& map.get(t.charAt(i)) > 1) {
						map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
					} else if (map.containsKey(t.charAt(i))) {
						map.remove(t.charAt(i));
					} else {
						return false;
					}
				}
			}
		} else {
			return false;
		}
		return map.isEmpty();
	}
}
