package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

	For example:
	Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its level order traversal as:
	[
	  [3],
	  [9,20],
	  [15,7]
	]
 *	confused what "{1,#,2,3}" means?
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<List<Integer>>();
		Queue<TreeNode> t = new LinkedList<TreeNode>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		t.add(root);
		List<Integer> mid = new ArrayList<Integer>();
		TreeNode right = root;
		TreeNode pos = null;
		TreeNode tmp = null;
		while (!t.isEmpty()) {
			tmp = t.peek();
			t.poll();
			mid.add(tmp.val);
			if (tmp == right) {
				list.add(mid);
				mid = new ArrayList<Integer>();
				if (tmp.right != null)
					right = tmp.right;
				else if (tmp.left != null)
					right = tmp.left;
				else
					right = pos;
			}

			if (tmp.left != null) {
				t.add(tmp.left);
				pos = tmp.left;
			}
			if (tmp.right != null) {
				t.add(tmp.right);
				pos = tmp.right;
			}

		}
		return list;

	}
}
