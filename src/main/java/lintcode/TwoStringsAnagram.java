package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 写出一个函数 anagram(s, t) 去判断两个字符串是否是颠倒字母顺序构成的
 * 
 * 样例 给出 s="abcd"，t="dcab"，返回 true
 *
 */
public class TwoStringsAnagram {
	/**
	 * @param s:
	 *            The first string
	 * @param b:
	 *            The second string
	 * @return true or false
	 */
	public boolean anagram(String s, String t) {
		// write your code here
		return mySolution(s, t);
	}

	/**
	 * 使用O(n)空间 O(n)时间复杂度
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	private boolean mySolution(String s, String t) {
		if (s == null && t == null)
			return true;
		if (s != null && t != null) {
			if (s.length() != t.length())
				return false;
			// if (s.equals(t))
			// return false;
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < s.length(); i++) {
				char key = s.charAt(i);
				if (map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
			}
			for (int i = 0; i < t.length(); i++) {
				char key = t.charAt(i);
				if (map.containsKey(key)) {
					if (map.get(key) > 1)
						map.put(key, map.get(key) - 1);
					else {
						map.remove(key);
					}

				} else {
					return false;
				}
			}
			return map.isEmpty();
		} else {
			return false;
		}
	}
}
