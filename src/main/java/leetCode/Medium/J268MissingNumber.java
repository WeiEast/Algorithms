package leetCode.Medium;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

	For example,
	Given nums = [0, 1, 3] return 2.
	
	Note:
	Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
	太简单
 *
 */
public class J268MissingNumber {
	public int missingNumber(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return (nums.length * (nums.length + 1) - sum * 2) / 2;
	}

	public static void main(String[] args) {
		J268MissingNumber j = new J268MissingNumber();
		System.out.println(j.missingNumber(new int[] { 0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12 }));
	}
}
