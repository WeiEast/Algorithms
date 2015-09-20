package leetCode;

import utils.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.

	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	https://leetcode.com/problems/balanced-binary-tree/
 *
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		return mySolution(root);
	}

	private boolean mySolution(TreeNode root) {
		return dfs(root) != -1;

	}

	private int dfs(TreeNode root) {
		if (root == null)
			return 0;

		int left = dfs(root.left);
		int right = dfs(root.right);
		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		BalancedBinaryTree b = new BalancedBinaryTree();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.left.left = new TreeNode(7);
		t.left.right = new TreeNode(5);
		t.right = new TreeNode(4);
		System.out.println(b.isBalanced(t));
	}
}
