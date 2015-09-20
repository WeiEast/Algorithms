package mywork.tree;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

/**
 * 广度优先算法计算树
 *
 */
public class BfsTreeNode {
	private void bfs(TreeNode t) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(t);
		TreeNode c = null;
		while (!q.isEmpty()) {
			c = q.poll();
			System.out.println(c.val);
			if (c.left != null) {
				q.add(c.left);
			}
			if (c.right != null) {
				q.add(c.right);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.left.left = new TreeNode(7);
		t.left.right = new TreeNode(5);
		t.right = new TreeNode(4);
		t.right.left = new TreeNode(9);

		BfsTreeNode b = new BfsTreeNode();
		b.bfs(t);
	}
}
