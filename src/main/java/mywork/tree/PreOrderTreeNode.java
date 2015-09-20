package mywork.tree;

import utils.TreeNode;

/**
 * 前序遍历二叉树
 * 
 * 根左右
 *
 */
public class PreOrderTreeNode {
	private void PreOrderTree(TreeNode t) {
		if (t == null)
			return;
		System.out.println(t.val);
		PreOrderTree(t.left);
		PreOrderTree(t.right);
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.left.left = new TreeNode(7);
		t.left.right = new TreeNode(5);
		t.right = new TreeNode(4);
		t.right.left = new TreeNode(9);
		PreOrderTreeNode p = new PreOrderTreeNode();
		p.PreOrderTree(t);
	}
}
