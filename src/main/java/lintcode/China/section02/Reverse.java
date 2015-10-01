package lintcode.China.section02;

import utils.ListNode;

/**
 * 容易 翻转链表

	41% 通过
	翻转一个链表
	
	您在真实的面试中是否遇到过这个题？ Yes
	样例
	给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
	
	挑战
	在原地一次翻转完成
	http://www.lintcode.com/zh-cn/problem/reverse-linked-list/
 *
 */
public class Reverse {
	public ListNode reverse(ListNode head) {
		return mySolution(head);
	}

	private ListNode mySolution(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode l = new ListNode(3);
		l.next = new ListNode(2);
		l.next.next = new ListNode(1);
		Reverse r = new Reverse();
		System.out.println(r.reverse(l));
	}
}
