package leetCode;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * 注意nums可能为null
 * 
 * 原理 非常符合异或定义 , 如果相同就归0
 */
public class SingleNumber {
	/**
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int x = 0;
		for (int i = 0; i < nums.length; i++) {
			x ^= nums[i];
		}
		return x;
	}

}
