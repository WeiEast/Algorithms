package leetCode;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

https://leetcode.com/problems/factorial-trailing-zeroes/

 *
 */
public class FactorialTrailingZeroesTest {

	private static Long factorial(int n) {
		if (n == 1) {
			return 1L;
		}
		return factorial(n - 1) * n;
	}

	public static void main(String[] args) {
		FactorialTrailingZeroes f = new FactorialTrailingZeroes();
		Long factorial = factorial(25);
		System.out.println(factorial);
		System.out.println(f.trailingZeroes(25));
	}

}
