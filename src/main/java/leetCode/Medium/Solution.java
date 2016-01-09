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

	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	
		If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
		
		Subscribe to see which companies asked this question
		
		股票找到最大利润算法 : 要求 只能进行一次交易 设计一个算法 得到最大利益 prices 数组中表示第 i 天股票的价格为 prices[i]
		
		解题思路 申请 2N 空间 一个记录利润最大 一个记录价格最低值 , 一次遍历时间复杂度 O(n)
		
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int[] dp = new int[prices.length];
		dp[0] = 0;
		int[] min = new int[prices.length];
		min[0] = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > min[i - 1]) {
				dp[i] = Math.max(prices[i] - min[i - 1], dp[i - 1]);
				min[i] = min[i - 1];
			} else {
				min[i] = prices[i];
				dp[i] = dp[i - 1];
			}

		}
		return dp[prices.length - 1];

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		//		s.singleNumber(new int[] { 1, 2, 1, 3, 2, 5 });
		//		System.out.println(s.reverseWords(" 1"));
		System.out.println(s.maxProfit(new int[] { 1, 4, 2 }));
	}

}
