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
		dfs(root, 0, 0);
		return true;
	}

	private void dfs(TreeNode root, int left, int right) {
		if (root == null)
			return;
		System.out.println(root.val + "," + left + "," + right);
		if (root.left != null) {
			dfs(root.left, left, right);
		}
		if (root.right != null) {
			dfs(root.right, left, right);
		}
	}

	public static void main(String[] args) {
		BalancedBinaryTree b = new BalancedBinaryTree();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		// t.left.left.left = new TreeNode(7);`
		t.left.right = new TreeNode(5);
		t.right = new TreeNode(4);
		System.out.println(b.isBalanced(t));
	}
}
