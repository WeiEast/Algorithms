package leetCode.Medium;

import java.util.Arrays;
import java.util.List;

public class Solution {
	/**
	 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	
		The same repeated number may be chosen from C unlimited number of times.
		
		Note:
		All numbers (including target) will be positive integers.
		Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
		The solution set must not contain duplicate combinations.
		For example, given candidate set 2,3,6,7 and target 7, 
		A solution set is: 
		[7] 
		[2, 2, 3] 
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		return null;
	}

	/**
	 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
	
		For example:
		
		Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
		
		Note:
		The order of the result is not important. So in the above example, [5, 3] is also correct.
		Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
	 * 
	 * @param nums
	 * @return
	 */
	public int[] singleNumber(int[] nums) {
		int[] rs = new int[2];
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1;) {
			if (nums[i] != nums[i + 1]) {
				rs[count] = nums[i];
				count++;
				i = i + 1;
			} else {
				i = i + 2;
			}
		}
		if (count == 1) {
			rs[1] = nums[nums.length - 1];
		}
		return rs;
	}

	/**
	 * 
	 * reverseWords Solve
	 * 
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		if ("".equals(s)) {
			return s;
		}
		String[] strs = s.split(" ");
		StringBuffer sbr = new StringBuffer();
		for (int i = strs.length - 1; i > 0; i--) {
			if (!"".equals(strs[i])) {
				sbr.append(strs[i]);
				sbr.append(" ");
			}
		}
		if (strs != null && strs.length > 0 && !"".equals(strs[0]))
			sbr.append(strs[0]);
		String str = sbr.toString();
		if ("".equals(str)) {
			return str;
		}
		if (strs.length == 1) {
			return str;
		}
		if (str.endsWith(" ")) {
			return str.substring(0, str.length() - 1);
		}
		return str.substring(0, str.length());
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		//		s.singleNumber(new int[] { 1, 2, 1, 3, 2, 5 });
		System.out.println(s.reverseWords(" 1"));
	}

}
