package leetCode;

import utils.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


	For example, the following two linked lists:
	
	A:          a1 → a2
	                   ↘
	                     c1 → c2 → c3
	                   ↗            
	B:     b1 → b2 → b3
	begin to intersect at node c1.
	
	
	Notes:
	
	If the two linked lists have no intersection at all, return null.
	The linked lists must retain their original structure after the function returns.
	You may assume there are no cycles anywhere in the entire linked structure.
	Your code should preferably run in O(n) time and use only O(1) memory.
	https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		return mySolution(headA, headB);
	}

	/**
	 * @param headA
	 * @param headB
	 * @return
	 */
	private ListNode mySolution(ListNode headA, ListNode headB) {
		ListNode result = null;
		int lenA = getLen(headA);
		int lenB = getLen(headB);
		if (lenA > lenB) {
			for (int i = 0; i < lenA - lenB; i++) {
				headA = headA.next;
			}
		} else {
			for (int i = 0; i < lenB - lenA; i++) {
				headB = headB.next;
			}
		}
		while (headA != null) {
			if (headA == headB) {
				result = headA;
				break;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return result;
	}

	/**
	 * 求head长度
	 * @param head
	 * @return
	 */
	private int getLen(ListNode head) {
		int n = 0;
		while (head != null) {
			head = head.next;
			n++;
		}
		return n;
	}

}
