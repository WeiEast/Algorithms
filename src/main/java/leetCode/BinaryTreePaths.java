package leetCode;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root == null)
			return result;
		dfs(root, result, String.valueOf(root.val));
		return result;
	}

	private void dfs(TreeNode root, List<String> result, String s) {
		String val = "";
		if (root.left == null && root.right == null) {
			result.add(s);
			return;
		}
		if (root.left != null) {
			val = "->" + root.left.val;
			dfs(root.left, result, s + val);
		}
		val = "";
		if (root.right != null) {
			val = "->" + root.right.val;
			dfs(root.right, result, s + val);
		}
		val = "";
	}

	public static void main(String[] args) {
		BinaryTreePaths b = new BinaryTreePaths();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.right = new TreeNode(5);
		t.right = new TreeNode(3);
		System.out.println(b.binaryTreePaths(t));
	}

}
