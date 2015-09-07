package leetCode;

import java.util.Stack;

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

		Stack<TreeNode> t = new Stack<TreeNode>();

		t.push(root);
		TreeNode pop = null;

		while (!t.isEmpty()) {
			pop = t.pop();
			System.out.println(pop.val);
			if (pop.right != null) {
				t.push(pop.right);
			}
			if (pop.left != null) {
				t.push(pop.left);
			}

		}

		return 0;
	}
}
