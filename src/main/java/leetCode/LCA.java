package leetCode;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both v
 * and w as descendants (where we allow a node to be a descendant of itself).”
 * 
 *        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
    For example, the
 * lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of
 * nodes 2 and 4 is 2, since a node can be a descendant of itself according to
 * the LCA definition.
 */
public class LCA {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p == null || root == null || q == null) {
			return null;
		}
		List<TreeNode> tree = new ArrayList<TreeNode>();
		List<TreeNode> tree2 = new ArrayList<TreeNode>();
		TreeNode tmp = root;
		getList(tree, p, tmp);
		tmp = root;
		getList(tree2, q, tmp);
		TreeNode result = null;
		for (int i = 0; i < Math.min(tree.size(), tree2.size()); i++) {
			if (tree.get(i).val == tree2.get(i).val) {
				result = tree.get(i);
			}

		}
		return result;

	}

	private void getList(List<TreeNode> list, TreeNode p, TreeNode tmp) {
		boolean flag = true;
		while (flag) {
			if (tmp.val > p.val) {
				list.add(new TreeNode(tmp.val));
				tmp = tmp.left;
			} else if (tmp.val < p.val) {
				list.add(new TreeNode(tmp.val));
				tmp = tmp.right;
			} else {
				list.add(new TreeNode(tmp.val));
				flag = false;
			}
		}
	}
}
