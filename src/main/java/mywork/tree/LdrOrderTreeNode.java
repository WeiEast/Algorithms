package mywork.tree;

import utils.TreeNode;

/**
 *中序遍历二叉树
 *
 */
public class LdrOrderTreeNode {
	private void Ldr(TreeNode t) {
		if (t == null)
			return;
		Ldr(t.left);
		System.out.println(t.val);
		Ldr(t.right);
	}
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.left.left = new TreeNode(7);
		t.left.right = new TreeNode(5);
		t.right = new TreeNode(4);
		t.right.left = new TreeNode(9);
		LdrOrderTreeNode l = new LdrOrderTreeNode();
		l.Ldr(t);
	}
}
