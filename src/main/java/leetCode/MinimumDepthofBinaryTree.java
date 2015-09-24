package leetCode;

import utils.TreeNode;

/**
 * Given a binary tree, find its minimum depth.

	The minimum depth is the number of nodes 
	along the shortest path from the root node 
	down to the nearest leaf node.
	
	找到离根节点最近的叶结点路径 , 并求其深度
 *
 */
public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		return mySolution(root);
	}

	private int mySolution(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = mySolution(root.left);
		int right = mySolution(root.right);
		if (right != 0 && left != 0) {
			return Math.min(left, right) + 1;
		}
		return Math.max(left + 1, right + 1);
	}

}
