package leetCode;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 *
 *用一个数组表示非负数字 
 */
public class PlusOne {

	/**
	 * 思路循环进位 , 如果首位进位的话 那么就进行数组扩容 首位置1
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
		int i = digits.length - 1;
		while (i >= 0) {
			if (digits[i] + 1 > 9) {
				digits[i] = 0;
				i--;
			} else {
				digits[i] += 1;
				return digits;
			}
		}
		int[] result = new int[digits.length + 1];
		System.arraycopy(digits, 0, result, 1, digits.length);
		result[0] = 1;
		return result;
	}
}
