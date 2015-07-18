package leetCode;

import utils.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

https://leetcode.com/problems/add-two-numbers/

给定两个链表代表两组非负数字 , 如 2->4->3 , 5->6->4 , 将两个链表数字求和 返回这个链表







 *
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return bestSolution(l1, l2);
	}

	private ListNode bestSolution(ListNode l1, ListNode l2) {

		int temp = 0;
		ListNode t = new ListNode(0);
		ListNode p = t;
		while (l1 != null || l2 != null) {

			temp += l1 == null ? 0 : l1.val;
			l1 = l1 == null ? null : l1.next;

			temp += l2 == null ? 0 : l2.val;
			l2 = l2 == null ? null : l2.next;

			p.next = new ListNode(temp % 10);
			p = p.next;
			temp /= 10;

		}

		if (temp == 1)
			p.next = new ListNode(temp);
		return t.next;

	}

}
