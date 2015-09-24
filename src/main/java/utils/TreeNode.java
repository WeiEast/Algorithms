package utils;

import lombok.NoArgsConstructor;

/**
 * 树
 *
 */
@NoArgsConstructor
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

}
