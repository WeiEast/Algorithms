package mywork.list;

import lombok.extern.log4j.Log4j;
import utils.ListNode;

@Log4j
public class ListNodeTest {

	/**
	 * 求单链表中结点的个数
	 * O(n)
	 */
	public int countListNode(ListNode node) {
		int result = 0;
		while (node != null) {
			result++;
			node = node.next;
		}
		return result;
	}

	/**
	 * 链表原地翻转
	 * 
	 */
	public ListNode reverseListNode(ListNode node) {

		ListNode pre = null;// 翻转后的头结点
		while (node != null) {
			ListNode next = node.next;
			node.next = pre;
			pre = node;
			node = next;
		}
		return pre;
	}

	/**
	 * 找到倒数第k个结点
	 * 
	 * @param k
	 * @return
	 */
	public ListNode findCountListByLast(int k, ListNode node) {
		ListNode head = node;
		ListNode head2 = node;

		while (k > 0) {
			head = head.next;
			k--;
		}

		while (head != null) {
			head = head.next;
			head2 = head2.next;
		}
		return head2;

	}

	/**
	 * 寻找链表中间结点
	 * @param node
	 * @return
	 */
	public ListNode findMidOfListNode(ListNode node) {
		ListNode l1 = node;
		ListNode l2 = node;

		while (l1 != null) {
			l1 = l1.next;
			l2 = l2.next;
			if (l1 != null)
				l1 = l1.next;
		}
		return l2;
	}

	/**
	 * 后续遍历单链表
	 * 
	 * 使用递归
	 * @param node
	 */
	public void printListFromLast(ListNode node) {
		if (node == null) {
			return;
		}
		printListFromLast(node.next);
		log.info(node.val);
	}

	/**
	 * 合并两个有序的链表
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode mergeSortedListNode(ListNode list1, ListNode list2) {
		ListNode result = new ListNode(0);
		ListNode node = result;
		while (list1 != null && list2 != null) {
			if (list1.val > list2.val) {
				node.next = new ListNode(list2.val);
				node = node.next;
				list2 = list2.next;
			} else {
				node.next = new ListNode(list1.val);
				node = node.next;
				list1 = list1.next;
			}
		}
		while (list1 != null) {
			node.next = new ListNode(list1.val);
			list1 = list1.next;
			node = node.next;
		}
		while (list2 != null) {
			node.next = new ListNode(list2.val);
			list2 = list2.next;
			node = node.next;
		}
		return result.next;
	}

	/**
	 * Given a linked list, remove the nth node from the end of list and return its head.
	
		For example,
	
	   Given linked list: 1->2->3->4->5, and n = 2.
	
	   After removing the second node from the end, the linked list becomes 1->2->3->5.
	   
	   	删除链表中倒数第N个元素 n>0
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node1 = head;
		ListNode node2 = head;
		ListNode p = new ListNode(0);
		p.next = head;
		while (n > 0) {
			node1 = node1.next;
			n--;
		}
		ListNode pre = p;
		while (node1 != null) {
			pre = pre.next;
			node1 = node1.next;
			node2 = node2.next;
		}
		pre.next = node2.next;
		return p.next;
	}

	/**
	 * 设置两个指针 , 第一个指针每次走一步 , 第二个指针每次走两步 , 有环必相同
	 * @param node
	 * @return
	 */
	public boolean isListNodeCycle(ListNode node) {

		ListNode head1 = node;
		ListNode head2 = node;
		while (head1 != null) {
			head1 = head1.next;
			head2 = head2.next;
			if (head1 != null) {
				head1 = head1.next;
				if (head1 == head2) {
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * 写出一个方法删除一个结点 , 除了尾结点
	 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
	
		Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
	 * @param node
	 */
	public void deleteNode(ListNode node) {
		ListNode head = node;
		head.val = node.next.val;
		head.next = node.next.next;
	}

	/**
	 * 单链表中删除 重复结点
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode t = new ListNode(head.val + 1);
		int a = t.val;
		t.next = head;
		ListNode pre = t;
		while (head != null) {
			if (a == head.val) {
				pre.next = head.next;
			} else {
				a = head.val;
				pre = head;
			}
			head = head.next;
		}
		return t.next;
	}

	/**
	 * 获取两个链表的交叉点 , 思路:先将两个链表的长度保持一致 , 这样再找交叉点 步长一致
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = 0;
		int lenB = 0;

		ListNode lA = headA;
		ListNode lB = headB;

		while (lA != null) {
			lA = lA.next;
			lenA++;
		}
		while (lB != null) {
			lB = lB.next;
			lenB++;
		}
		int diff = Math.abs(lenA - lenB);
		if (lenA > lenB) {
			while (diff > 0) {
				headA = headA.next;
				diff--;
			}
		} else {
			while (diff > 0) {
				headB = headB.next;
				diff--;
			}
		}

		while (headA != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;

	}

	/**
	 * 删除链表中所有数值等于目标数的结点
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode p = pre;
		while (p.next != null) {
			if (p.next.val == val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
		return pre.next;

	}

	/**
	 * 链表插入排序
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;
		ListNode l1 = new ListNode(head.val);
		ListNode k1 = l1;
		head = head.next;
		ListNode pre = null;
		while (head != null) {
			int key = head.val;
			k1 = l1;
			while (k1 != null && k1.val < key) {
				pre = k1;
				k1 = k1.next;
			}
			if (k1 != null) {
				ListNode list = new ListNode(key);
				list.next = k1;
				if (pre == null) {
					l1 = list;
				} else {
					pre.next = new ListNode(key);
					pre.next.next = k1;
				}
			} else {
				pre.next = new ListNode(key);
			}
			pre = null;
			head = head.next;
		}
		return l1;

	}

	/**
	 * 返回链表环结点
	 * 
	 * 
	 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	
		Note: Do not modify the linked list.
	
		Follow up:
		Can you solve it without using extra space?
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode n1 = head;
		ListNode n2 = head;

		while (n1 != null) {

		}

		return null;
	}

	public static void main(String[] args) {
		ListNodeTest l = new ListNodeTest();
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		ListNode listNode2 = new ListNode(2);
		listNode2.next = new ListNode(4);

		ListNode listnode3 = new ListNode(3);
		listnode3.next = new ListNode(2);
		listnode3.next.next = new ListNode(4);
		listnode3.next.next.next = listnode3.next;

		ListNode listNode4 = new ListNode(0);
		listNode4.next = new ListNode(1);
		listNode4.next.next = new ListNode(0);

		ListNode listNode5 = new ListNode(5);
		listNode5.next = new ListNode(7);
		listNode5.next.next = new ListNode(6);
		log.info(listnode3);
		// log.info(l.insertionSortList(listNode5));
		// log.info(l.removeElements(listNode4, 0));
		// log.info(l.deleteDuplicates(listNode4));

		// log.info(l.removeNthFromEnd(listNode, 0));

		// log.info(l.isListNodeCycle(listNode));
		// log.info(l.mergeSortedListNode(listNode, listNode2));
		// l.printListFromLast(listNode);
		// log.info(l.findMidOfListNode(listNode));
		// log.info(l.findCountListByLast(3, listNode));
		// log.info(l.countListNode(listNode));
		// log.info(l.reverseListNode(listNode));
	}
}
