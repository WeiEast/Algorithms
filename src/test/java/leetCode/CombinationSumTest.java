package leetCode;

import org.junit.Test;

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
public class CombinationSumTest {
	@Test
	public void testCombina() throws Exception {
		CombinationSum c = new CombinationSum();
		System.out.println(c.combinationSum(new int[] { 2,3,6,7 }, 7));
	}
}
