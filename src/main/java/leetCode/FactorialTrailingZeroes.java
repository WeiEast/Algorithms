package leetCode;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

https://leetcode.com/problems/factorial-trailing-zeroes/




 *
 */
public class FactorialTrailingZeroes {

	public int trailingZeroes(int n) {
		if (n < 5)
			return 0;
		int result = 0;
		while (n != 0) {
			result += n / 5;
			n /= 5;
		}
		return result;
	}

}
