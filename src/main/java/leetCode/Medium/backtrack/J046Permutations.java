package leetCode.Medium.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yupeng on 4/12/16.
 */
public class J046Permutations {

    public List<List<Integer>> permute(int[] nums) {
        return solution(nums);
    }

    private List<List<Integer>> solution(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(nums, result, list, 0);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> list, int i) {
        if (i > nums.length - 1) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            dfs(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        J046Permutations j046Permutations = new J046Permutations();
        List<List<Integer>> solution = j046Permutations.solution(new int[]{1, 2, 3});
        System.out.println(solution);


    }

}
