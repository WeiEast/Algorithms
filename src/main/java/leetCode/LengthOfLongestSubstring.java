package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 *
 *
 *
 *
 */
public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		return getlengthOfLongestSubstring(s);
	}

	/**
	 * Time Exceeded
	 * @param s
	 * @return
	 */
	private int getlengthOfLongestSubstring(String s) {

		Set<Character> hashSet = new HashSet<Character>();
		int result = 0;

		for (int i = 0; i < s.length(); i++) {

			for (int j = i; j < s.length(); j++) {
				char c = s.charAt(j);
				if (!hashSet.contains(c)) {
					hashSet.add(c);
				} else {
					if (hashSet.size() > result) {
						result = hashSet.size();
					}
					hashSet.clear();
					break;
				}
			}
		}
		return result;
	}
}
