package leetCode;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

	For example, this binary tree is symmetric:
	
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	But the following is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
	   
	思路 采用中序遍历
 *
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return mySolution(root);
	}

	private boolean mySolution(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		dfs(root, list);
		for (int i = 0; i < list.size() / 2; i++) {
			if (list.get(i) != list.get(list.size() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	private void dfs(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right != null) {
			list.add(0);
		}
		dfs(root.left, list);
		list.add(root.val);
		if (root.right == null && root.left != null) {
			list.add(0);
		}
		dfs(root.right, list);
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		t.left.left = new TreeNode(3);
		t.right.left = new TreeNode(2);
		SymmetricTree s = new SymmetricTree();
		System.out.println(s.isSymmetric(t));
	}
}
