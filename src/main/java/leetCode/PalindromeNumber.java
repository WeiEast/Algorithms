package leetCode;

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		return reverse(x, 0) == x;
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
