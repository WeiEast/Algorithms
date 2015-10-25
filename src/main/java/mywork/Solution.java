package mywork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;

import leetCode.CombinationSum;
import lombok.extern.log4j.Log4j;

@Log4j
public class Solution {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(list, result, candidates, target, 0, 0);
		return result;

	}

	public void dfs(List<Integer> list, List<List<Integer>> result, int[] candidates, int target, int pos, int mid) {
		if (mid == target) {
			result.add(new ArrayList<Integer>(list));
		}
		if (mid > target) {
			return;
		}

		for (int i = pos; i < candidates.length; i++) {
			int k = candidates[i];
			list.add(k);
			mid += k;
			dfs(list, result, candidates, target, pos, mid);
			list.remove(list.size() - 1);
			mid -= candidates[pos];
			if (mid < target) {
				pos++;
			}
		}

	}

	public static void main(String[] args) {
		int[] candidate = new int[] { 2, 2, 3 };
		int target = 7;
		CombinationSum s = new CombinationSum();
		List<List<Integer>> combinationSum = s.combinationSum(candidate, target);
		log.info(JSON.toJSONString(combinationSum));
	}
}
