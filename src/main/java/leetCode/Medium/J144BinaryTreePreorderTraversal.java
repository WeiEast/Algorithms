package leetCode.Medium;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

/**
 * 求前序遍历 , 也就是根左右 , 太简单
 *
 */
public class J144BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		mySolution(root, list);
		return list;
	}

	private void mySolution(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		if (root.left != null) {
			mySolution(root.left, list);
		}
		if (root.right != null) {
			mySolution(root.right, list);
		}

	}

}
