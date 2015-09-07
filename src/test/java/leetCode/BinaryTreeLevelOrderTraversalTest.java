package leetCode;

import org.junit.Test;

import utils.TreeNode;

/**
 *
 */
public class BinaryTreeLevelOrderTraversalTest {

	@Test
	public void testName() throws Exception {
		testCase02();
	}

	public void testCase01() throws Exception {
		BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
		TreeNode t = new TreeNode(3);
		t.left = new TreeNode(9);
		t.right = new TreeNode(20);
		t.right.left = new TreeNode(15);
		t.right.right = new TreeNode(7);
		System.out.println(b.levelOrder(t));
	}

	public void testCase02() throws Exception {
		BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		t.left.left = new TreeNode(4);
		t.left.right = new TreeNode(5);
		System.out.println(b.levelOrder(t));
	}
}
