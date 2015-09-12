package leetCode;

import utils.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 *
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		return bestSolution(head, n);
	}

	private ListNode bestSolution(ListNode head, int n) {
		ListNode one = head;
		ListNode two = head;

		while (n > 0) {
			one = one.next;
			n--;
		}
		if (one == null) {
			return two.next;
		}
		while (one != null) {
			one = one.next;
			two = two.next;
		}
		two.next = two.next.next;
		return two;
	}

	private ListNode uglySolution(ListNode head, int n) {
		ListNode t = new ListNode(0);
		t.next = head;
		ListNode tmp = null;
		ListNode pre = null;
		int tt = n;
		while (head != null) {
			tmp = head;
			while (tt != 0 && tmp != null) {
				tt--;
				tmp = tmp.next;
			}
			if (head == t.next && tt == 0 && tmp == null) {
				t.next = t.next.next;
				return t.next;
			}
			if (tt == 0 && tmp == null) {
				pre.next = pre.next.next;
				return t.next;
			} else {
				tt = n;
			}
			pre = head;
			head = head.next;

		}
		return t.next;
	}
}
