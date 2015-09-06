package lintcode;

import java.util.ArrayList;

/**
 * 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
 * 
 * 样例 给出[-3, 1, 2, -3, 4]，返回[0, 2] 或者 [1, 3].
 *
 */
public class SubarraySum {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A list of integers includes the index of the first number and
	 *          the index of the last number
	 */
	public ArrayList<Integer> subarraySum(int[] nums) {
		// write your code here
		return mySolution(nums);
	}

	/**
	 * O(n^2)
	 * 
	 * @param nums
	 * @return
	 */
	private ArrayList<Integer> mySolution(int[] nums) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		std: for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == 0) {
					list.add(i);
					list.add(j);
					break std;
				}

			}
			sum = 0;
		}
		return list;
	}

	
}
