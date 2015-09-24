package lintcode.China.section02;

/**
 * 查找斐波纳契数列中第 N 个数。

	所谓的斐波纳契数列是指：
	
	前2个数是 0 和 1 。
	第 i 个数是第 i-1 个数和第i-2 个数的和。
	斐波纳契数列的前10个数字是：
	
	0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
	
	您在真实的面试中是否遇到过这个题？ Yes
	样例
	给定 1，返回 0
	
	给定 2，返回 1
	
	给定 10，返回 34
 *
 */
public class Fibonacci {

	public int fibonacci(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n + 1];
	}

}
