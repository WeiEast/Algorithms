package mywork.tree;

import utils.TreeNode;

/**
 * 求二叉树中节点的个数
 *
 */
public class NodeNumsOfTwo {
	private int getNodes(TreeNode t) {
		if (t == null)
			return 0;
		return getNodes(t.left) + getNodes(t.right) + 1;
	}

	public static void main(String[] args) {
		NodeNumsOfTwo n = new NodeNumsOfTwo();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.left.left = new TreeNode(7);
		t.left.right = new TreeNode(5);
		t.right = new TreeNode(4);
		System.out.println(n.getNodes(t));
	}
}
