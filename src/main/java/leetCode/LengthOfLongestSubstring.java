package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * For example, the longest substring without repeating letters for "abcabcbb"
 * is "abc", which the length is 3. For "bbbbb" the longest substring is "b",
 * with the length of 1.
 * 
 * 
 * 
 * 
 * 
 */
@SuppressWarnings(value = "all")
public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		return onlineBestSolution(s);
	}

	private int onlineBestSolution(String s) {
		if (s == null)
			return 0;
		boolean[] flag = new boolean[256];
		int result = 0;
		int start = 0;
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char current = arr[i];
			if (flag[current]) {
				result = Math.max(result, i - start);
				for (int k = start; k < i; k++) {
					if (arr[k] == current) {
						start = k + 1;
						break;
					}
					flag[arr[k]] = false;
				}
			} else {
				flag[current] = true;
			}
		}

		result = Math.max(arr.length - start, result);

		return result;
	}

	/**
	 * @param s
	 * @return
	 */
	private int mybestSolution(String s) {
		if (s == null)
			return 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int right = 0;
		int max = 0;
		char[] charArray = s.toCharArray();
		while (right < s.length()) {
			char c = charArray[right];
			if (!map.containsKey(c)) {
				map.put(c, right);
				right++;
			} else {
				max = Math.max(right - left, max);
				if (right < s.length() - map.size()
						&& s.substring(left, right).equals(
								s.substring(right, map.size() + right))) {
					left += right - left;
				} else {
					left++;
				}

				right = left;
				map.clear();
			}
		}
		return Math.max(max, map.size());

	}

	/**
	 * 问题是 下方char比较
	 * 
	 * @param s
	 * @return
	 */
	private int skipSolution(String s) {
		if (s == null)
			return 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int right = 0;
		int max = 0;
		char[] charArray = s.toCharArray();
		while (right < s.length()) {
			char c = charArray[right];
			if (!map.containsKey(c)) {
				map.put(c, right);
				right++;
			} else {
				max = Math.max(right - left, max);
				if (charArray[left] != charArray[right]) {
					left++;
				} else {
					for (int i = 0; i < map.size() && right + i < s.length(); i++) {
						if (charArray[left] == charArray[right + i]) {
							left++;
						} else {
							break;
						}
					}
				}
				right = left;
				map.clear();
			}

		}
		return Math.max(max, map.size());

	}

	/**
	 * 第一步,申请map空间 第二步,判断空间中是否有遍历到的元素如果没有就放入 第三步,如果map中有,则表示一个阶段结束 ,
	 * 将map的大小与result值比较 , 把较大的数字装入 , 同时i要还原到重复的元素位置 , 并且清空map
	 * 
	 * 时间复杂度 O(n3) 空间复杂度O(n) 依旧超时
	 * 
	 * 问题所在 , 解法不是线性时间 , 如abcabcbb 当遍历到第二个a由于后方abc b , 从索引1处继续 , 然而显然有重复的 , 应该跳过
	 * , 直接从索引6开始继续
	 * 
	 * @param s
	 * @return
	 */
	private int mapSolution(String s) {
		if (s == null)
			return 0;
		// 声明一个map key为字符 , value为 字符第一次出现的位置
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		// 记录结果
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				// 存在重复
				// 如果比结果更大 , set
				if (result < map.size()) {
					result = map.size();
				}
				// i归位
				i = map.get(c);
				// 清空map
				map.clear();
			} else {
				// 放入map
				map.put(c, i);
			}
		}
		if (map.size() > result)
			result = map.size();
		return result;

	}

	/**
	 * Time Exceeded
	 * 
	 * 基础算法 ,解题思路:
	 * 
	 * 双重循环 , 第一层遍历字符串所有字符 , 即以此字符作为开头 , 再次遍历 无重复计入result 如果有重复从下一个字母开始
	 * 
	 * O(n3) 时间复杂度 超过题目要求 问题原因 如用例 abcbca 当判断到b与索引1位置重复时候 , 根据算法会从第1索引位置继续 ,
	 * 显然重复操作了 , 改进方案 , 从重复的下一个位置开始判断
	 * 
	 * @param s
	 * @return
	 */
	private int getlengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;
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
