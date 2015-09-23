package lintcode.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母
 * 
 * 样例 给出 A = "ABCD" B = "ACD"，返回 true
 * 
 * 给出 A = "ABCD" B = "AABC"， 返回 false
 *
 */
public class CompareStrings {
	/**
	 * @param A
	 *            : A string includes Upper Case letters
	 * @param B
	 *            : A string includes Upper Case letter
	 * @return : if string A contains all of the characters in B return true
	 *         else return false
	 */
	public boolean compareStrings(String A, String B) {
		// write your code here
		return mySolution(A, B);

	}

	private boolean mySolution(String A, String B) {
		if (A == null && B == null)
			return true;
		if (A != null && B != null) {
			if (A.length() < B.length())
				return false;
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < A.length(); i++) {
				char key = A.charAt(i);
				if (map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
			}
			for (int i = 0; i < B.length(); i++) {
				char key = B.charAt(i);
				if (map.containsKey(key)) {
					if (map.get(key) > 1) {
						map.put(key, map.get(key) - 1);
					} else {
						map.remove(key);
					}
				} else {
					return false;
				}
			}
			return true;
		} else if (B == null)
			return true;
		else
			return false;
	}
}
