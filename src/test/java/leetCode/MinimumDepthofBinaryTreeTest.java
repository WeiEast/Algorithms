package leetCode;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.TreeNode;

/**
 * 
 *
 */
public class MinimumDepthofBinaryTreeTest {
	@Test
	public void testName() throws Exception {
		MinimumDepthofBinaryTree m = new MinimumDepthofBinaryTree();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(2);
		t.left.left.left = new TreeNode(2);
		t.left.left.left.left = new TreeNode(2);
		t.right = new TreeNode(3);

		m.minDepth(t);
	}
}
