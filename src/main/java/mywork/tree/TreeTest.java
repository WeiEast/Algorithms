package mywork.tree;

import java.util.LinkedList;
import java.util.Queue;

import lombok.extern.log4j.Log4j;
import utils.TreeNode;

@Log4j
public class TreeTest {

	/**
	 * 计算二叉树结点个数
	 * @param node
	 * @return
	 */
	public int countTreeNode(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return countTreeNode(node.left) + countTreeNode(node.right) + 1;

	}

	/**
	 * 计算二叉树深度
	 * @param node
	 * @return
	 */
	public int caculateDeep(TreeNode node) {
		if (node == null)
			return 0;
		int left = caculateDeep(node.left);
		int right = caculateDeep(node.right);
		return Math.max(left, right) + 1;
	}

	/**
	 * 分层遍历
	 * 
	 * BFS 广度优先遍历
	 * @param node
	 */
	public void printByStep(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		TreeNode tmp = null;
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			log.info(tmp.val);
			if (tmp.left != null) {
				queue.add(tmp.left);
			}
			if (tmp.right != null) {
				queue.add(tmp.right);
			}
		}

	}

	public static void main(String[] args) {
		TreeTest t = new TreeTest();
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(5);
		node.right.right = new TreeNode(4);
		t.printByStep(node);
		// log.info(t.caculateDeep(node));
		// log.info(t.countTreeNode(node));
	}

}
