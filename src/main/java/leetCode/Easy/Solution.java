package leetCode.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import utils.ListNode;
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

	/**
	 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
	
	For example:
	
	Secret number:  "1807"
	Friend's guess: "7810"
	Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
	Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
	
	Please note that both secret number and friend's guess may contain duplicate digits, for example:
	
	Secret number:  "1123"
	Friend's guess: "0111"
	In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
	You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
	 * @param secret
	 * @param guess
	 * @return
	 */
	public String getHint(String secret, String guess) {
		return bestSolution(secret, guess);

	}

	private String bestSolution(String secret, String guess) {
		int len = secret.length();
		int A = 0;
		int B = 0;
		int count[] = new int[10];
		for (int i = 0; i < len; i++) {
			int s = secret.charAt(i) - '0';
			int g = guess.charAt(i) - '0';
			if (s == g) {
				A++;
			} else {
				if (count[g] > 0) { //如果g这里之前多出一个和g匹配的则B加1  
					B++;
				}

				if (count[s] < 0) { //如果之前少一个和s匹配的，则B加1  
					B++;
				}

				count[g]--; //缺一个和g匹配的  
				count[s]++; //s这里多一个匹配的  
			}
		}
		return A + "A" + B + "B";

	}

	private String uglySolution(String secret, String guess) {
		Map<Integer, Character> map = new HashMap<Integer, Character>();
		Map<Integer, Character> map2 = new HashMap<Integer, Character>();
		int count = 0;
		int count2 = 0;
		for (int i = 0; i < secret.length(); i++) {
			map.put(i, secret.charAt(i));
		}
		for (int i = 0; i < guess.length(); i++) {
			map2.put(i, guess.charAt(i));
		}
		for (int i = 0; i < guess.length(); i++) {
			if (map.get(i).equals(map2.get(i))) {
				count++;
				map.remove(i);
				map2.remove(i);
			}
		}

		for (Map.Entry<Integer, Character> entry : map2.entrySet()) {
			int flag = -1;
			int d = entry.getKey();
			for (Map.Entry<Integer, Character> entry2 : map.entrySet()) {
				char e = entry2.getValue();
				if (e == map2.get(d)) {
					flag = entry2.getKey();
					count2++;
					break;
				}
			}
			if (flag >= 0) {
				map.put(flag, '#');
				flag = 0;
			}
		}

		return count + "A" + count2 + "B";
	}

	/**
	 * Given a singly linked list, determine if it is a palindrome.
	 * 
	 * 简单思路为 , 第一遍遍历得到链表的长度 , 然后判断链表的长度为奇数还是偶数 , 然后分别处理 , 并用一个栈还保存已遍历的一半数据 , 方便出栈反序比较
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
		return J234MySolution(head);
	}

	private boolean J234MySolution(ListNode head) {
		ListNode temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		Stack<Integer> stack = new Stack<Integer>();
		//如果为偶数
		if (count % 2 == 0) {
			ListNode t = head;
			int k = count / 2;
			while (count != k) {
				stack.push(t.val);
				t = t.next;
				count--;
			}
			while (t != null) {
				int val = stack.pop();
				if (val != t.val) {
					return false;
				}
				t = t.next;
			}
			return true;
		} else {
			int k = (count + 1) / 2;
			ListNode t = head;
			while (count != k) {
				stack.push(t.val);
				t = t.next;
				count--;
			}
			t = t.next;
			while (t != null) {
				int val = stack.pop();
				if (val != t.val) {
					return false;
				}
				t = t.next;
			}
			return true;

		}

	}

	/**
	 * 
	 * Implement strStr().
	
		Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
		
		Subscribe to see which companies asked this question
		
		如果 needle 是 haystack 的子集那么返回第一次出现的位置 , 如果不是返回-1
		
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		if ("".equals(needle)) {
			return 0;
		}
		if (haystack.length() == 0 || needle.length() > haystack.length()) {
			return -1;
		}
		int left = 0;
		int right = 0;
		while (left != haystack.length() - 1) {
			char c = needle.charAt(0);
			for (int i = left; i < haystack.length(); i++) {
				if (c == haystack.charAt(i)) {
					right = 0;
					for (int j = i; j < needle.length() + i; j++) {
						if (needle.charAt(right) != haystack.charAt(j)) {
							break;
						}
						right++;
					}
					if (right - left == needle.length()) {
						return i;
					}
				}
			}
			left++;
		}
		return -1;

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		//		System.out.println(s.canWinNim(5));
		//		System.out.println(s.getHint("1234", "0111"));
		//		ListNode l = new ListNode(1);
		//		l.next = new ListNode(2);
		//		l.next.next = new ListNode(3);
		//		l.next.next.next = new ListNode(4);
		//		l.next.next.next.next = new ListNode(5);
		//		l.next.next.next.next.next = new ListNode(4);
		//		l.next.next.next.next.next.next = new ListNode(3);
		//		l.next.next.next.next.next.next.next = new ListNode(2);
		//		l.next.next.next.next.next.next.next.next = new ListNode(1);
		//		System.out.println(9 / 2);
		//		System.out.println(s.isPalindrome(l));
		System.out.println(s.strStr("abcdqqq", "cdq"));
	}
}
