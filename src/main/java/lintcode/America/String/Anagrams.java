package lintcode.America.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给出一个字符串数组S，找到其中所有的乱序字符串(Anagram)。如果一个字符串是乱序字符串，那么他存在一个字母集合相同，但顺序不同的字符串也在S中。
 * 
 * 样例 对于字符串数组 ["lint","intl","inlt","code"]
 * 
 * 返回 ["lint","inlt","intl"]
 *
 */
public class Anagrams {
	/**
	 * @param strs:
	 *            A list of strings
	 * @return: A list of strings
	 */
	public List<String> anagrams(String[] strs) {
		// write your code here
		return mySolution(strs);

	}

	private List<String> mySolution(String[] strs) {
		List<String> result = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < strs.length; i++) {
			char[] chararray = strs[i].toCharArray();
			Arrays.sort(chararray);
			String str = Arrays.toString(chararray);
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}

		}
		for (int i = 0; i < strs.length; i++) {
			char[] chararray = strs[i].toCharArray();
			Arrays.sort(chararray);
			String str = Arrays.toString(chararray);
			if (map.get(str) > 1) {
				result.add(strs[i]);
			}
		}
		return result;
	}
}
