package mywork.tree;

import utils.TreeNode;

/**
 * 求二叉树的深度
 *
 */
public class MaxTreeDeep {
	private int getMaxDeepth(TreeNode t) {
		if (t == null)
			return 0;
		int left = getMaxDeepth(t.left);
		int right = getMaxDeepth(t.right);
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		MaxTreeDeep m = new MaxTreeDeep();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.left.left = new TreeNode(7);
		t.left.right = new TreeNode(5);
		t.right = new TreeNode(4);
		System.out.println(m.getMaxDeepth(t));
	}
}
