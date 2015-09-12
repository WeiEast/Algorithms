package leetCode;

import org.junit.Test;

import utils.ListNode;

public class RemoveDuplicatesfromSortedListTest {
	@Test
	public void testName() throws Exception {
		RemoveDuplicatesfromSortedList r = new RemoveDuplicatesfromSortedList();
		ListNode l = new ListNode(1);
		l.next = new ListNode(1);
		l.next.next = new ListNode(1);
		l.next.next.next = new ListNode(1);
		l.next.next.next.next = new ListNode(2);
		System.out.println(r.deleteDuplicates(l));

	}
}
