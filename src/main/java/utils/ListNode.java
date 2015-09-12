package utils;

import lombok.Data;

/**
 * 链表
 *
 */
@Data
public class ListNode {
	public int val;

	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

}
