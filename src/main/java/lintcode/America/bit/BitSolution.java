package lintcode.America.bit;

import lombok.extern.log4j.Log4j;

@Log4j
public class BitSolution {
	/**
	 * a -> b 需要改变几个bit位
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int bitSwapRequired(int a, int b) {
		int i = 0;
		int j = 0;
		int k = 1;
		int res = 0;
		for (int m = 0; m < 32; m++) {

			i = a & k;
			j = b & k;
			if (i != j) {
				res++;
			}
			k <<= 1;
		}

		return res;

	}

	/**
	 * O(1)的时间 计算n是否为2次幂
	 * @param n
	 * @return
	 */
	public boolean checkPowerOf2(int n) {
		if (n <= 0)
			return false;
		return (n & n - 1) == 0;
	}

	/**
	 * 机器人从 左上角00 位置向 m n 位置前进 , 每次只能进行 向前或者向下运动 , 问有多少种情况到 (m,n)
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (i == 0) {
					dp[i][j] = dp[i][j - 1];
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];

	}

	/**
	 * 计算末尾0的个数
	 *	
	 * @param n
	 * @return
	 */
	public long trailingZeros(long n) {
		long res = 0;
		while (n != 0) {
			res += n /= 5;
		}
		return res;
	}

	public int updateBits(int n, int m, int i, int j) {
		long rightMask = ~0 >> i;
		rightMask = ~(rightMask << i);// 00000xxx
		long leftMask = ~0 >> (j + 1);
		leftMask = leftMask << (j + 1);// xxxxx00000000
		long mask = leftMask | rightMask;// xxx00000xxx
		n = (int) (n & mask);
		n = (int) (n | (m << i));
		return n;
	}

	public int numTrees(int n) {
		int[] count = new int[n + 1];
		count[0] = 1;
		if (n == 0)
			return count[n];
		count[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				count[i] += count[j] * count[i - j - 1];
			}

		}
		return count[n];
	}

	public static void main(String[] args) {
		BitSolution b = new BitSolution();
		// log.info(bitSwapRequired(1, -1));
		// log.info(b.checkPowerOf2(0));
		// log.info(b.uniquePaths(2, 62));
		// log.info(b.trailingZeros(105));

	}
}
