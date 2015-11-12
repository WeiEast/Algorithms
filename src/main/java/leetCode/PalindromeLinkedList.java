package leetCode;

import utils.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.

	Follow up:
	Could you do it in O(n) time and O(1) space?
	
	Subscribe to see which companies asked this question
 *
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		return mySolution(head);
	}

	private boolean mySolution(ListNode head) {

		ListNode p1 = head;
		ListNode p2 = head;

		while (p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
			if (p2 != null) {
				p2 = p2.next;
			}
		}

		ListNode pre = null;
		while (p1 != null) {
			ListNode next = p1.next;
			p1.next = pre;
			pre = p1;
			p1 = next;
		}

		return false;
	}

	public static void main(String[] args) {
		PalindromeLinkedList p = new PalindromeLinkedList();
	}

}
