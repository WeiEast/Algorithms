package mywork.tree;

import utils.TreeNode;

/**
 * 后序遍历二叉树
 * 左右根
 *
 */
public class LrdOrderTreeNode {
	private void Lrd(TreeNode t) {
		if (t == null)
			return;
		Lrd(t.left);
		Lrd(t.right);
		System.out.println(t.val);
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.left.left = new TreeNode(7);
		t.left.right = new TreeNode(5);
		t.right = new TreeNode(4);
		t.right.left = new TreeNode(9);
		LrdOrderTreeNode l = new LrdOrderTreeNode();
		l.Lrd(t);
	}

}
