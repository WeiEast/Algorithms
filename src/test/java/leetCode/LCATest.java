package leetCode;

import org.junit.Test;

import utils.TreeNode;

public class LCATest {

	@Test
	public void testMethod() throws Exception {
		TreeNode l = new TreeNode(6);
		l.left = new TreeNode(2);
		l.right = new TreeNode(8);
		l.left.left = new TreeNode(0);
		l.left.right = new TreeNode(4);
		l.left.right.left = new TreeNode(3);
		l.left.right.right = new TreeNode(5);
		l.right.left = new TreeNode(7);
		l.right.right = new TreeNode(9);

		LCA lca = new LCA();
		System.out.println(lca.lowestCommonAncestor(l, new TreeNode(6),
				new TreeNode(8)).val);

	}

}
