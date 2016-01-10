package leetCode.Medium;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class J094BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		mySolution(root, list);
		return list;
	}

	private void mySolution(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			mySolution(root.left, list);
		}
		list.add(root.val);
		if (root.right != null) {
			mySolution(root.right, list);
		}

	}

}
