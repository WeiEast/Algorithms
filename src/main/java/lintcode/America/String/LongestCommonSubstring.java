package lintcode.America.String;

/**
 * 给出两个字符串，找到最长公共子串，并返回其长度。



	您在真实的面试中是否遇到过这个题？ Yes
	样例
	给出A=“ABCD”，B=“CBCE”，返回 2
	
	注意
	子串的字符应该连续的出现在原字符串中，这与子序列有所不同。
	
	http://www.lintcode.com/zh-cn/problem/longest-common-substring/
 *
 */
public class LongestCommonSubstring {
	public int longestCommonSubstring(String A, String B) {
		if (A == null || B == null)
			return 0;
		if (A.length() < B.length()) {
			String C = B;
			B = A;
			A = C;
		}
		int[][] dp = new int[A.length() + 1][B.length() + 1];
		dp[0][0] = 0;
		int max = 0;
		for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < B.length(); j++) {
				if (A.charAt(i) == B.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
					max = Math.max(dp[i + 1][j + 1], max);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestCommonSubstring l = new LongestCommonSubstring();
		System.out.println(l.longestCommonSubstring("ABCD", "CBCE"));
	}
}
