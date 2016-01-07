package leetCode.Easy;

public class NumArray {

	final int[] dp;

	/**
	 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
	
		Example:
		Given nums = [-2, 0, 3, -5, 2, -1]
		
		sumRange(0, 2) -> 1
		sumRange(2, 5) -> -1
		sumRange(0, 5) -> -3
		Note:
		You may assume that the array does not change.
		There are many calls to sumRange function.
		
		本题考察点 : 动态规划
	 * @param nums
	 */
	public NumArray(int[] nums) {
		dp = new int[nums.length + 1];
		dp[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			dp[i + 1] = dp[i] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		if (j + 1 >= dp.length) {
			j = dp.length - 1;
		}
		return dp[j + 1] - dp[i];
	}

	public static void main(String[] args) {
		int[] nums = new int[] { -2, 0, 3, -5, 2, -1 };
		NumArray n = new NumArray(nums);
		System.out.println(n.sumRange(0, 2));
		System.out.println(n.sumRange(2, 5));

	}
}
