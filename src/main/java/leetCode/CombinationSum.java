package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
https://leetcode.com/problems/combination-sum/
 *
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(candidates, target, 0, 0, new ArrayList<Integer>(), result);
		return result;
	}

	/**
	 * 
	 * @param candidates
	 * @param target
	 * @param mid
	 * @param pos
	 * @param list
	 * @param result
	 */
	private void dfs(int[] candidates, int target, int mid, int pos,
			List<Integer> list, List<List<Integer>> result) {
		if (target == mid) {
			result.add(new ArrayList<Integer>(list));
		}
		if (mid > target) {
			return;
		}
		for (int i = pos; i < candidates.length; i++) {
			int tmp = candidates[i];
			list.add(tmp);
			mid += tmp;
			dfs(candidates, target, mid, pos, list, result);
			list.remove(list.size() - 1);
			mid -= candidates[pos];
			if (mid < target) {
				pos++;
			}
		}

	}
}
