package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * 
 * https://leetcode.com/problems/two-sum/
 * 
 * 
 * 给定一个数组 nums , 找到两个数加和等于目标数 target
 * 
 * 方法的返回值为 给定数组中的索引位置 , 注意, 索引从1开始
 * 
 * 每个输入值都有一个唯一解
 * 
 * 
 * 解法思路: 申请一个hashmap 保存key : 数组中值 , value为索引数+1 (索引从1开始)
 * 
 * 遍历数组 如果找到一个数字与target-这个数相同 此时map中的value 与 当前遍历到的索引值+1 即为题目所要结果
 * 
 * 返回这个数组
 * 
 * 算法复杂度: 时间复杂度: O(n) 循环一遍数组 空间复杂度: O(n) 申请临时存储map
 * 
 * 
 * 
 * 
 * 
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		return findByhash(nums, target);

	}

	private int[] findByhash(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] arr = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(target - nums[i])) {
				map.put(nums[i], i + 1);
			} else {
				arr[0] = map.get(target - nums[i]);
				arr[1] = i + 1;
				break;
			}
		}
		return arr;

	}
}
