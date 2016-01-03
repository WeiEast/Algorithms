package leetCode.Easy;

import utils.TreeNode;

/**
 * @author 
 * 
 *
 */
public class Solution {

	/**
	 * 
	 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
	
	Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
	
	For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
	
	https://leetcode.com/problems/nim-game/
	 * @param n
	 * @return
	 */
	public boolean canWinNim(int n) {
		return n % 4 != 0;
	}

	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	
	For example, this binary tree is symmetric:
	
	1
	/ \
	2   2
	/ \ / \
	3  4 4  3
	But the following is not:
	1
	/ \
	2   2
	\   \
	3    3
	Note:
	Bonus points if you could solve it both recursively and iteratively.
	
	confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
	
	Subscribe to see which companies asked this question
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return symmetric(root.left, root.right);

	}

	public boolean symmetric(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if ((t1 == null && t2 != null) || (t1 != null && t2 == null) || t1.val != t2.val)
			return false;
		return symmetric(t1.left, t2.right) && symmetric(t1.right, t2.left);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.canWinNim(5));
	}
}
