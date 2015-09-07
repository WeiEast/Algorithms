package leetCode;

import org.junit.Test;

import utils.TreeNode;

public class PathSumTest {

	@Test
	public void test() throws Exception {
		testCase02();
	}

	public void testCase01() throws Exception {
		PathSum p = new PathSum();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.right = new TreeNode(3);
		t.left.right.right = new TreeNode(4);
		t.left.right.right.right = new TreeNode(5);
		System.out.println(p.hasPathSum(t, 3));
	}

	public void testCase02() throws Exception {
		PathSum p = new PathSum();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(-2);
		t.right = new TreeNode(3);
		System.out.println(p.hasPathSum(t, 1));
	}
}
