package leetCode;

import utils.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.
	
	给定一个排序linkedlist , 删除所有重复结点
	
	
	https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	
 *
 */
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		return mySolution(head);
	}

	private ListNode mySolution(ListNode head) {
		if (head == null)
			return null;
		ListNode t = new ListNode(0);
		t.next = head;
		int current = head.val;
		while (head != null) {
			if (head.next != null && head.next.val == current) {
				head.next = head.next.next;
			} else if (head.next != null) {
				current = head.next.val;
				head = head.next;
			} else {
				return t.next;
			}
		}
		return t.next;

	}
}
