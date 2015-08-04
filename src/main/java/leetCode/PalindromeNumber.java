package leetCode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * click to show spoilers.
 * 
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 */
@SuppressWarnings(value = "all")
public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		return x < 0 ? false : reverse(x, 0) == x;
	}

	/**
	 * 注意负数问题
	 * 
	 * @param x
	 * @param temp
	 *            额外空间
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

	/**
	 * 额外空间str
	 * 
	 * @param x
	 * @return
	 */
	private boolean extraspace(int x) {
		if (x < 0) {
			x = -x;
		}

		String str = String.valueOf(x);

		if (str.length() == 1) {
			return true;
		}

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}
