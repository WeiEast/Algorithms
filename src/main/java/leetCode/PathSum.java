package leetCode;

import utils.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		return bestSolution(root, sum);
	}

	private boolean bestSolution(TreeNode root, int sum) {
		if (root == null) {
			return false;

		}
		if (root.val == sum && (root.left == null && root.right == null)) {
			return true;
		}
		return bestSolution(root.left, sum - root.val) || bestSolution(root.right, sum - root.val);
	}

	@SuppressWarnings("unused")
	private boolean mySolution(TreeNode root, int sum) {
		if (root == null)
			return false;
		return dfs(root, sum - root.val, false);
	}

	private boolean dfs(TreeNode root, int sum, boolean flag) {
		if (root.left == null && root.right == null && !flag) {
			flag = sum == 0 ? true : false;
		}
		if (root.left != null) {
			sum -= root.left.val;
			flag = dfs(root.left, sum, flag);
			sum += root.left.val;
		}
		if (root.right != null) {
			sum -= root.right.val;
			flag = dfs(root.right, sum, flag);
			sum += root.right.val;
		}
		return flag;
	}

}
