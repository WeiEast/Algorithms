package leetCode;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * click to show spoilers.
 * 
 * Have you thought about this? Here are some good questions to ask before
 * coding. Bonus points for you if you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * 
 * For the purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 * 
 * Update (2014-11-10): Test cases had been added to test the overflow behavior.
 * 
 */
public class ReverseInteger {
	public int reverse(int x) {
		return x < 0 ? -reverse(-x, 0) : reverse(x, 0);
	}

	/**
	 * 有两种情况可能溢出 , 1 temp*10溢出 2 temp*10+x%10溢出
	 * 
	 * @param x
	 * @param temp
	 * @return
	 */
	private int reverse(int x, int temp) {
		if (x == 0) {
			return temp;
		}
		if (Integer.MAX_VALUE / 10 < temp
				|| Integer.MAX_VALUE - temp * 10 < x % 10) {
			temp = 0;
			return 0;
		}
		temp = temp * 10 + x % 10;
		x = x / 10;
		return reverse(x, temp);

	}
}
