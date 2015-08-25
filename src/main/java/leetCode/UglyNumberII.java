package leetCode;


/**
 * 第n个uglyNumber
 *
 */
public class UglyNumberII {
	/**
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
		int i = 0;
		while (n > 0) {
			if (bestSolution(++i)) {
				n--;
			}
		}
		return i;

	}

	/**
	 * @param num
	 * @return
	 */
	private boolean bestSolution(int num) {
		if (num <= 0)
			return false;
		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 3 == 0) {
			num /= 3;
		}
		while (num % 5 == 0) {
			num /= 5;
		}
		return num == 1;
	}

}
