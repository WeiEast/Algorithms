package leetCode;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Credits: Special thanks to @ts for adding this problem and creating all test
 * cases.
 * 
 * 
 * 
 * 解题思路 , 题目要求 , 主元素出现次数超过一半 , 可以利用排序 , 如果主元素出现超过一半 , 那么排序后中位数一定为主元素
 * 
 */
public class MajorityElement {
	/**
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];

	}

}
