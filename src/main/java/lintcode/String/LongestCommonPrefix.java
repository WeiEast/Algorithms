package lintcode.String;

/**
 * 给k个字符串，求出他们的最长公共前缀(LCP)

	您在真实的面试中是否遇到过这个题？ Yes
	样例
	在 "ABCD" "ABEF" 和 "ACEF" 中,  LCP 为 "A"
	
	在 "ABCDEFG", "ABCEFG", "ABCEFA" 中, LCP 为 "ABC"
	http://www.lintcode.com/zh-cn/problem/longest-common-prefix/
 *
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		return mySolution(strs);
	}

	private String mySolution(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String str = strs[0];
		int j = 0;
		int i = 1;
		int p = 0;
		for (; j < str.length(); j++) {
			for (i = 1; i < strs.length; i++) {
				String key = strs[i];
				if (j < key.length()) {
					if (str.charAt(j) == key.charAt(j)) {
						p = j + 1;
						continue;
					} else {
						i = strs.length;
						p = j;
						j = str.length();

					}
				} else {
					p = j;
					i = strs.length;
					j = str.length();
				}
			}
		}

		return str.substring(0, p);
	}

	public static void main(String[] args) {
		LongestCommonPrefix l = new LongestCommonPrefix();
		System.out.println(l.longestCommonPrefix(new String[] {  }));
	}

}
