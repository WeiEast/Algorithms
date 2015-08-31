package leetCode;

/**
 * Given an integer, write a function to determine if it is a power of two.|
 * 
 * https://leetcode.com/problems/power-of-two/
 *
 */
public class PowerofTwo {
	public boolean isPowerOfTwo(int n) {
		return mySolution(n);
	}

	private boolean mySolution(int n) {
		if (n <= 0)
			return false;
		int b = (int) (Math.log(n) / Math.log(2));
		double pow = Math.pow(2, b);
		return pow == n;
	}

	public static void main(String[] args) {
		PowerofTwo p = new PowerofTwo();
		System.out.println(p.isPowerOfTwo(0));
	}
}
