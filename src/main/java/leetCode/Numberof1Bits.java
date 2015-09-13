package leetCode;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

	For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
	https://leetcode.com/problems/number-of-1-bits/
 *
 */
public class Numberof1Bits {
	public int hammingWeight(int n) {
		return bestSolution(n);
	}

	private int bestSolution(int n) {
		int result = 0;
		while (n != 0) {
			n = n & (n - 1);
			result++;
		}
		return result;
	}

	private int uglySolution(int n) {
		int result = 0;
		while (n != 0) {
			int k = (int) (Math.log(n) / Math.log(2));
			n = (int) (n - Math.pow(2, k));
			result++;
		}
		return result;
	}

	public static void main(String[] args) {
		Numberof1Bits n = new Numberof1Bits();
		// System.out.println(Math.pow(2, 32) - 1);
		System.out.println(n.hammingWeight(1));
	}
}
